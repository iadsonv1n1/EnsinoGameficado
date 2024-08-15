package br.ufrn.imd;

import java.io.FileInputStream;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;


public class Banco {

    public static FirebaseDatabase database;

    public void inicializarBanco() {
        try {
            // Inicializar o Firebase
            FileInputStream serviceAccount = new FileInputStream("path/serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://app-classroom-project-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            // Obter instância do Realtime Database
            this.database = FirebaseDatabase.getInstance();

        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }


    public static void adicionarProfessor(Professor professor) {
        DatabaseReference ref = database.getReference("profs");

        DatabaseReference newProf = ref.push();

        newProf.child("nome").setValueAsync(professor.getNome());
        newProf.child("email").setValueAsync(professor.getEmail());
    }

    public static void lerDados(FirebaseDatabase database) {
        // Referência à localização no banco de dados
        DatabaseReference ref = database.getReference("users");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot.getChildren().forEach(e -> System.out.println(e));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("Erro ao ler dados: " + databaseError.getMessage());
            }
        });

        // Ler dados uma única vez
        /*ref.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                for (com.google.firebase.database.DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    String firstName = userSnapshot.child("firstName").getValue(String.class);
                    String lastName = userSnapshot.child("lastName").getValue(String.class);
                    Long age = userSnapshot.child("age").getValue(Long.class);

                    System.out.println("User: " + firstName + " " + lastName + ", Age: " + age);
                }
            }

            @Override
            public void onCancelled(com.google.firebase.database.DatabaseError databaseError) {
                System.err.println("Erro ao ler dados: " + databaseError.getMessage());
            }

        });*/
    }

}

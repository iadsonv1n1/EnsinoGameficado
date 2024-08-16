package br.ufrn.imd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

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

        DatabaseReference newProf = ref.child(normalizeEmail(professor.getEmail()));

        newProf.child("nome").setValueAsync(professor.getNome());
        newProf.child("email").setValueAsync(professor.getEmail());
    }

    public static String normalizeEmail(String email) {
        return email.replace(".", "");
    }

    public static void adicionarTurma(Turma turma) {
        String profId = normalizeEmail(turma.getProfessor());

        DatabaseReference ref = database.getReference("profs/" + profId + "/turmas");
        DatabaseReference newTurma = ref.child(turma.getNome());

        // Usar setValue com CompletionListener para obter feedback sobre a operação
        newTurma.child("codigo").setValue(turma.getCode(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    System.err.println("Erro ao adicionar turma: " + databaseError.getMessage());
                } else {
                    System.out.println("Turma adicionada com sucesso.");
                }
            }
        });
    }





    public static CompletableFuture<String> procurarProfessor(String nomeProfessor) {
        CompletableFuture<String> future = new CompletableFuture<>();
        DatabaseReference ref = database.getReference("profs");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String emailEncontrado = null;

                for (DataSnapshot professorSnapshot : dataSnapshot.getChildren()) {
                    String nome = professorSnapshot.child("nome").getValue(String.class);
                    if (nome != null && nome.equalsIgnoreCase(nomeProfessor)) {
                        emailEncontrado = professorSnapshot.child("email").getValue(String.class);
                        break;
                    }
                }

                if (emailEncontrado != null) {
                    future.complete(emailEncontrado); // Completa o future com o email encontrado
                } else {
                    future.complete(null); // Completa o future com null se não encontrado
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("Erro ao buscar professor: " + databaseError.getMessage());
                future.completeExceptionally(databaseError.toException()); // Completa o future com exceção em caso de erro
            }
        });

        return future;
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

package dominio;

import repositorio.TurmaRepo;

import java.util.List;

public record Aluno(String username, String password){

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


package br.ufrn.imd;

public class Professor {
    private String nome;
    private static String email;

    Professor(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        return email.equals(professor.email);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}

package dominio;

public record Professor(String username, String password) {

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package Class01_challenge;

public class ApiAuthenticationService {

    private String id;
    private String password;

    public ApiAuthenticationService() {
        this.id = "gustavo";
        this.password = "123";
    }

    public boolean validateUserAndPassword (String idUser, String passwordUser) {
        return id.equals(idUser) && password.equals(passwordUser);
    }
}

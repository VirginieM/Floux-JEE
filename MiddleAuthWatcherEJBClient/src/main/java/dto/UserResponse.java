package dto;

import java.io.Serializable;

import dao.Role;

public class UserResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isValidAuth() {
        return validAuth;
    }

    public void setValidAuth(boolean validAuth) {
        this.validAuth = validAuth;
    }

    private String Login;
    private Role role;
    private boolean validAuth;

    public UserResponse() {

    }

    public UserResponse(String userLogin, boolean validAuth, Role role) {
        this.Login = userLogin;
        this.validAuth = validAuth;
        this.role = role;
    }

}

package HomeWorks.lesson11.entity;

public class User {
//    private String name;
//    private String surName;
    private String login;
    private String password;
    private String status; // register, authorize, work, exit

    public User() {
        status = "authorize";
    }

    public User(String login, String password, String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

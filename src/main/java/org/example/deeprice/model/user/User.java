package org.example.deeprice.model.user;

/**
 *
 * @author Maurice Amon
 */

public class User {

    private String username;

    private String email;

    private String password;

    private EternalPreferences eternalPreferences;

    private static User instance;

    private User() {

    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public EternalPreferences getEternalPreferences() {
        return eternalPreferences;
    }

    public void setEternalPreferences(EternalPreferences eternalPreferences) {
        this.eternalPreferences = eternalPreferences;
    }

}

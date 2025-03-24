package org.example.deeprice.model.user;

/**
 *
 * @author Maurice Amon
 */

public class User {

    private String username;

    private String password;

    private EternalPreferences eternalPreferences;

    public User(String username, String password, EternalPreferences eternalPreferences) {
        this.username = username;
        this.password = password;
        this.eternalPreferences = eternalPreferences;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

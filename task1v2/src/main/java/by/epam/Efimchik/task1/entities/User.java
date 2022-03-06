package by.epam.Efimchik.task1.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int userId;
    private String email;
    private String username;
    private String password;
    private boolean userSession = false;

    public static int userObjectCounter = 0;
    {
        userObjectCounter++;
    }

    public User () {}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSession=" + userSession +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userSession == user.userSession && Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, username, password, userSession);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isUserSession() {
        return userSession;
    }

    public void setUserSession(boolean userSession) {
        this.userSession = userSession;
    }

    public User(int userId, String email, String username, String password, boolean userSession) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userSession = userSession;
    }
}

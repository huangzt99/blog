package com.hzt.pojo;

public class User {
    public long id;
    String username;
    String password;
    String email;
    String type;
    String photo;
    String nikeName;

    public User() {
    }

    public User(long id){
        this.id=id;
    }

    public User(long id, String username, String password, String email, String type, String photo, String nikeName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
        this.photo = photo;
        this.nikeName = nikeName;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", photo='" + photo + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}

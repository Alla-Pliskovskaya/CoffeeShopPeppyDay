package com.itproger.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "App_User")
public class AppUser
{
    @Id
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Column(name = "user_id", nullable = false, unique = true)
    private Long user_id;

    @Column(name = "login", length = 36, nullable = false, unique = true)
    private String login;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "full_name", length = 255, nullable = true)
    private String full_name;

    public AppUser()
    {

    }

    public AppUser(String login, String password, String full_name)
    {
        this.login = login;
        this.password = password;
        this.full_name = full_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long userId) {
        this.user_id = userId;
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

    public void setPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }
}

package com.kostya.chatProject.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Костя on 15.07.2017.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Authority> authorities;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Set<Authority> getAuthorities() {
        return authorities;
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

    public long getId() {
        return id;
    }

    public void addAuthority(String authority){
        if(authorities == null){
            authorities = new HashSet<>();
        }
        Authority newAuthority = new Authority();
        newAuthority.setAuthority(authority);

        this.authorities.add(newAuthority);
    }
}

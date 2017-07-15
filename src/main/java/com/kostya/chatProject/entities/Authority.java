package com.kostya.chatProject.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Костя on 15.07.2017.
 */

@Entity
@Table(name = "user_authorities")
public class Authority implements GrantedAuthority{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "role")
    private String role;

    public void setAuthority(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}

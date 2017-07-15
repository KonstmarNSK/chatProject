package com.kostya.chatProject.repositories.interfaces;

import com.kostya.chatProject.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Костя on 15.07.2017.
 */
public interface UserRepository{
    void saveUser(User user);
    User getUserById(long id);
    User getUserByUsername(String username);
}

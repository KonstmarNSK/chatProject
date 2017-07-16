package com.kostya.chatProject.controllers.authentication;

import com.kostya.chatProject.entities.User;
import com.kostya.chatProject.repositories.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Костя on 16.07.2017.
 */

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String getPage(){
        return "/register";
    }

    @PostMapping
    public String registerAndRedirect(@ModelAttribute("user")User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/register";
        }

        if (userRepository.getUserByUsername(user.getLogin()) != null) {
            bindingResult.rejectValue("email", "", "This login is already registered");
            return "/register";
        }

        user.addAuthority("ROLE_USER");
        userRepository.saveUser(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(userRepository.getUserByUsername(user.getLogin()), user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        redirectAttributes.addFlashAttribute("user", user);

        return "redirect:/home";
    }
}

package com.itproger.blog.controllers;

import com.itproger.blog.models.AppUser;
import com.itproger.blog.repo.UserRepository;
import com.itproger.blog.utils.EncryptedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistryController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registry")
    public String registry(Model model)
    {
        return "registry";
    }

    @PostMapping("/registry")
    public String doRegistry(@RequestParam String login, @RequestParam String password, @RequestParam String full_name, Model model)
    {
        String encryptedPassword = EncryptedPasswordUtils.EncryptPassword(password);
        AppUser user = new AppUser(login, encryptedPassword, full_name);
        userRepository.save(user);

        return "registrySuccessful";
    }
}

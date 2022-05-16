package com.itproger.blog.controllers;

import com.itproger.blog.models.AppUser;
import com.itproger.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class SearchUserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String userSearch(Model model)
    {
        model.addAttribute("user", new AppUser());

        return "userSearch";
    }

    @PostMapping("/users")
    public String userSearch(AppUser user, Model model, @RequestParam String login)
    {
        long startTime = System.nanoTime();
        List<AppUser> foundUsers = userRepository.findAppUserByLogin(login);
        System.out.println(foundUsers);
        model.addAttribute("foundUsers", foundUsers);
        long endTime = System.nanoTime();
        double time = (double) (endTime-startTime) / 1000000;
        System.out.println("Total execution time: " + time + " ms");
        return "userSearch";
    }
}

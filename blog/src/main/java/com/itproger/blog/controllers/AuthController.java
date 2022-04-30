package com.itproger.blog.controllers;

import java.security.Principal;

import com.itproger.blog.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController
{
    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/auth/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal)
    {
        User user = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/auth/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model)
    {
        model.addAttribute("title", "Logout");

        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/auth/user", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal)
    {
        // After user login successfully.
        String login = principal.getName();
        System.out.println("Login: " + login);
        User user = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(user);

        model.addAttribute("userInfo", userInfo);

        return "userPage";
    }

    @RequestMapping(value = "/auth/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal)
    {
        if (principal != null)
        {
            User user = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(user);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi, " + principal.getName() //
                    + ",<br> You do not have permission to access this page!";

            model.addAttribute("message", message);
        }

        return "403Page";
    }
}

package com.itproger.blog.controllers;

import com.itproger.blog.models.AppUser;
import com.itproger.blog.repo.UserRepository;
import com.itproger.blog.utils.EncryptedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Transactional
    @GetMapping("/add")
    public void addUsers(Model model)
    {
        String password = "012345678";
        for (int i = 0; i < 1000; i++)
        {
            String login = getRandomLogin();
            String full_name = getRandomName();
            String encryptedPassword = EncryptedPasswordUtils.EncryptPassword(password);
            AppUser user = new AppUser(login, encryptedPassword, full_name);
            userRepository.save(user);
        }
    }

    public static String getRandomLogin()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public static String getRandomName()
    {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> firstNames = new ArrayList<>(Arrays.asList("Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"));
        List<String> lastNames = new ArrayList<>(Arrays.asList("Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"));
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        stringBuilder.append(firstNames.get(a));
        stringBuilder.append(" ");
        stringBuilder.append(lastNames.get(b));

        return stringBuilder.toString();
    }
}

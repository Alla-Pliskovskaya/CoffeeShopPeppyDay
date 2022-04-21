package com.itproger.blog.controllers;

import com.itproger.blog.models.*;
import com.itproger.blog.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoffeeController
{
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private VolumeRepository volumeRepository;
    @Autowired
    private CoffeePriceRepository priceRepository;
    @Autowired
    private CoffeeAdditiveRepository additiveRepository;
    @Autowired
    private BakeryRepository bakeryRepository;
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
        User user = new User(login, password, full_name);
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/menu")
    public String coffeeMenu(Model model) {
        model.addAttribute("title", "Menu");
        return "menu";
    }

    @GetMapping("/menu/drinks")
    public String drinksMenu(Model model)
    {
        Iterable<Coffee> coffees = coffeeRepository.findAll();
        Iterable<Volume> volumes = volumeRepository.findAll();
        Iterable<CoffeePrice> prices = priceRepository.findAll(Sort.by(Sort.Direction.ASC, "coffeePrice"));
        Iterable<CoffeeAdditive> additives = additiveRepository.findAll();
        model.addAttribute("additives", additives);
        model.addAttribute("coffees", coffees);
        model.addAttribute("volumes", volumes);
        model.addAttribute("prices", prices);
        return "drinks";
    }

    @GetMapping("/menu/bakery")
    public String bakeryMenu(Model model)
    {
        Iterable<Bakery> bakery = bakeryRepository.findAll();
        model.addAttribute("bakery", bakery);
        return "bakery";
    }

}

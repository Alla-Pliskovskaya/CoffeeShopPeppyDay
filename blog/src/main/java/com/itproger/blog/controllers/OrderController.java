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
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private VolumeRepository volumeRepository;
    @Autowired
    private CoffeeAdditiveRepository additiveRepository;
    @Autowired
    private BakeryRepository bakeryRepository;

    @GetMapping("/order")
    public String order(Model model)
    {
        Iterable<Coffee> coffees = coffeeRepository.findAll();
        Iterable<Volume> volumes = volumeRepository.findAll();
        Iterable<CoffeeAdditive> additives = additiveRepository.findAll();
        Iterable<Bakery> bakeries = bakeryRepository.findAll();
        model.addAttribute("coffees", coffees);
        model.addAttribute("volumes", volumes);
        model.addAttribute("additives", additives);
        model.addAttribute("bakeries", bakeries);
        return "order-add";
    }

    @PostMapping("/order")
    public String doOrder(@RequestParam String login, @RequestParam String coffee, @RequestParam String volume,
                          @RequestParam String additive, @RequestParam String bakery, Model model)
    {
        Date date_time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        MyOrder order = new MyOrder(login, coffee, volume, additive, bakery, formatter.format(date_time));
        orderRepository.save(order);
        return "successfulOrder";
    }

    @GetMapping("/orders")
    public String watchOrders(Model model)
    {
        Iterable<MyOrder> orders = orderRepository.findAll(Sort.by(Sort.Direction.DESC,("orderId")));
        model.addAttribute("orders", orders);

        return "orders";
    }
}

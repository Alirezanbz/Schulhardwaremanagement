package com.example.schulhardwaremanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/add-item")
    public String addItem() {
        return "add-item";
    }

    @GetMapping("/warenkorb")
    public String openWarenkorb() {
        return "warenkorb";
    }


}


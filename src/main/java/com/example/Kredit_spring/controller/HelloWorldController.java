package com.example.Kredit_spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@Controller
public class HelloWorldController {
    @RequestMapping("/klientForm")
    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        log.info("com.example.Kredit_spring.controller.start");
        model.addAttribute("name", name);
        return "klientForm";
    }
    @RequestMapping("/offerForm")
    public String offerController(@RequestParam(name = "FIO", required = false, defaultValue = "Не выбран клиент") String fio, Model model) {
        log.info("com.example.Kredit_spring.controller.start");
        model.addAttribute("FIO", fio);
        return "offerForm";
    }

}

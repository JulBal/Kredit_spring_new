package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.service.KlientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@AllArgsConstructor
@Controller
public class HelloWorldController {
    private final KlientService klientService;
    @RequestMapping("/klientForm")
    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        log.info("com.example.Kredit_spring.controller.start");
        model.addAttribute("name", name);
        return "klientForm";
    }
    @RequestMapping("/offerForm")
    public String offerController(@RequestParam(name = "id_klient", required = false, defaultValue = "Не выбран клиент") Integer id_klient, Model model) {
        log.info("com.example.Kredit_spring.controller.start");
        model.addAttribute("klient",klientService.findById(id_klient) );
        return "offerForm";
    }

}

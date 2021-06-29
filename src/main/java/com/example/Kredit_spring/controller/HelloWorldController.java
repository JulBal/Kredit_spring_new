package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.dto.KreditDto;
import com.example.Kredit_spring.entity.Kredit;
import com.example.Kredit_spring.service.KlientService;
import com.example.Kredit_spring.service.KreditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
public class HelloWorldController {
    private final KlientService klientService;
    private final KreditService kreditService;
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

        List<KreditDto> listKreditVid= kreditService.findAll();
        model.addAttribute("kreditVid",listKreditVid);

        return "offerForm";



    }
//    @RequestMapping(value = { "/offerForm" }, method = RequestMethod.GET)
//    public String selectVidKredit(Model model) {
//
//
//        Kredit kredit = new Kredit();
//        model.addAttribute("kreditForm", kredit);
//
//        List<KreditDto> listKreditVid= kreditService.findAll();
//        model.addAttribute("kreditVid",listKreditVid);
//
//        return "offerForm";
//    }

}

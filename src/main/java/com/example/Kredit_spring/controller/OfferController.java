package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.dto.OfferDto;
import com.example.Kredit_spring.service.KlientService;
import com.example.Kredit_spring.service.OfferService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;

    @PostMapping("/save")
    public OfferDto saveOffer(@RequestBody OfferDto offerDto) throws ValidationException {
        log.info("Сохранение кредитного предложения");
        return offerService.saveOffer(offerDto);
    }
    @GetMapping("/findAll")
    public List<OfferDto> findAllOffer(){
        log.info("Поиск всех сделок");
        return offerService.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Integer id){
        log.info("Удаление кредитного предложения");
        offerService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

}

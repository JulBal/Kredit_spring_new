package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.dto.KlientDto;
import com.example.Kredit_spring.service.DefaultBankService;
import com.example.Kredit_spring.service.DefaultKlientService;
import com.example.Kredit_spring.service.KlientService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/klient")

public class KlientController {

    private final KlientService klientService;

    @PostMapping("/save")
    public KlientDto saveKlient(@RequestBody KlientDto klientDto) throws ValidationException {
        log.info("Сохранение данных о клиенте" + klientDto);
        return klientService.saveKlient(klientDto);
    }
    @GetMapping("/findAll")
    public List<KlientDto> findAllKlient(){
        log.info("Поиск всех клиентов");
        return klientService.findAll();
    }
//    @GetMapping("/getFio")
//    public String fioKlient(@RequestParam(name = "FIO") String pasport, Model model){
//        model.addAttribute("FIO",klientService.findByPasport(pasport).getFio())  ;
//        return "offerForm";
//    }
    @GetMapping("/findPasport")
    public KlientDto findPasport(@RequestParam String pasport){
        log.info("Поиск всех клиентов");
        return klientService.findByPasport(pasport);
    }
    @GetMapping("/find/{id}")
    public KlientDto findKlient(@RequestParam Integer id){
        log.info("Поиск всех клиентов");
        return klientService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKlient(@PathVariable Integer id){
        log.info("удаление записи о клиенте");
        klientService.deleteklient(id);
        return ResponseEntity.ok().build();
    }
  /*  @DeleteMapping("/delete/{pasport}")
    public ResponseEntity<Void> deleteKlient(@PathVariable String pasport){
        log.info("удаление записи о клиенте по паспорту");
        klientService.deleteKlientPasport(pasport);
        return ResponseEntity.ok().build();
    }*/
}

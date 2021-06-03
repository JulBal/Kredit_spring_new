package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.dto.KreditDto;
import com.example.Kredit_spring.service.KreditService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/kredit")
public class KreditController {
    private final KreditService kreditService;
    @PostMapping("/save")
    public KreditDto saveKredit(@RequestBody KreditDto kreditDto) throws ValidationException{
       log.info("Сохранение данных о кредите" +kreditDto);
       return kreditService.saveKredit(kreditDto);
    }
    @GetMapping("/findAll")
    public List<KreditDto> findAllKredit(){
        log.info("Поиск всех кредитов");
        return kreditService.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKredit(@PathVariable Integer id){
        log.info("Удаление записи о кредите ");
        kreditService.deletekredit(id);
        return ResponseEntity.ok().build();
    }

}

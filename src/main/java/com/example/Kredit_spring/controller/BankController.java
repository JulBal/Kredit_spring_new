package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.dto.BankDto;
import com.example.Kredit_spring.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@AllArgsConstructor
@RequestMapping("/bank")
@Log
public class BankController {
    private final BankService bankService;
@PostMapping("/save")
    public BankDto saveBank(@RequestBody BankDto bankDto) throws ValidationException{
        log.info("Сохранение банка;"+bankDto);
        return bankService.saveBank(bankDto);
    }
@DeleteMapping("/delete/{id}")
public ResponseEntity<Void> deleteBank(@PathVariable Integer id){
    log.info("Удаление записи о банке" +id);
    return ResponseEntity.ok().build();
}
}

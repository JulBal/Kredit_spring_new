package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.BankDto;
import com.example.Kredit_spring.entity.Bank;
import org.springframework.stereotype.Component;

@Component
public class BankConverter {
     public Bank fromBankDtoToBank(BankDto bankDto){
         Bank bank=new Bank();
         bank.setId(bankDto.getId());
         bank.setId_klient(bankDto.getId_klient());
         bank.setId_krerdit(bankDto.getId_krerdit());
         return bank;
     }
     public BankDto fromBanktoBankDto(Bank bank){
         return BankDto.builder().id(bank.getId()).id_klient(bank.getId_klient()).id_krerdit(bank.getId_krerdit()).build();

     }

}

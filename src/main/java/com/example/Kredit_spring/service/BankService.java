package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.BankDto;

import javax.xml.bind.ValidationException;

public interface BankService {
    BankDto saveBank(BankDto bankDto) throws ValidationException;
    void deleteBank(Integer id_bank);

}

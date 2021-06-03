package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.BankDto;
import com.example.Kredit_spring.entity.Bank;
import com.example.Kredit_spring.repository.BankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;


import static java.util.Objects.isNull;
@Service
@AllArgsConstructor
public class DefaultBankService implements BankService {
    private final BankRepository bankRepository;
    private final BankConverter bankConverter;

    private void validateBankDto(BankDto bankdto) throws ValidationException{
     if (isNull(bankdto)){
         throw new  ValidationException("Банк отсутствует в списке!");
     }
     if (isNull(bankdto.getId_klient())||bankdto.getId_klient()==0){
         throw new  ValidationException("Отсутствуют данные о клиенте");
        }
        if (isNull(bankdto.getId_krerdit())||bankdto.getId_krerdit()==0){
            throw new  ValidationException("Отсутствуют данные о кредите ");
        }
    }

    @Override
    public BankDto saveBank(BankDto bankDto) throws ValidationException {
        validateBankDto(bankDto);
        Bank savedBank=bankRepository.save(bankConverter.fromBankDtoToBank(bankDto));
        return bankConverter.fromBanktoBankDto(savedBank);
    }

    @Override
    public void deleteBank(Integer id_bank) {
        bankRepository.deleteById(id_bank);
    }


}

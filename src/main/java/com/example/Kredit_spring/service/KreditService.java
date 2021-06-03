package com.example.Kredit_spring.service;


import com.example.Kredit_spring.dto.KreditDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface KreditService {
    KreditDto saveKredit(KreditDto kreditDto) throws ValidationException;
    void deletekredit(Integer id_kredit);
    List<KreditDto> findAll();
}

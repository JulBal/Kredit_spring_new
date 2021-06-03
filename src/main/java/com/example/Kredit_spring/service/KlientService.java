package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.KlientDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface KlientService {
    KlientDto saveKlient(KlientDto klientDto) throws ValidationException;
    void deleteklient(Integer id_klient);
    KlientDto findByPasport(String pasport);
    KlientDto findById(Integer id_klient);
   List<KlientDto> findAll();

}

package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.KlientDto;
import com.example.Kredit_spring.entity.Klient;
import org.springframework.stereotype.Component;

@Component
public class KlientConverter {
    public Klient fromKlientDtotoKlient(KlientDto klientDto){
        Klient klient=new Klient();
        klient.setId(klientDto.getId());
        klient.setEmail(klientDto.getEmail());
        klient.setFio(klientDto.getFio());
        klient.setPasport(klientDto.getPasport());
        klient.setFone(klientDto.getFone());
        return  klient;
    }
    public KlientDto fromKlienttoKlientDto(Klient klient){
        return KlientDto.builder()
                .id(klient.getId())
                .email(klient.getEmail())
                .fone(klient.getFone())
                .pasport(klient.getPasport())
                .fio(klient.getFio())
                .build();
    }
}

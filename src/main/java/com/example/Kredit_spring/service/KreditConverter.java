package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.KreditDto;
import com.example.Kredit_spring.entity.Kredit;
import org.springframework.stereotype.Component;

@Component
public class KreditConverter {
    public Kredit fromKreditDototoKredit(KreditDto kreditDto){
       Kredit kredit=new Kredit();
       kredit.setId(kreditDto.getId());
       kredit.setLimit(kreditDto.getLimit());
       kredit.setStavka(kreditDto.getStavka());
      return kredit;
    }
    public KreditDto fromKredittoKreditDto(Kredit kredit){
       return KreditDto.builder()
               .id(kredit.getId())
               .limit(kredit.getLimit())
               .stavka(kredit.getStavka())
               .build();
    }
}

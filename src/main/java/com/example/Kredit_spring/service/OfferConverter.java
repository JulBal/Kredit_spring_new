package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.OfferDto;
import com.example.Kredit_spring.entity.Offer;
import org.springframework.stereotype.Component;

@Component
public class OfferConverter {
    public Offer fromOfferDtotoOffer(OfferDto offerDto){
        Offer offer=new Offer();
        offer.setId(offerDto.getId());
        offer.setId_graph(offerDto.getId_graph());
        offer.setId_klient(offerDto.getId_klient());
        offer.setId_kredit(offerDto.getId_kredit());
        offer.setSumma(offerDto.getSumma());
        offer.setSrok(offerDto.getSrok());
        return offer;
    }
    public OfferDto fromOffertoOfferDto(Offer offer){
      return OfferDto.builder()
              .id(offer.getId())
              .id_graph(offer.getId_graph())
              .id_klient(offer.getId_klient())
              .id_kredit(offer.getId_kredit())
              .summa(offer.getSumma())
              .srok(offer.getSrok())
              .build();
    }
}

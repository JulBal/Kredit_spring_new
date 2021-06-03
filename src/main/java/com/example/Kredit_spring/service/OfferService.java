package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.GraphDto;
import com.example.Kredit_spring.dto.KlientDto;
import com.example.Kredit_spring.dto.OfferDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface OfferService {
    OfferDto saveOffer(OfferDto offerDto) throws ValidationException;
    void deleteOffer(Integer id_offer);
  //  List<OfferDto> findKlientOffer(Integer id_klient);
   // List<GraphDto> findGraphKlientOffer(Integer id_klient);
    List<OfferDto> findAll();
}

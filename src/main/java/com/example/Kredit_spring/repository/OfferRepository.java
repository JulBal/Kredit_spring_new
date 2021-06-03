package com.example.Kredit_spring.repository;

import com.example.Kredit_spring.entity.Klient;
import com.example.Kredit_spring.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer,Integer> {
    //Offer findOffer(Klient id_klient);
}

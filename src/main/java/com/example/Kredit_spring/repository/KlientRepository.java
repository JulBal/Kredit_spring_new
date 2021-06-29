package com.example.Kredit_spring.repository;

import com.example.Kredit_spring.entity.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KlientRepository extends JpaRepository<Klient,Integer> {
    Klient findByPasport(String pasport);

}

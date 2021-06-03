package com.example.Kredit_spring.repository;

import com.example.Kredit_spring.entity.Kredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KreditRepository extends JpaRepository<Kredit,Integer> {

}

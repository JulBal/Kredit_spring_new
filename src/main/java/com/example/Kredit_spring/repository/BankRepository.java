package com.example.Kredit_spring.repository;

import com.example.Kredit_spring.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {
}

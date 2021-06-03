package com.example.Kredit_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    private int id;
    private int id_krerdit;
    private int id_klient;


}

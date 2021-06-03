package com.example.Kredit_spring.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BankDto {
    private int id;
    private int id_krerdit;
    private int id_klient;


}

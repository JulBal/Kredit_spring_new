package com.example.Kredit_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private int id;
    private int id_kredit;
    private int id_klient;
    private double summa;
    private int id_graph;
}


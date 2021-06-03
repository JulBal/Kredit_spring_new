package com.example.Kredit_spring.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class OfferDto {
    private int id;
    private int id_krerdit;
    private int id_klient;
    private double summa;
    private int id_graph;
}

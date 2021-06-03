package com.example.Kredit_spring.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class KreditDto {
    private int id;
    private int limit;
    private double stavka;
}

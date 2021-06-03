package com.example.Kredit_spring.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GraphDto {
    private int id;
    private  double summa;
    private String data;
    private double summa_osn;
    private double summa_proc;
    private int id_graph;
}

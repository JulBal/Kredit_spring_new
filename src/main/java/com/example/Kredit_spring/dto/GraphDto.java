package com.example.Kredit_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphDto {
    private int id;
    private  double summa;
    private Date data;
    private double summa_osn;
    private double summa_proc;
    private int id_graph;
}

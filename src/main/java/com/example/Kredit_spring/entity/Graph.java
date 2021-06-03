package com.example.Kredit_spring.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "graph")
@Data
@NoArgsConstructor

public class Graph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  double summa;
    @Column
    private String data;
    @Column
    private double summa_osn;
    @Column
    private double summa_proc;
    @Column
    private int id_graph;
}
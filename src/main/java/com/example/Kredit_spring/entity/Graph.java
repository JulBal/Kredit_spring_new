package com.example.Kredit_spring.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

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
    private Date data;
    @Column
    private double summa_osn;
    @Column
    private double summa_proc;
    @Column
    private int id_graph;
}
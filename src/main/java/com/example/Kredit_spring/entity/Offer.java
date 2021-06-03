package com.example.Kredit_spring.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "offer")
@Data
@NoArgsConstructor

public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int id_krerdit;
    @Column
    private int id_klient;
    @Column
    private double summa;
    @Column
    private int id_graph;
}
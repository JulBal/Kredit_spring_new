package com.example.Kredit_spring.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "kredit")
@Data
@NoArgsConstructor

public class Kredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int limit;
    @Column
    private double stavka;

}

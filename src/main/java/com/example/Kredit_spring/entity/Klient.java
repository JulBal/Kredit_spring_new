package com.example.Kredit_spring.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "klient")
@Data
@NoArgsConstructor

public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column
    private String fio;
    @Column
    private String fone;
    @Column
    private String email;
    @Column
    private String pasport;

}

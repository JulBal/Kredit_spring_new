package com.example.Kredit_spring.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class KlientDto {
    private int id;
    private String fio;
    private String fone;
    private String email;
    private String pasport;
}

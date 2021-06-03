package com.example.Kredit_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KlientDto {
    private int id;
    private String fio;
    private String fone;
    private String email;
    private String pasport;
}

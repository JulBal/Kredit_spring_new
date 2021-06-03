package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.GraphDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface GraphService {
    GraphDto saveGraph(GraphDto graphDto) throws ValidationException;
    void deleteGraph(Integer id_graph);
    List<GraphDto> findAll();
}

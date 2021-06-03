package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.GraphDto;
import com.example.Kredit_spring.entity.Graph;
import org.springframework.stereotype.Component;

@Component
public class GraphConverter {
    public Graph fromGraphDtotoGraph(GraphDto graphDto) {
        Graph graph = new Graph();
        graph.setId(graphDto.getId());
        graph.setData(graphDto.getData());
        graph.setSumma(graphDto.getSumma());
        graph.setSumma_osn(graphDto.getSumma_osn());
        graph.setSumma_proc(graphDto.getSumma_proc());
        graph.setId_graph(graphDto.getId_graph());
        return graph;
    }

    public GraphDto fromGraphtoGraphDto(Graph graph) {
        return GraphDto.builder().
                id(graph.getId()).
                data(graph.getData()).
                summa(graph.getSumma()).
                summa_osn(graph.getSumma_osn()).
                summa_proc(graph.getSumma_proc()).
                id_graph(graph.getId_graph()).
                build();
    }
}

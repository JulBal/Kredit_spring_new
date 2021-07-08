package com.example.Kredit_spring.controller;

import com.example.Kredit_spring.dto.GraphDto;
import com.example.Kredit_spring.service.GraphService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/graph")
public class GraphController {
    private final GraphService graphService;
    @PostMapping("/save")
    public GraphDto saveGraph(@RequestBody GraphDto graphDto) throws ValidationException{
        log.info("Сохранение графика платежей");
        return graphService.saveGraph(graphDto);
    }
    @GetMapping("/findAll")
    public List<GraphDto> findAllGraph(){
        log.info("Поиск всех платежей");
        return graphService.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGraph(@PathVariable Integer id){
        log.info("Удаление графика платежа");
        graphService.deleteGraph(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findGraph")
    public List<GraphDto> findPasport(@RequestParam Integer id_graph){
        log.info("Формирование графика");
        return graphService.findGraph(id_graph);
    }

}

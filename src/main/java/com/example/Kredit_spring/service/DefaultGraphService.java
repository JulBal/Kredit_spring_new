package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.GraphDto;
import com.example.Kredit_spring.entity.Graph;
import com.example.Kredit_spring.repository.GraphRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
@Service
@AllArgsConstructor
public class DefaultGraphService implements GraphService {
    private final GraphRepository graphRepository;
    private final GraphConverter graphConverter;

    private void validateGraphDto(GraphDto graphDto) throws ValidationException {
        if (isNull(graphDto)){
            throw new  ValidationException("График платежа отсутствует!");
        }
        if (isNull(graphDto.getData())||graphDto.getData().isEmpty()){
            throw new  ValidationException("Отсутствует дата платежа");
        }
        if (isNull(graphDto.getSumma())||graphDto.getSumma()==0.00){
            throw new  ValidationException("Отсутствует сумма платежа");
        }
        if (isNull(graphDto.getSumma_osn())||graphDto.getSumma_osn()==0.00){
            throw new  ValidationException("Отсутствует сумма тела платежа");
        }
        if (isNull(graphDto.getSumma_proc())||graphDto.getSumma_proc()==0.00){
            throw new  ValidationException("Отсутствует сумма по проценту платежа");
        }
    }

    @Override
    public GraphDto saveGraph(GraphDto graphDto) throws ValidationException {
        validateGraphDto(graphDto);
        Graph savedGraph=graphRepository.save(graphConverter.fromGraphDtotoGraph(graphDto));
        return graphConverter.fromGraphtoGraphDto(savedGraph);
    }

    @Override
    public void deleteGraph(Integer id_graph) {
        graphRepository.deleteById(id_graph);
    }

    @Override
    public List<GraphDto> findAll() {
        return graphRepository.findAll().stream().map(graphConverter::fromGraphtoGraphDto).collect(Collectors.toList());
    }
}

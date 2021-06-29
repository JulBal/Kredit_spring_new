package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.GraphDto;
import com.example.Kredit_spring.dto.KreditDto;
import com.example.Kredit_spring.dto.OfferDto;
import com.example.Kredit_spring.entity.Graph;
import com.example.Kredit_spring.repository.GraphRepository;
import com.example.Kredit_spring.repository.KreditRepository;
import com.example.Kredit_spring.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static netscape.security.Privilege.add;

@Service
@AllArgsConstructor
public class DefaultGraphService implements GraphService {
    private final GraphRepository graphRepository;
    private final GraphConverter graphConverter;
    private final OfferConverter offerConverter;
    private final OfferRepository offerRepository;
    private final KreditConverter kreditConverter;
    private final KreditRepository kreditRepository;

    private void validateGraphDto(GraphDto graphDto) throws ValidationException {
        if (isNull(graphDto)) {
            throw new ValidationException("График платежа отсутствует!");
        }
        if (isNull(graphDto.getData())) {
            throw new ValidationException("Отсутствует дата платежа");
        }
        if (isNull(graphDto.getSumma()) || graphDto.getSumma() == 0.00) {
            throw new ValidationException("Отсутствует сумма платежа");
        }
        if (isNull(graphDto.getSumma_osn()) || graphDto.getSumma_osn() == 0.00) {
            throw new ValidationException("Отсутствует сумма тела платежа");
        }
        if (isNull(graphDto.getSumma_proc()) || graphDto.getSumma_proc() == 0.00) {
            throw new ValidationException("Отсутствует сумма по проценту платежа");
        }
    }

    public List<GraphDto> createGraph(Integer offerID) {
        double stavka_mes = 0.00;
        double kft = 0.00;
        double summa_mes = 0.00;
        int period = 0;
        int srok = 0;

        GraphDto graph = new GraphDto();
        List<GraphDto> graphDtoList=new ArrayList<>();
        List<KreditDto> kreditVid = kreditRepository.findAll().stream().map(kreditConverter::fromKredittoKreditDto).collect(Collectors.toList());
        List<OfferDto> offerDtoList = offerRepository.findAll().stream().map(offerConverter::fromOffertoOfferDto).collect(Collectors.toList());

        for (OfferDto offerDto : offerDtoList) {
        if (offerDto.getId()==offerID) {
            srok = offerDto.getSrok();
            period = srok * 12;
            for (KreditDto kreditDto : kreditVid) {
                if (kreditDto.getId() == offerDto.getId_kredit()) {
                    stavka_mes = kreditDto.getStavka() / 12 / 100;/*ставка в мес*/
                    kft = (stavka_mes * Math.pow(1 + stavka_mes, period)) / (Math.pow(1 + stavka_mes, period) - 1);/*Коэффициент аннуитета */
                    summa_mes = offerDto.getSumma() * kft;
                }
            }
            Calendar pamentData = Calendar.getInstance();
            for (int i = 0; i <= period; i++) {
                pamentData.add(Calendar.MONTH, +i);
                graph.setData(pamentData.getTime());
                graph.setId_graph(offerDto.getId_klient());/*уник код для связи с клиентом*/
                graph.setSumma(summa_mes);/*месячный платеж*/
                graph.setSumma_osn(offerDto.getSumma() / period);
                graph.setSumma_proc(summa_mes - offerDto.getSumma() / period);
                graphDtoList.add(graph);
            }
        }
        }
        return graphDtoList;
    }

    @Override
    public GraphDto saveGraph(GraphDto graphDto) throws ValidationException {
        validateGraphDto(graphDto);
        Graph savedGraph = graphRepository.save(graphConverter.fromGraphDtotoGraph(graphDto));
        return graphConverter.fromGraphtoGraphDto(savedGraph);
    }

    @Override
    public void deleteGraph(Integer id_graph) {
        graphRepository.deleteById(id_graph);
    }
    @Override
    public   List<GraphDto> createGraphPayment(Integer id_offer) {
        return  createGraph(id_offer);
    }
    @Override
    public List<GraphDto> findGraph(Integer id_graph) {
        List<GraphDto> graphAll=findAll();
        List<GraphDto> graph=new ArrayList<>();
        for (GraphDto graphPayment : graphAll) {
            if (graphPayment.getId()==id_graph) {
            graph.add(graphPayment);
            }
        }
        return graph;
    }
    @Override
    public List<GraphDto> findAll() {
        return  graphRepository.findAll().stream().map(graphConverter::fromGraphtoGraphDto).collect(Collectors.toList());
    }

}

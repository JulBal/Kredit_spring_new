package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.GraphDto;
import com.example.Kredit_spring.dto.OfferDto;
import com.example.Kredit_spring.entity.Offer;
import com.example.Kredit_spring.repository.GraphRepository;
import com.example.Kredit_spring.repository.KlientRepository;
import com.example.Kredit_spring.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultOfferService implements OfferService {
    private final OfferConverter offerConverter;
    private final OfferRepository offerRepository;
   // private final GraphRepository graphRepository;
  //  private final GraphConverter graphConverter;
    private void validateOfferDto(OfferDto offerDto) throws ValidationException {
        if (isNull(offerDto)) {
            throw new ValidationException("Кредитное предложение отсутствует!");
        }
        if (isNull(offerDto.getSumma()) || offerDto.getSumma() == 0) {
            throw new ValidationException("Отсутствует сумма кредита");
        }
//        if (isNull(offerDto.getId_graph()) || offerDto.getId_graph() == 0) {
//            throw new ValidationException("Отсутствует график кредита");
//        }
        if (isNull(offerDto.getId_klient()) || offerDto.getId_klient() == 0) {
            throw new ValidationException("Клиент не выбран");
        }
        if (isNull(offerDto.getId_kredit()) || offerDto.getId_kredit() == 0) {
            throw new ValidationException("Кредит не указан");
        }
    }

    @Override
    public OfferDto saveOffer(OfferDto offerDto) throws ValidationException {
        validateOfferDto(offerDto);
        Offer savedOffer = offerRepository.save(offerConverter.fromOfferDtotoOffer(offerDto));
        return offerConverter.fromOffertoOfferDto(savedOffer);
    }

    @Override
    public void deleteOffer(Integer id_offer) {
        offerRepository.deleteById(id_offer);
    }

//    @Override
//    public List<OfferDto> findKlientOffer(Integer id_klient) {
//        List<OfferDto> klientOffer=new ArrayList<>();
//        List<OfferDto> listOffer =findAll();
//        for (OfferDto offerDto:listOffer) {
//         if (offerDto.getId_klient()==id_klient){
//             klientOffer.add(offerDto);
//         }
//        }
//        return klientOffer;
//    }
//    @Override
//    public List<GraphDto> findGraphKlientOffer(Integer id_klient) {
//        List<GraphDto> graphKlient=new ArrayList<>();
//        List<OfferDto> listOffer =findAll();
//        List<GraphDto> listGraph=graphRepository.findAll().stream().map(graphConverter::fromGraphtoGraphDto).collect(Collectors.toList());
//        Integer idGraph;
//        for (OfferDto offerDto:listOffer) {
//            if (offerDto.getId_klient()==id_klient){
//                idGraph=offerDto.getId_graph();
//                for (GraphDto graph:listGraph) {
//                    if(graph.getId_graph()==idGraph){
//
//                    }
//                }
//            }
//        }
//        return graphKlient;
//    }

    @Override
    public List<OfferDto> findAll() {
        return offerRepository.findAll().stream().map(offerConverter::fromOffertoOfferDto).collect(Collectors.toList());
    }
}

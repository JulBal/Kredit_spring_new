package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.KlientDto;
import com.example.Kredit_spring.entity.Klient;
import com.example.Kredit_spring.repository.KlientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultKlientService implements KlientService {
    private final KlientRepository klientRepository;
    private final KlientConverter klientConverter;

    private void validateKlientDto(KlientDto klientDto) throws ValidationException {
        if (isNull(klientDto)) {
            throw new ValidationException("График платежа отсутствует!");
        }
        if (isNull(klientDto.getFio()) || klientDto.getFio().isEmpty()) {
            throw new ValidationException("Отсутствует ФИО клиента");
        }

        Boolean isFone = Pattern.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", klientDto.getFone());
        if (isNull(klientDto.getFone()) || klientDto.getFone().isEmpty()) {
            throw new ValidationException("Отсутствует телефон клиента");
        }
        if (isFone == false) {
            throw new ValidationException("Некорректный номер телефона");
        }
        Boolean isEmail = Pattern.matches("[a-zA-Z0-9]{1,}[@]{1}[a-z]{2,}[.]{1}+[a-z]{2}", klientDto.getEmail());
        if (isNull(klientDto.getEmail()) || klientDto.getEmail().isEmpty()) {
            throw new ValidationException("Отсутствует email");
        }
        if (isEmail == false) {
          throw new ValidationException("Некорректный email");
        }
        Boolean isPasport = Pattern.matches("^([0-9]{10})?$", klientDto.getPasport());
        if (isNull(klientDto.getPasport()) || klientDto.getPasport().isEmpty()) {
            throw new ValidationException("Отсутствует паспорт");
        }
        if (isPasport == false) {
           throw new ValidationException("Некорректные паспортные данные");
        }
    }

    @Override
    public KlientDto saveKlient(KlientDto klientDto) throws ValidationException {
        validateKlientDto(klientDto);
        Klient savedKlient = klientRepository.save(klientConverter.fromKlientDtotoKlient(klientDto));
        return klientConverter.fromKlienttoKlientDto(savedKlient);
    }

    @Override
    public void deleteklient(Integer id_klient) {
        klientRepository.deleteById(id_klient);
    }
    @Override
    public void deleteKlientPasport(String pasport) {
        klientRepository.deleteByPasport(pasport);
    }
    @Override
    public KlientDto findByPasport(String pasport) {
        Klient klient=klientRepository.findByPasport(pasport);
        if (klient!=null){
        return klientConverter.fromKlienttoKlientDto(klient);
        }
        return null;
    }

    @Override
    public KlientDto findById(Integer id) {
        Klient klient=klientRepository.getById(id);
        if (klient!=null){
            return klientConverter.fromKlienttoKlientDto(klient);
        }
        return null;
    }



    @Override
    public List<KlientDto> findAll() {
        return klientRepository.findAll().stream().map(klientConverter::fromKlienttoKlientDto).collect(Collectors.toList());
    }
}

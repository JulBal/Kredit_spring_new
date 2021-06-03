package com.example.Kredit_spring.service;

import com.example.Kredit_spring.dto.KreditDto;
import com.example.Kredit_spring.entity.Kredit;
import com.example.Kredit_spring.repository.KreditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultKreditService implements KreditService {
    private final KreditConverter kreditConverter;
    private final KreditRepository kreditRepository;

    private void validateKreditDto(KreditDto kreditDto) throws ValidationException {
        if (isNull(kreditDto)) {
            throw new ValidationException("Кредит отсутствует!");
        }
        if (isNull(kreditDto.getLimit() == 0)) {
            throw new ValidationException("Отсутствует лимит кредита");
        }
        if (isNull(kreditDto.getStavka() == 0)) {
            throw new ValidationException("Отсутствует ставка кредита");
        }

    }

    @Override
    public KreditDto saveKredit(KreditDto kreditDto) throws ValidationException {
        validateKreditDto(kreditDto);
        Kredit saveKredit = kreditRepository.save(kreditConverter.fromKreditDototoKredit(kreditDto));
        return kreditConverter.fromKredittoKreditDto(saveKredit);
    }

    @Override
    public void deletekredit(Integer id_kredit) {
        kreditRepository.deleteById(id_kredit);
    }

    @Override
    public List<KreditDto> findAll() {
        return kreditRepository.findAll().stream().map(kreditConverter::fromKredittoKreditDto).collect(Collectors.toList());
    }
}


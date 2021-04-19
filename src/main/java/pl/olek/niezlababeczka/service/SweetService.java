package pl.olek.niezlababeczka.service;


import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.SweetDto;
import pl.olek.niezlababeczka.entity.Sweet;
import pl.olek.niezlababeczka.repository.SweetRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class SweetService {

    private final SweetRepo sweetRepo;

    public SweetService(SweetRepo sweetRepo) {
        this.sweetRepo = sweetRepo;
    }



    public SweetDto addSweet(SweetDto sweetDto) {
        Money money = Money.of(sweetDto.getCurrency(), sweetDto.getPriceValue());
        Sweet sweet = new Sweet();
        sweet.setId(sweetDto.getId());
        sweet.setPrice(money);
        sweet.setName(sweetDto.getName());
        Sweet sweetSaved = sweetRepo.save(sweet);
        log.info("added pie with id{}", sweetSaved.getId());
        return SweetDto.toDto(sweetSaved);
    }

    public List<SweetDto> showAllSweets() {
        log.info("Show list of sweets");
        return sweetRepo.getAllByDeletedIsFalse()
                .stream()
                .map(SweetDto::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        log.info("Deleting sweet by id: {}", id);
        Sweet sweet = sweetRepo.getOne(id);
        sweet.setDeleted(true);
        sweetRepo.save(sweet);
    }

    public Optional<SweetDto> findById(UUID id) {
        log.info("We are looking for sweet with id: {}", id);
        return sweetRepo.findById(id).map(SweetDto::toDto);
    }
}

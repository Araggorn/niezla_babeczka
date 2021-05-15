package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.SweetOrderItemDto;
import pl.olek.niezlababeczka.entity.SweetOrderItem;
import pl.olek.niezlababeczka.repository.SweetOrderItemRepo;
import pl.olek.niezlababeczka.repository.SweetRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class SweetOrderItemService {

    private final SweetOrderItemRepo sweetOrderItemRepo;
    private final SweetRepo sweetRepo;

    public SweetOrderItemService(SweetOrderItemRepo sweetOrderItemRepo, SweetRepo sweetRepo) {
        this.sweetOrderItemRepo = sweetOrderItemRepo;
        this.sweetRepo = sweetRepo;
    }

    public SweetOrderItemDto addSweetOrderItem (SweetOrderItemDto sweetOrderItemDto){
        SweetOrderItem sweetOrderItem = SweetOrderItem.builder()
                .sweet(sweetRepo.getOne(sweetOrderItemDto.getSweetId()))
                .quantity(sweetOrderItemDto.getQuantity())
                .id(sweetOrderItemDto.getId())
                .build();

        SweetOrderItem sweetOrderItemSaved = sweetOrderItemRepo.save(sweetOrderItem);
        log.info("adding sweetOrderItem with id {}", sweetOrderItem.getId());
        return SweetOrderItemDto.toDto(sweetOrderItemSaved);
    }

    public List<SweetOrderItemDto> showAllSweets() {
        log.info("Show list of sweetOrderItem");
        return sweetOrderItemRepo.getAllByDeletedIsFalse()
                .stream()
                .map(SweetOrderItemDto::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        log.info("Deleting  by id: {}", id);
        SweetOrderItem sweet = sweetOrderItemRepo.getOne(id);
        sweet.setDeleted(true);
        sweetOrderItemRepo.save(sweet);
    }

    public Optional<SweetOrderItemDto> findById(UUID id) {
        log.info("We are looking for sweetOrderItem with id: {}", id);
        return sweetOrderItemRepo.findById(id).map(SweetOrderItemDto::toDto);
    }
}

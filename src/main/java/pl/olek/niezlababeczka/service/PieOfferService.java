package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.entity.Pie;
import pl.olek.niezlababeczka.entity.PieOffer;
import pl.olek.niezlababeczka.entity.PieSize;
import pl.olek.niezlababeczka.repository.PieOfferRepo;
import pl.olek.niezlababeczka.repository.PieRepo;
import pl.olek.niezlababeczka.repository.PieSizeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class PieOfferService {

    private final PieOfferRepo pieOfferRepo;
    private final PieRepo pieRepo;
    private final PieSizeRepo pieSizeRepo;

    public PieOfferService(PieOfferRepo pieOfferRepo, PieRepo pieRepo, PieSizeRepo pieSizeRepo) {
        this.pieOfferRepo = pieOfferRepo;
        this.pieRepo = pieRepo;
        this.pieSizeRepo = pieSizeRepo;
    }


    public PieOfferDto addPieOffer(PieOfferDto pieOfferDto){
        Pie pie = pieRepo.getOne(pieOfferDto.getPie_id());
        PieSize pieSize = pieSizeRepo.getOne(pieOfferDto.getPieSize_id());
        Money money =  Money.of(pieOfferDto.getMoney().getCurrencyUnit(), pieOfferDto.getMoney().getValue());

        PieOffer pieOffer = PieOffer.builder()
                .pie(pie)
                .pieSize(pieSize)
                .price(money)
                .build();
        
        PieOffer pieOfferSaved = pieOfferRepo.save(pieOffer);
        log.info("adding PieOffer with id {}", pieOffer.getId());
        return PieOfferDto.toDto(pieOfferSaved);
    }

    public List<PieOfferDto> showAllPieOffers() {
        log.info("Show list of pieOffers");
        return pieOfferRepo.getAllByDeletedIsFalse()
                .stream()
                .map(PieOfferDto::toDto)
                .collect(Collectors.toList());
    }
    public void deleteById(UUID id) {
        log.info("Deleting pieOffer by id: {}", id);
        PieOffer pieO = pieOfferRepo.getOne(id);
        pieO.setDeleted(true);
        pieOfferRepo.save(pieO);
    }
    public Optional<PieOfferDto> findById(UUID id) {
        log.info("We are looking for pieOffer with id: {}", id);
        return pieOfferRepo.findById(id).map(PieOfferDto::toDto);
    }
}

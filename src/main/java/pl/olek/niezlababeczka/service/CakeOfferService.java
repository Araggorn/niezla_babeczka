package pl.olek.niezlababeczka.service;


import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeOfferDto;
import pl.olek.niezlababeczka.entity.Cake;
import pl.olek.niezlababeczka.entity.CakeOffer;
import pl.olek.niezlababeczka.repository.CakeOfferRepo;
import pl.olek.niezlababeczka.repository.CakeRepo;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class CakeOfferService {

    private final CakeOfferRepo cakeOfferRepo;
    private final CakeRepo cakeRepo;

    public CakeOfferService(CakeOfferRepo cakeOfferRepo, CakeRepo cakeRepo) {
        this.cakeOfferRepo = cakeOfferRepo;
        this.cakeRepo = cakeRepo;
    }

    public CakeOfferDto addCakeOffer(CakeOfferDto cakeOfferDto){
        Cake cake2 = cakeRepo.getOne(cakeOfferDto.getCake_id());
        CurrencyUnit currencyUnit = cakeOfferDto.getMoneyDto().getCurrencyUnit();
        BigDecimal value = cakeOfferDto.getMoneyDto().getValue();
        Money money = Money.of(currencyUnit, value);
        CakeOffer cakeOffer = CakeOffer.builder()
                .cake(cake2)
                .cakeLayers(cakeOfferDto.getCakeLayerSet())
                .price(money)
                .build();
        CakeOffer cakeOfferSaved = cakeOfferRepo.save(cakeOffer);
        log.info("adding CakeOffer with id {}", cakeOffer.getId());
        return CakeOfferDto.toDto(cakeOfferSaved);
    }

    public Set<CakeOfferDto> showAllCakeOffers() {
        log.info("Show list of cakeOffers");
        return cakeOfferRepo.getAllByDeletedIsFalse()
                .stream()
                .map(CakeOfferDto::toDto)
                .collect(Collectors.toSet());
    }
    public void deleteById(UUID id) {
        log.info("Deleting cakeOffer by id: {}", id);
        CakeOffer cakO = cakeOfferRepo.getOne(id);
        cakO.setDeleted(true);
        cakeOfferRepo.save(cakO);
    }
    public Optional<CakeOfferDto> findById(UUID id) {
        log.info("We are looking for cakeOffer with id: {}", id);
        return cakeOfferRepo.findById(id).map(CakeOfferDto::toDto);
    }
}

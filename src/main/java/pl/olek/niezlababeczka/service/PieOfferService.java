package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.entity.PieOffer;
import pl.olek.niezlababeczka.repository.PieOfferRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class PieOfferService {

    private final PieOfferRepo pieOfferRepo;

    public PieOfferService(PieOfferRepo pieOfferRepo) {
        this.pieOfferRepo = pieOfferRepo;
    }


    public PieOfferDto addPieOffer(PieOfferDto pieOfferDto){
        PieOffer pieOffer = PieOffer.builder()
                .
    }
}

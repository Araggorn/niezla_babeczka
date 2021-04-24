package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezlababeczka.dto.MoneyDto;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.entity.Pie;
import pl.olek.niezlababeczka.entity.PieSize;
import pl.olek.niezlababeczka.service.PieOfferService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1/pieoffers")
public class PieOfferController {

    PieOfferService pieOfferService;

    public PieOfferController(PieOfferService pieOfferService) {
        this.pieOfferService = pieOfferService;
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<PieOfferDto> getPieOfferById(@PathVariable("id") UUID id) {
        return pieOfferService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PieOfferDto> pieAdd(@RequestBody PieOfferDto pieODto) {
        PieOfferDto savedPie = pieOfferService.addPieOffer(pieODto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPie.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedPie);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deletePie(@PathVariable UUID id) {
        pieOfferService.deleteById(id);
        log.info("deleting pieOffer id: {}", id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<PieOfferDto> pieOfferList() {
        return pieOfferService.showAllPieOffers();
    }

}

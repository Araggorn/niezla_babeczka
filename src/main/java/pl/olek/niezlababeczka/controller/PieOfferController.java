package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.service.PieOfferService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1/pieoffer")
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

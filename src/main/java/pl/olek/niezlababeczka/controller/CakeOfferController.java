package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezlababeczka.dto.CakeOfferDto;
import pl.olek.niezlababeczka.service.CakeOfferService;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1/cakeoffers")
public class CakeOfferController {

    CakeOfferService cakeOfferService;

    public CakeOfferController(CakeOfferService cakeOfferService) {
        this.cakeOfferService = cakeOfferService;
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<CakeOfferDto> getCakeOfferById(@PathVariable("id") UUID id) {
        return cakeOfferService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CakeOfferDto> addNewCake(@RequestBody CakeOfferDto cakeODto) {
        CakeOfferDto savedCake = cakeOfferService.addCakeOffer(cakeODto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCake.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedCake);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deletePie(@PathVariable UUID id) {
        cakeOfferService.deleteById(id);
        log.info("deleting cakeOffer id: {}", id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Set<CakeOfferDto> cakeOfferList() {
        return cakeOfferService.showAllCakeOffers();
    }
}



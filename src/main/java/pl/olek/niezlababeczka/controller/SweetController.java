package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezlababeczka.dto.SweetDto;
import pl.olek.niezlababeczka.service.SweetService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1/sweets")
public class SweetController {

    private final SweetService sweetService;

    @Autowired
    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<SweetDto> getSweetById(@PathVariable("id") UUID id) {
        return sweetService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SweetDto> pieAdd(@RequestBody SweetDto sweetDto) {
        SweetDto savedSweet = sweetService.addSweet(sweetDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSweet.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedSweet);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deleteSweet(@PathVariable UUID id) {
        sweetService.deleteById(id);
        log.info("Request to delete sweet id: {}", id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<SweetDto> sweetList() {
        return sweetService.showAllSweets();
    }

    @PostConstruct
    void createSampleUser() {
        CurrencyUnit usd = CurrencyUnit.of("USD");
        sweetService.addSweet(SweetDto.builder()
                .name("cukiereczki")
                .currency(usd)
                .priceValue(BigDecimal.valueOf(12.09))
                .id(UUID.randomUUID())
                .build());
    }
}


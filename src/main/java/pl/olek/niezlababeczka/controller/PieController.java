package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezlababeczka.dto.PieDto;
import pl.olek.niezlababeczka.service.PieService;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1/pie")
public class PieController {

    private final PieService pieService;

    public PieController(PieService pieService) {
        this.pieService = pieService;
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<PieDto> getPieById(@PathVariable("id") UUID id) {
        return pieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PieDto> pieAdd(@RequestBody PieDto pieDto) {
        PieDto savedPie = pieService.addPie(pieDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPie.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedPie);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deletePie(@PathVariable UUID id) {
        pieService.deleteById(id);
        log.info("Request to delete pie id: {}", id);
        return ResponseEntity.ok().build();
    }

}

package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezlababeczka.dto.PieSizeDto;
import pl.olek.niezlababeczka.service.PieSizeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1/piesize")
public class PieSizeController {

    private final PieSizeService pieSizeService;

    public PieSizeController(PieSizeService pieSizeService) {
        this.pieSizeService = pieSizeService;
    }


    @GetMapping("/{id:\\d+}")
    public ResponseEntity<PieSizeDto> getPieSizeById(@PathVariable("id") UUID id) {
        return pieSizeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PieSizeDto> pieSizeAdd(@RequestBody PieSizeDto pieSizeDto) {
        PieSizeDto savedPieS = pieSizeService.addPieSize(pieSizeDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPieS.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedPieS);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deletePieSize(@PathVariable UUID id) {
        pieSizeService.deleteById(id);
        log.info("Request to delete pieSize id: {}", id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<PieSizeDto> pieSizeList() {
        return pieSizeService.showAllPieSizes();
    }
}

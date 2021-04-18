package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.olek.niezlababeczka.service.PieSizeService;

@Slf4j
@RestController
@RequestMapping(path = "/v1/piesize")
public class PieSizeController {

    private final PieSizeService pieSizeService;

    public PieSizeController(PieSizeService pieSizeService) {
        this.pieSizeService = pieSizeService;
    }
}

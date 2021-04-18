package pl.olek.niezlababeczka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.olek.niezlababeczka.service.PieService;

@Slf4j
@RestController
@RequestMapping(path = "/v1/pie")
public class PieController {

    private final PieService pieService;

    public PieController(PieService pieService) {
        this.pieService = pieService;
    }
}

package pl.olek.niezlababeczka.data;

import lombok.AllArgsConstructor;
import org.joda.money.CurrencyUnit;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.MoneyDto;
import pl.olek.niezlababeczka.dto.PieDto;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.dto.PieSizeDto;
import pl.olek.niezlababeczka.service.PieOfferService;
import pl.olek.niezlababeczka.service.PieService;
import pl.olek.niezlababeczka.service.PieSizeService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InitDataLoader {

    private final PieService pieService;
    private final PieSizeService pieSizeService;
    private final PieOfferService pieOfferService;

    @PostConstruct
    void createSamplePieOffer() {
        UUID pieId = UUID.randomUUID();
        pieService.addPie(new PieDto(pieId, "jabłecznik", "pychotka"));

        UUID pieSizeId = UUID.randomUUID();
        pieSizeService.addPieSize(new PieSizeDto(pieSizeId, "24x24cm"));

        MoneyDto moneyDto = new MoneyDto(CurrencyUnit.CAD, BigDecimal.valueOf(123L));
        pieOfferService.addPieOffer(PieOfferDto.builder()
                .pieId(pieId)
                .pieSizeId(pieSizeId)
                .money(moneyDto)
                .id(UUID.randomUUID())
                .build());
    }
}

package pl.olek.niezlababeczka.data;

import lombok.AllArgsConstructor;
import org.joda.money.CurrencyUnit;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeDto;
import pl.olek.niezlababeczka.dto.LayerTasteDto;
import pl.olek.niezlababeczka.dto.MoneyDto;
import pl.olek.niezlababeczka.dto.PieDto;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.dto.PieSizeDto;
import pl.olek.niezlababeczka.repository.CakeLayerRepo;
import pl.olek.niezlababeczka.service.CakeLayerService;
import pl.olek.niezlababeczka.service.CakeOfferService;
import pl.olek.niezlababeczka.service.CakeService;
import pl.olek.niezlababeczka.service.LayerTasteService;
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
    private final CakeLayerService cakeLayerService;
    private final CakeLayerRepo cakeLayerRepo;
    private final CakeService cakeService;
    private final LayerTasteService layerTasteService;
    private final CakeOfferService cakeOfferService;

    @PostConstruct
    void createSamplePieOfferAndCakeOffer() {
        UUID pieId = UUID.randomUUID();
        pieService.addPie(new PieDto(pieId, "jabłecznik", "pychotka"));

        UUID pieSizeId = UUID.randomUUID();
        pieSizeService.addPieSize(new PieSizeDto(pieSizeId, "24x24cm"));

        UUID cakeId = UUID.randomUUID();
        cakeService.addCake(new CakeDto(cakeId, "tort nakedcake", 20, "bez tynku"));

        UUID layerTasteId = UUID.randomUUID();
        layerTasteService.addLayerTaste(new LayerTasteDto(layerTasteId, "orange"));

//        UUID cakeLayerId = UUID.randomUUID();
//        cakeLayerService.addCakeLayer(new CakeLayerDto(cakeLayerId, layerTasteId));
//        Set<CakeLayer> setCakeLayer = Set.of(cakeLayerRepo.getOne(cakeLayerId));

        MoneyDto moneyDto = new MoneyDto(CurrencyUnit.CAD, BigDecimal.valueOf(123L));


//        cakeOfferService.addCakeOffer(CakeOfferDto.builder()
//                .cake_id(cakeId)
//                .cakeLayerSet(setCakeLayer)
//                .moneyDto(moneyDto)
//                .build());

        pieOfferService.addPieOffer(PieOfferDto.builder()
                .pieId(pieId)
                .pieSizeId(pieSizeId)
                .money(moneyDto)
                .id(UUID.randomUUID())
                .build());
    }
}

package pl.olek.niezlababeczka.data;

import lombok.AllArgsConstructor;
import org.joda.money.CurrencyUnit;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeDto;
import pl.olek.niezlababeczka.dto.CakeLayerDto;
import pl.olek.niezlababeczka.dto.CakeOfferDto;
import pl.olek.niezlababeczka.dto.LayerTasteDto;
import pl.olek.niezlababeczka.dto.MoneyDto;
import pl.olek.niezlababeczka.dto.PieDto;
import pl.olek.niezlababeczka.dto.PieOfferDto;
import pl.olek.niezlababeczka.dto.PieSizeDto;
import pl.olek.niezlababeczka.dto.SweetDto;
import pl.olek.niezlababeczka.entity.CakeLayer;
import pl.olek.niezlababeczka.repository.CakeLayerRepo;
import pl.olek.niezlababeczka.service.CakeLayerService;
import pl.olek.niezlababeczka.service.CakeOfferService;
import pl.olek.niezlababeczka.service.CakeService;
import pl.olek.niezlababeczka.service.LayerTasteService;
import pl.olek.niezlababeczka.service.PieOfferService;
import pl.olek.niezlababeczka.service.PieService;
import pl.olek.niezlababeczka.service.PieSizeService;
import pl.olek.niezlababeczka.service.SweetService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Set;
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
    private final SweetService sweetService;

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

        UUID cakeLayerId = UUID.randomUUID();
        cakeLayerService.addCakeLayer(CakeLayerDto.builder()
                .cakeLayerID(cakeLayerId)
                .layerTasteID(layerTasteId)
                .build());
        Set<CakeLayer> setCakeLayer = Set.of(cakeLayerRepo.getOne(cakeLayerId));

        UUID sweetId = UUID.randomUUID();
        sweetService.addSweet(SweetDto.builder()
                .name("blablak")
                .id(sweetId)
                .priceValue(BigDecimal.valueOf(10L))
                .currency(CurrencyUnit.EUR)
                .build());

        MoneyDto moneyDto = new MoneyDto(CurrencyUnit.CAD, BigDecimal.valueOf(123L));


        cakeOfferService.addCakeOffer(CakeOfferDto.builder()
                .cake_id(cakeId)
                .cakeLayerSet(setCakeLayer)
                .moneyDto(moneyDto)
                .build());

        pieOfferService.addPieOffer(PieOfferDto.builder()
                .pieId(pieId)
                .pieSizeId(pieSizeId)
                .money(moneyDto)
                .id(UUID.randomUUID())
                .build());
    }
}

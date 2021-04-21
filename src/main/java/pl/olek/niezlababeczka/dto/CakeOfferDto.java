package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.CakeLayer;
import pl.olek.niezlababeczka.entity.CakeOffer;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CakeOfferDto {
    private MoneyDto moneyDto;
    private UUID cake_id;
    private Set<CakeLayer> cakeLayerSet;
    private UUID id;

    public static CakeOfferDto toDto (CakeOffer cakeO) {
        MoneyDto money = new MoneyDto(cakeO.getPrice().getCurrencyUnit(), cakeO.getPrice().getAmount());
        return CakeOfferDto.builder()
                .cake_id(cakeO.getCake().getId())
                .cakeLayerSet(cakeO.getCakeLayers())
                .moneyDto(money)
                .build();

    }
}

package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.PieOffer;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PieOfferDto {

    private MoneyDto money;
    private UUID pieSize_id;
    private UUID pie_id;
    private UUID id;

    public static PieOfferDto toDto(PieOffer pieOffer) {
        MoneyDto moneyN = new MoneyDto(pieOffer.getPrice().getCurrencyUnit(), pieOffer.getPrice().getAmount());
        return PieOfferDto.builder()
                .pieSize_id(pieOffer.getPieSize().getId())
                .pie_id(pieOffer.getPie().getId())
                .money(moneyN)
                .build();

    }
}

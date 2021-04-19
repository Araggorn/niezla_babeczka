package pl.olek.niezlababeczka.dto;

import lombok.*;
import org.joda.money.CurrencyUnit;
import pl.olek.niezlababeczka.entity.PieOffer;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PieOfferDto {

    private BigDecimal priceValue;
    private CurrencyUnit currency;
    private String pieSizeDescription;
    private String pieName;
    private String pieDescription;
    private UUID id;

    public static PieOfferDto toDto(PieOffer pieOffer) {
        return PieOfferDto.builder()
                .pieDescription(pieOffer.getPie().getDescription())
                .pieName(pieOffer.getPie().getName())
                .pieSizeDescription(pieOffer.getPieSize().getDescription())
                .currency(pieOffer.getPrice().getCurrencyUnit())
                .priceValue(pieOffer.getPrice().getAmount())
                .id(pieOffer.getId())
                .build();

    }
}

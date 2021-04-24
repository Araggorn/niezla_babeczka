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

    private UUID id;
    private UUID pieSizeId;
    private UUID pieId;
    private MoneyDto money;

    public static PieOfferDto toDto(PieOffer pieOffer) {
        return PieOfferDto.builder()
                .id(pieOffer.getId())
                .pieSizeId(pieOffer.getPieSize().getId())
                .pieId(pieOffer.getPie().getId())
                .money(MoneyDto.toDto(pieOffer.getPrice()))
                .build();

    }
}

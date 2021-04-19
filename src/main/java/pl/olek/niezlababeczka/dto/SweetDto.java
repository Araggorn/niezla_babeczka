package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.joda.money.CurrencyUnit;
import pl.olek.niezlababeczka.entity.Sweet;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class SweetDto {
    private String name;
    private BigDecimal priceValue;
    private CurrencyUnit currency;
    private UUID id;

    public static SweetDto toDto (Sweet sweet){
        return SweetDto.builder()
                .name(sweet.getName())
                .priceValue(sweet.getPrice().getAmount())
                .currency(sweet.getPrice().getCurrencyUnit())
                .id(sweet.getId())
                .build();
    }
}

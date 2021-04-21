package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDto {

    private CurrencyUnit currencyUnit;
    private BigDecimal value;

    public static MoneyDto toDto(Money money) {
        return MoneyDto.builder()
                .currencyUnit(money.getCurrencyUnit())
                .value(money.getAmount())
                .build();
    }
}

package pl.olek.niezlababeczka.entity;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Sweet extends Product {

    private String name;

    @Columns(columns = {@Column(name = "price_currency"), @Column(name = "price_amount")})
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
    private Money price;

    public Sweet(UUID id, Money price, String name) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Sweet(Money price,
                 String name) {
        this.price = price;
        this.name =name;
    }
}

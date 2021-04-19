package pl.olek.niezlababeczka.entity;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PieOffer extends ParentEntity{

    @ManyToOne
    private Pie pie;

    @ManyToOne
    private PieSize pieSize;

    @Columns(columns = {@Column(name = "price_currency"), @Column(name = "price_amount")})
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
    private Money price;


}

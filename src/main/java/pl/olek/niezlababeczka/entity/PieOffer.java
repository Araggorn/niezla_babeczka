package pl.olek.niezlababeczka.entity;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PieOffer extends ParentEntity{

    @ManyToOne
    @JoinColumn(name = "pie_id")
    private Pie pie;

    @ManyToOne
    @JoinColumn(name = "pieSize_id")
    private PieSize pieSize;

    @Columns(columns = {@Column(name = "price_currency"), @Column(name = "price_amount")})
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
    private Money price;


}

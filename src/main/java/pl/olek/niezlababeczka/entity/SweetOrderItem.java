package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class SweetOrderItem extends OrderItem{

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "sweet_id")
    private Sweet sweet;

    public SweetOrderItem(int quantity, Sweet sweet) {
        this.quantity = quantity;
        this.sweet = sweet;
    }
}

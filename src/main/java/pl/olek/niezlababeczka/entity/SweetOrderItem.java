package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class SweetOrderItem extends OrderItem{

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "sweet_id")
    private Sweet sweet;
}

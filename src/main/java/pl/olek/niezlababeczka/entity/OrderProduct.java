package pl.olek.niezlababeczka.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderProduct {

    @ManyToOne
    private Order order;


    private Long productId;
}

package pl.olek.niezlababeczka.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

    @ManyToOne
    private Order order;

    private Long productId;
}

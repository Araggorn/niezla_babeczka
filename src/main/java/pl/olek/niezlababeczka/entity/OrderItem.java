package pl.olek.niezlababeczka.entity;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@ToString
public class OrderItem extends ParentEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem() {
        super(UUID.randomUUID());
    }
}

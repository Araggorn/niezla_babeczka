package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends ParentEntity {

    @Column(unique = true)
    Long orderNumber;

    boolean confirmed;
    boolean realized;

    @ManyToOne
    private User user;

    @OneToMany (mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();
}

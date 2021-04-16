package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order extends ParentEntity {

    @Column(unique = true)
    Long orderNumber;

    boolean confirmed;
    boolean realized;

    @ManyToOne
    private User user;

    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL)
    private Set<CakeOrderItem> cakeOrderItems = new HashSet<>();

    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL)
    private Set<PieOrderItem> pieOrderItems = new HashSet<>();

    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL)
    private Set<SweetOrderItem> sweetOrderItems = new HashSet<>();

    public Order(UUID id, Long orderNumber, boolean confirmed, boolean realized, User user, Set<CakeOrderItem> cakeOrderItems, Set<PieOrderItem> pieOrderItems, Set<SweetOrderItem> sweetOrderItems) {
        super(id);
        this.orderNumber = orderNumber;
        this.confirmed = confirmed;
        this.realized = realized;
        this.user = user;
        this.cakeOrderItems = cakeOrderItems;
        this.pieOrderItems = pieOrderItems;
        this.sweetOrderItems = sweetOrderItems;
    }

    public Order() {
        super(UUID.randomUUID());
    }

    public <E> Order(long l, boolean b, boolean b1, User user, HashSet<E> es, HashSet<E> es1, Set<SweetOrderItem> sweets) {
    }
}

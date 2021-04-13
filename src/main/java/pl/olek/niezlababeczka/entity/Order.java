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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

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

    public Order( Long orderNumber, boolean confirmed, boolean realized, User user, Set<CakeOrderItem> cakeOrderItems, Set<PieOrderItem> pieOrderItems, Set<SweetOrderItem> sweetOrderItems) {
        this.orderNumber = orderNumber;
        this.confirmed = confirmed;
        this.realized = realized;
        this.user = user;
        this.cakeOrderItems = cakeOrderItems;
        this.pieOrderItems = pieOrderItems;
        this.sweetOrderItems = sweetOrderItems;
    }
}

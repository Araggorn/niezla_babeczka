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
}

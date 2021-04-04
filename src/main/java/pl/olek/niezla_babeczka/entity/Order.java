package pl.olek.niezla_babeczka.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "orders")
public class Order extends ParentEntity {

    @Column(unique = true)
    Long orderNumber;

    boolean confirmed;
    boolean realized;

    @ManyToOne
    private User user;
}

package pl.olek.niezla_babeczka.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
public class Order extends ParentEntity {

    Long orderNumber;
    boolean confirmed;
    boolean realized;
}

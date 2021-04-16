package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends ParentEntity {

    private Double price;

    public Product(Double price) {
        super(UUID.randomUUID());
        this.price = price;
    }
}

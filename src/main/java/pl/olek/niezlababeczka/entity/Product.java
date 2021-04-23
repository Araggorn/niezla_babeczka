package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class Product extends ParentEntity {

    public Product() {
        super(UUID.randomUUID());
    }
}

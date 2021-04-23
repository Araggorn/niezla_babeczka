package pl.olek.niezlababeczka.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Cake extends Product {

    private Integer numberOfPortions;
    private String name;
    private String description;

    public Cake(Integer numberOfPortions, String name, String description) {
        super();
        this.numberOfPortions = numberOfPortions;
        this.description = description;
        this.name = name;
    }

}

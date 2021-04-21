package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Cake extends Product {

    private Integer numberOfPortions;
    private String name;

    public Cake(Integer numberOfPortions, String name) {
        super();
        this.numberOfPortions = numberOfPortions;
        this.name = name;
    }

}

package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cake extends Product {

    private Double radius;

    public Cake(Double price, Double radius) {
        super();
        this.radius = radius;
    }

}

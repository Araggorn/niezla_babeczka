package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cake extends Product {

    public Cake(Double price, Double radius) {
        super(price);
        this.radius = radius;
    }

    private Double radius;

}

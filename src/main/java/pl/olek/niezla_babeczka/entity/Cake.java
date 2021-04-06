package pl.olek.niezla_babeczka.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data

public class Cake extends Product {

    private Double radius;

}

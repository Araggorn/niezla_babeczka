package pl.olek.niezla_babeczka.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
public abstract class Product extends ParentEntity {

    Double price;

}

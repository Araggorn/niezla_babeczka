package pl.olek.niezla_babeczka.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Sweet extends Product {

Long quantity;

}

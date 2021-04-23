package pl.olek.niezlababeczka.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Pie extends Product {

    private String name;
    private String description;

}

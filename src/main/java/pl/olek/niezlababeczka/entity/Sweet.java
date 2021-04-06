package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sweet extends Product {

Long quantity;

}

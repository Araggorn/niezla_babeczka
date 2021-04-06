package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "baskets")
public class Basket extends ParentEntity {

    @ManyToMany(mappedBy = "orderList")
    List<Product> productList = new ArrayList<>();
}

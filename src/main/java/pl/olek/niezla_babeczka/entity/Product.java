package pl.olek.niezla_babeczka.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public abstract class Product extends ParentEntity {

    String name;
    Double price;


    @ManyToMany(mappedBy = "productList")
    List<Order> orderList = new ArrayList<>();

}

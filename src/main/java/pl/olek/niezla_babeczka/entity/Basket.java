package pl.olek.niezla_babeczka.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "baskets")
public class Basket extends ParentEntity {

    @ManyToMany(mappedBy = "orderList")
    List<Product> productList = new ArrayList<>();
}

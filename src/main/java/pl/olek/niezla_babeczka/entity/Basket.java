package pl.olek.niezla_babeczka.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "baskets")
public class Basket extends ParentEntity {

    @ManyToMany(mappedBy = "orderList")
    List<Product> productList = new ArrayList<>();
}

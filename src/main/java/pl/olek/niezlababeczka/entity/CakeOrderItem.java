package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class CakeOrderItem extends OrderItem {

    private int numberOfPortions;

    @OneToMany (mappedBy = "cakeOrderItem", cascade = CascadeType.ALL)
    private Set<CakeLayer> layerTaste;

    @ManyToOne
    @JoinColumn(name = "cake_id")
    private Cake cake;

    public CakeOrderItem(int numberOfPortions, Set<CakeLayer> layerTaste, Cake cake) {
        this.numberOfPortions = numberOfPortions;
        this.layerTaste = layerTaste;
        this.cake = cake;
    }

    public CakeOrderItem() {
    }
}

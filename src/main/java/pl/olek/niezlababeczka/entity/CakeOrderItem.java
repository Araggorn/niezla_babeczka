package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class CakeOrderItem extends OrderItem {

    private int numberOfPortions;

    @OneToMany (mappedBy = "cakeOrderItem")
    private Set<CakeLayer> layerTaste;

    @ManyToOne
    @JoinColumn(name = "cake_id")
    private Cake cake;

}

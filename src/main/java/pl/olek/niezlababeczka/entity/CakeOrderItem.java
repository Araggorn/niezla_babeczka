package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CakeOrderItem extends OrderItem {

 @ManyToOne
 @JoinColumn(name = "cakeoffer_id")
 private CakeOffer cakeOffer;

//    @OneToMany (mappedBy = "cakeOrderItem", cascade = CascadeType.ALL)
//    private Set<CakeLayer> layerTaste;
//
//    @ManyToOne
//    @JoinColumn(name = "cake_id")
//    private Cake cake;


    public CakeOrderItem() {
    }
}

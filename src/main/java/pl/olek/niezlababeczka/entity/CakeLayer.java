package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CakeLayer extends ParentEntity {

    @ManyToOne
    @JoinColumn(name = "cake_order_item_id")
    private CakeOrderItem cakeOrderItem;

    @ManyToOne
    @JoinColumn(name = "layer_taste_id")
    private LayerTaste layerTaste;

    public CakeLayer(CakeOrderItem cakeOrderItem, LayerTaste layerTaste) {
        super(UUID.randomUUID());
        this.cakeOrderItem = cakeOrderItem;
        this.layerTaste = layerTaste;
    }

    public CakeLayer() {
    }
}

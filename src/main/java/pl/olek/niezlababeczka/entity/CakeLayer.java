package pl.olek.niezlababeczka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CakeLayer extends ParentEntity {

    @ManyToOne
    @JoinColumn(name = "cake_order_item_id")
    private CakeOrderItem cakeOrderItem;

    @ManyToOne
    @JoinColumn(name = "layer_taste_id")
    private LayerTaste layerTaste;


    public CakeLayer(LayerTaste layerTaste) {
        this.layerTaste = layerTaste;
    }
}

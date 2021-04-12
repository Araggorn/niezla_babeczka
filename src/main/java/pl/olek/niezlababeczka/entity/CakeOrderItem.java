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


    private int layers;
    private int numberOfPortions;
    private LayerTastes layerTastes;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Cake cake;

}

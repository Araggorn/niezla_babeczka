package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PieOrderItem extends OrderItem {


    @ManyToOne
    @JoinColumn(name = "pie_offer_id")
    private PieOffer pieOffer;



}

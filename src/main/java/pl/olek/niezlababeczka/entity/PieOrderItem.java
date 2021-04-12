package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class PieOrderItem extends OrderItem {


    private PieSize pieSize;
    private PieType pieType;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Pie pie;
}

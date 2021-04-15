package pl.olek.niezlababeczka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "pie_size_id")
    private PieSize pieSize;


    @ManyToOne
    @JoinColumn(name = "pie_id")
    private Pie pie;


}

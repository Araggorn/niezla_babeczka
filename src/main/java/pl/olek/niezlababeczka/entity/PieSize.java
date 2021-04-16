package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PieSize extends ParentEntity{

    private String description; //ex. 24x24 , średnica:15cm, 36x24cm;

    public PieSize(String description) {
        super(UUID.randomUUID());
        this.description = description;
    }
    public PieSize(){}
}

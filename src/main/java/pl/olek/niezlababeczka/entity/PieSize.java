package pl.olek.niezlababeczka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PieSize extends ParentEntity{

    private String description; //ex. 24x24 , średnica:15cm, 36x24cm;
}

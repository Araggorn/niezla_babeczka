package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pie extends Product{

    private String name;
    private String description;

    public Pie(Double price, String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }
}

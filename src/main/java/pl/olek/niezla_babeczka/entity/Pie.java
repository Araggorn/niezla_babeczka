package pl.olek.niezla_babeczka.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data

public class Pie extends Product{


    private String size;

}

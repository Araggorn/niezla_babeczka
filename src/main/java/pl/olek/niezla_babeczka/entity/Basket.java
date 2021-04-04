package pl.olek.niezla_babeczka.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "baskets")
public class Basket extends ParentEntity {
}

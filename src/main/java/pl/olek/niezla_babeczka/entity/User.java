package pl.olek.niezla_babeczka.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Builder
@Data
public class User extends ParentEntity {
}
package pl.olek.niezlababeczka.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LayerTaste extends ParentEntity {

    private String taste;

    public LayerTaste(String taste) {
        super(UUID.randomUUID());
        this.taste = taste;
    }
}

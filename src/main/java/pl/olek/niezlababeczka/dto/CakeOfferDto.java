package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.Cake;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CakeOfferDto {
    private String name;
    private Integer numberOfPortions;
    private UUID id;

    public static CakeOfferDto toDto (Cake cake) {
        return CakeOfferDto.builder()
                .id(cake.getId())
                .name(cake.getName())
                .numberOfPortions(cake.getNumberOfPortions())
                .build();

    }
}

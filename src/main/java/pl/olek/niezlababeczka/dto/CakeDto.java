package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.Cake;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CakeDto {

    private String name;
    private Integer numberOfPortions;
    private String description;

    public static CakeDto toDto (Cake cake) {
        return CakeDto.builder()
                .name(cake.getName())
                .numberOfPortions(cake.getNumberOfPortions())
                .description(cake.getDescription())
                .build();

    }

}

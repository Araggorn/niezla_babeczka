package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.Cake;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CakeDto {

    private UUID id;
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

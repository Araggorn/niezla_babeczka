package pl.olek.niezlababeczka.dto;


import lombok.*;
import pl.olek.niezlababeczka.entity.Pie;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PieDto {

    private UUID id;
    private String name;
    private String description;

    public static PieDto toDto(Pie pie) {
        return PieDto.builder()
                .id(pie.getId())
                .name(pie.getName())
                .description(pie.getDescription())
                .build();
    }
}

package pl.olek.niezlababeczka.dto;

import lombok.*;
import pl.olek.niezlababeczka.entity.PieSize;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PieSizeDto {

    private UUID id;
    private String description;

    public static PieSizeDto toDto(PieSize pieSize) {
        return PieSizeDto.builder()
                .id(pieSize.getId())
                .description(pieSize.getDescription())
                .build();
    }
}

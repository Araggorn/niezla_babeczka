package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.LayerTaste;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LayerTasteDto {

    private String taste;
    private UUID id;

    public static LayerTasteDto toDto(LayerTaste layerTaste) {
        return LayerTasteDto.builder()
                .taste(layerTaste.getTaste())
                .id(layerTaste.getId())
                .build();
    }


}

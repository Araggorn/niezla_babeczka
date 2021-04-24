package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.LayerTaste;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LayerTasteDto {

    private String taste;

    public static LayerTasteDto toDto(LayerTaste layerTaste) {
        return LayerTasteDto.builder()
                .taste(layerTaste.getTaste())
                .build();
    }


}

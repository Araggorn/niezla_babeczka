package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.olek.niezlababeczka.entity.CakeLayer;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CakeLayerDto {

    private UUID layerTasteID;

    public static CakeLayerDto toDto(CakeLayer cakeLayer){
        return CakeLayerDto.builder()
                .layerTasteID(cakeLayer.getId())
                .build();

    }
}

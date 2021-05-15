package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezlababeczka.entity.SweetOrderItem;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class SweetOrderItemDto {

    private UUID sweetId;
    private int quantity;
    private UUID id;

    public static SweetOrderItemDto toDto (SweetOrderItem sweetOI) {
        return SweetOrderItemDto.builder()
                .quantity(sweetOI.getQuantity())
                .sweetId(sweetOI.getSweet().getId())
                .id(sweetOI.getId())
                .build();
    }
}

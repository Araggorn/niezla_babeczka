package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezlababeczka.entity.Sweet;

@Data
@AllArgsConstructor
@Builder
public class SweetDto {
    String name;
    Double price;

    public static SweetDto toDto (Sweet sweet){
        return SweetDto.builder()
                .name(sweet.getName())
                .build();
    }
}

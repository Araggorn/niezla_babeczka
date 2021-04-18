package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CakeAddDto {

    private double radius;
    private double price;
    private int numberOfPortions;

//    public static CakeAddDto toDto (Cake cake) {
//        return CakeAddDto.builder()
//                .radius(cake.getRadius())
//                .price(cake.getPrice())
//                .numberOfPortions(cake.getNumberOfPortions)
//                .build();
//
//    }

}

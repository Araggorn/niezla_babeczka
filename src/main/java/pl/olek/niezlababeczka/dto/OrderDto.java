package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class OrderDto {

    private UUID id;
    private UUID pieOrderId;
    private UUID cakeOrderId;
    private UUID sweetId;
    String user;

//    public static OrderDto toDto(Order order1) {
//        return OrderDto.builder()
//                .orderNumber(order1.getOrderNumber())
//                .user(order1.getUser().getLogin())
//                .build();
//
//    }
}

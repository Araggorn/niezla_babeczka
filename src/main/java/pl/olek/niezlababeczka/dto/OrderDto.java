package pl.olek.niezlababeczka.dto;

import lombok.*;
import pl.olek.niezlababeczka.entity.Order;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class OrderDto {

    Long orderNumber;
    String user;

    public static OrderDto toDto(Order order1) {
        return OrderDto.builder()
                .orderNumber(order1.getOrderNumber())
                .user(order1.getUser().getLogin())
                .build();

    }
}

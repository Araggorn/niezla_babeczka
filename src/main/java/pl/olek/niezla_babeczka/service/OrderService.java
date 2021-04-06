package pl.olek.niezla_babeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezla_babeczka.repository.OrderRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class OrderService {

    OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

//    public OrderDto addOrder(OrderDto orderDto) {
//        Order order = Order.builder()
//                .orderNumber(orderDto.getOrderNumber())
////                .user(orderDto.getUser(login))
//                .build();
//        Order order1 = orderRepo.save(order);
//        log.info("added order with id{}", order1.getId());
//        return OrderDto.toDto(order1);
//    }
}

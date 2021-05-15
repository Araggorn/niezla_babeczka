package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.CakeOfferRepo;
import pl.olek.niezlababeczka.repository.OrderRepo;
import pl.olek.niezlababeczka.repository.PieOfferRepo;
import pl.olek.niezlababeczka.repository.SweetRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class OrderService {

   private final OrderRepo orderRepo;
   private final CakeOfferRepo cakeOfferRepo;
   private final PieOfferRepo pieOfferRepo;
   private final SweetRepo sweetRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo, CakeOfferRepo cakeOfferRepo, PieOfferRepo pieOfferRepo, SweetRepo sweetRepo) {
        this.orderRepo = orderRepo;
        this.cakeOfferRepo = cakeOfferRepo;
        this.pieOfferRepo = pieOfferRepo;
        this.sweetRepo = sweetRepo;
    }

//    public OrderDto addOrder(OrderDto orderDto) {
//        Order order = Order.builder()
//                .orderNumber(orderDto.getOrderNumber())
//               .user(orderDto.getUser(login))
//                .build();
//        Order order1 = orderRepo.save(order);
//        log.info("added order with id{}", order1.getId());
//        return OrderDto.toDto(order1);
//    }
}

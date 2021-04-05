package pl.olek.niezla_babeczka.service;

import pl.olek.niezla_babeczka.repository.OrderRepo;

public class OrderService {

    OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}

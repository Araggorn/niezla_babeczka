package pl.olek.niezla_babeczka.service;

import pl.olek.niezla_babeczka.repository.BasketRepo;

public class BasketService {

    BasketRepo basketRepo;

    public BasketService(BasketRepo basketRepo) {
        this.basketRepo = basketRepo;
    }
}

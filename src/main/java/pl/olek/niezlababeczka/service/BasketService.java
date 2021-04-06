package pl.olek.niezlababeczka.service;

import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.BasketRepo;

@Service
public class BasketService {

    BasketRepo basketRepo;

    public BasketService(BasketRepo basketRepo) {
        this.basketRepo = basketRepo;
    }
}

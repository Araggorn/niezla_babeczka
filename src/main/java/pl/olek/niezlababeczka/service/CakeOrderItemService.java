package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.CakeOrderItemRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class CakeOrderItemService {

    private final CakeOrderItemRepo cakeOrderItemRepo;

    public CakeOrderItemService(CakeOrderItemRepo cakeOrderItemRepo) {
        this.cakeOrderItemRepo = cakeOrderItemRepo;
    }
}

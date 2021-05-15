package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.PieOrderItemRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class PieOrderItemService {

    private final PieOrderItemRepo pieOrderItemRepo;

    public PieOrderItemService(PieOrderItemRepo pieOrderItemRepo) {
        this.pieOrderItemRepo = pieOrderItemRepo;
    }
}

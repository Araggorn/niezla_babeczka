package pl.olek.niezlababeczka.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.SweetRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class SweetService {

    private final SweetRepo sweetRepo;

    public SweetService(SweetRepo sweetRepo) {
        this.sweetRepo = sweetRepo;
    }
}

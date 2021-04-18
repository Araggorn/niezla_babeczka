package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.PieSizeRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class PieSizeService {

    private final PieSizeRepo pieSizeRepo;

    public PieSizeService(PieSizeRepo pieSizeRepo) {
        this.pieSizeRepo = pieSizeRepo;
    }
}

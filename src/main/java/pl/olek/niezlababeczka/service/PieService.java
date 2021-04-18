package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.PieRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class PieService {

    private final PieRepo pieRepo;

    public PieService(PieRepo pieRepo) {
        this.pieRepo = pieRepo;
    }
}

package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeAddDto;
import pl.olek.niezlababeczka.dto.UserAddDto;
import pl.olek.niezlababeczka.entity.Cake;
import pl.olek.niezlababeczka.entity.User;
import pl.olek.niezlababeczka.repository.CakeRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class CakeService {

    private final CakeRepo cakeRepo;

    @Autowired
    public CakeService(CakeRepo cakeRepo) {
        this.cakeRepo = cakeRepo;
    }

    public CakeAddDto addCake(CakeAddDto cakeAddDto){
        Cake cake = Cake.builder()
                .radius(cakeAddDto.getRadius())
                .price(cakeAddDto.getPrice())
                .name(cakeAddDto.getName())
                .build();
        Cake cakeSaved = cakeRepo.save(cake);
        log.info("added cake with id{}",cakeSaved.getId());
        return CakeAddDto.toDto(cakeSaved);
    }
}

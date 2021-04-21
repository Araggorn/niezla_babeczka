package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeDto;
import pl.olek.niezlababeczka.entity.Cake;
import pl.olek.niezlababeczka.repository.CakeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class CakeService {

    private final CakeRepo cakeRepo;

    @Autowired
    public CakeService(CakeRepo cakeRepo) {
        this.cakeRepo = cakeRepo;
    }

    public CakeDto addCake(CakeDto cakeDto) {
        Cake cake = Cake.builder()
                .name(cakeDto.getName())
                .description(cakeDto.getDescription())
                .numberOfPortions(cakeDto.getNumberOfPortions())
                .build();
        Cake cakeSaved = cakeRepo.save(cake);
        log.info("added cake with id{}", cakeSaved.getId());
        return CakeDto.toDto(cakeSaved);
    }

    public List<CakeDto> showAllCakes() {
        log.info("Show list of cakes");
        return cakeRepo.getAllByDeletedIsFalse()
                .stream()
                .map(CakeDto::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        log.info("Deleting cake by id: {}", id);
        Cake cake = cakeRepo.getOne(id);
        cake.setDeleted(true);
        cakeRepo.save(cake);
    }

    public Optional<CakeDto> findById(UUID id) {
        log.info("We are looking for cake with id: {}", id);
        return cakeRepo.findById(id).map(CakeDto::toDto);
    }
}

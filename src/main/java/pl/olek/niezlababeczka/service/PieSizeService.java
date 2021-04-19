package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.PieSizeDto;
import pl.olek.niezlababeczka.entity.PieSize;
import pl.olek.niezlababeczka.repository.PieSizeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class PieSizeService {

    private final PieSizeRepo pieSizeRepo;

    public PieSizeService(PieSizeRepo pieSizeRepo) {
        this.pieSizeRepo = pieSizeRepo;
    }

    public PieSizeDto addPieSize(PieSizeDto pieSizeDto) {
        PieSize pieSize = PieSize.builder()
                .description(pieSizeDto.getDescription())
                .build();
        PieSize pieSSav = pieSizeRepo.save(pieSize);
        pieSize.setId(UUID.randomUUID());
        log.info("added pie with id{}", pieSSav.getId());
        return PieSizeDto.toDto(pieSSav);
    }

    public List<PieSizeDto> showAllPieSizes() {
        log.info("Show list of pies");
        return pieSizeRepo.getAllByDeletedIsFalse()
                .stream()
                .map(PieSizeDto::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        log.info("Deleting pie by id: {}", id);
        PieSize pieSize = pieSizeRepo.getOne(id);
        pieSize.setDeleted(true);
        pieSizeRepo.save(pieSize);
    }

    public Optional<PieSizeDto> findById(UUID id) {
        log.info("We are looking for pie with id: {}", id);
        return pieSizeRepo.findById(id).map(PieSizeDto::toDto);
    }
}

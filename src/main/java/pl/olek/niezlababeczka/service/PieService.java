package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.PieDto;
import pl.olek.niezlababeczka.entity.Pie;
import pl.olek.niezlababeczka.repository.PieRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class PieService {

    private final PieRepo pieRepo;

    public PieService(PieRepo pieRepo) {
        this.pieRepo = pieRepo;
    }


    public PieDto addPie(PieDto pieDto) {
        Pie pie = Pie.builder()
                .name(pieDto.getName())
                .description(pieDto.getDescription())
                .build();
        Pie pieSav = pieRepo.save(pie);
        pie.setId(UUID.randomUUID());
        log.info("added pie with id{}", pieSav.getId());
        return PieDto.toDto(pieSav);
    }

    public List<PieDto> showAllPies() {
        log.info("Show list of pies");
        return pieRepo.getAllByDeletedIsFalse()
                .stream()
                .map(PieDto::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        log.info("Deleting pie by id: {}", id);
        Pie pie = pieRepo.getOne(id);
        pie.setDeleted(true);
        pieRepo.save(pie);
    }

    public Optional<PieDto> findById(UUID id) {
        log.info("We are looking for pie with id: {}", id);
        return pieRepo.findById(id).map(PieDto::toDto);
    }

}

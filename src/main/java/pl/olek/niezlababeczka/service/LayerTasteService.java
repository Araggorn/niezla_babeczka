package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeDto;
import pl.olek.niezlababeczka.dto.LayerTasteDto;
import pl.olek.niezlababeczka.entity.Cake;
import pl.olek.niezlababeczka.entity.LayerTaste;
import pl.olek.niezlababeczka.repository.LayerTasteRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class LayerTasteService {

   private final LayerTasteRepo layerTasteRepo;

   @Autowired
    public LayerTasteService(LayerTasteRepo layerTasteRepo) {
        this.layerTasteRepo = layerTasteRepo;
    }


    public LayerTasteDto addLayerTaste(LayerTasteDto layerTasteDto) {
        LayerTaste lt = LayerTaste.builder()
                .taste(layerTasteDto.getTaste())
                .build();
        LayerTaste ltSaved = layerTasteRepo.save(lt);
        log.info("added cake with id{}", ltSaved.getId());
        return LayerTasteDto.toDto(ltSaved);
    }

    public List<LayerTasteDto> showAllLayerTaste() {
        log.info("Show list of layer tastes");
        return layerTasteRepo.getAllByDeletedIsFalse()
                .stream()
                .map(LayerTasteDto::toDto)
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

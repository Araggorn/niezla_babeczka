package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.LayerTasteDto;
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
        log.info("Deleting layer taste by id: {}", id);
        LayerTaste layerTaste = layerTasteRepo.getOne(id);
        layerTaste.setDeleted(true);
        layerTasteRepo.save(layerTaste);
    }

    public Optional<LayerTasteDto> findById(UUID id) {
        log.info("We are looking for cake with id: {}", id);
        return layerTasteRepo.findById(id).map(LayerTasteDto::toDto);
    }
}

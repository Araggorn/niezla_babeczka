package pl.olek.niezlababeczka.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.CakeLayerDto;
import pl.olek.niezlababeczka.entity.CakeLayer;
import pl.olek.niezlababeczka.repository.CakeLayerRepo;
import pl.olek.niezlababeczka.repository.LayerTasteRepo;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class CakeLayerService {

    private final CakeLayerRepo cakeLayerRepo;
    private final LayerTasteRepo layerTasteRepo;

    public CakeLayerService(CakeLayerRepo cakeLayerRepo, LayerTasteRepo layerTasteRepo) {
        this.cakeLayerRepo = cakeLayerRepo;
        this.layerTasteRepo = layerTasteRepo;
    }

    public CakeLayerDto addCakeLayer(CakeLayerDto cakeLayerDto){

        CakeLayer cakeLeyer = CakeLayer.builder()
                .layerTaste(layerTasteRepo.getOne(cakeLayerDto.getLayerTasteID()))
                .build();
        CakeLayer cakeLayerSaved = cakeLayerRepo.save(cakeLeyer);
        log.info("adding CakeLayer with id {}", cakeLayerSaved.getId());
        return CakeLayerDto.toDto(cakeLayerSaved);
    }

    public Set<CakeLayerDto> showAllCakeLayers() {
        log.info("Show list of cakeLayers");
        return cakeLayerRepo.getAllByDeletedIsFalse()
                .stream()
                .map(CakeLayerDto::toDto)
                .collect(Collectors.toSet());
    }
    public void deleteById(UUID id) {
        log.info("Deleting cakeOffer by id: {}", id);
        CakeLayer cakeLayer = cakeLayerRepo.getOne(id);
        cakeLayer.setDeleted(true);
        cakeLayerRepo.save(cakeLayer);
    }
    public Optional<CakeLayerDto> findById(UUID id) {
        log.info("We are looking for cakeLayer with id: {}", id);
        return cakeLayerRepo.findById(id).map(CakeLayerDto::toDto);
    }
}

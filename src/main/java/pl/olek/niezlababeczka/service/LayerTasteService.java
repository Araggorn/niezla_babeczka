package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.LayerTasteRepo;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class LayerTasteService {

   private final LayerTasteRepo layerTasteRepo;

   @Autowired
    public LayerTasteService(LayerTasteRepo layerTasteRepo) {
        this.layerTasteRepo = layerTasteRepo;
    }
}

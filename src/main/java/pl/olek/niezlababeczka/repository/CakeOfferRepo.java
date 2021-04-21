package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.CakeOffer;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CakeOfferRepo extends JpaRepository <CakeOffer, UUID> {
    Set<CakeOffer> getAllByDeletedIsFalse();
}

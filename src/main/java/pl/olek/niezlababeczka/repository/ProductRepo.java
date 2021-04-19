package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Product;

import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository <Product, UUID> {
}

package pl.olek.niezlababeczka.service;

import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.repository.ProductRepo;

@Service
public class ProductService {

    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}

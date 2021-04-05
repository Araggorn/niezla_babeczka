package pl.olek.niezla_babeczka.service;

import pl.olek.niezla_babeczka.repository.ProductRepo;

public class ProductService {

    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}

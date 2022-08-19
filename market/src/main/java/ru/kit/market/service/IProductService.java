package ru.kit.market.service;

import java.util.Collection;
import java.util.List;

import ru.kit.market.exception.ProductAlreadyExistException;
import ru.kit.market.exception.ProductNotFoundException;
import ru.kit.market.model.Product;

public interface IProductService {
    long addProduct(Product product) throws ProductAlreadyExistException;
    List<Product> getAllProduct();
    List<Product> getAllProductByTypeId(Long id);
    List<Product> getAllProductByBrandId(Long id);
    Product getProductById(Long id);
    long deleteProductById(Long id) throws ProductNotFoundException;
    List<Long> deleteListProductById(Collection<Long> id);
}

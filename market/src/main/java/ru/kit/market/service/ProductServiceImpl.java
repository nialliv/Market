package ru.kit.market.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kit.market.exception.ProductAlreadyExistException;
import ru.kit.market.exception.ProductNotFoundException;
import ru.kit.market.model.Product;
import ru.kit.market.repository.ProductRepository;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(Product product) throws ProductAlreadyExistException {
        if (productRepository.findByName(product.getName()) != null) {
            throw new ProductAlreadyExistException("Error, this product has already been created");
        }
        return productRepository.save(product).getId();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductByTypeId(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProductByBrandId(Long id) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public long deleteProductById(Long id) throws ProductNotFoundException {
        if (productRepository.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Error, this user was not found");
        }
        productRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Long> deleteListProductById(Collection<Long> id) {
        return null;
    }
}

package ru.kit.basketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kit.basketapp.model.BasketProduct;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
}

package ru.kit.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kit.market.model.BasketProduct;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
}

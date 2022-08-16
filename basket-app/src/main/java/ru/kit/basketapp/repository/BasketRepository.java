package ru.kit.basketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kit.basketapp.model.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}

package ru.kit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kit.backend.model.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}

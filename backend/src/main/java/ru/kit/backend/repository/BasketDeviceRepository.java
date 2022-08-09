package ru.kit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kit.backend.model.BasketDevice;

@Repository
public interface BasketDeviceRepository extends JpaRepository<BasketDevice, Long> {
}

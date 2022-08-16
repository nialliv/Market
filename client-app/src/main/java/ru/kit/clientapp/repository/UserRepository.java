package ru.kit.clientapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kit.clientapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
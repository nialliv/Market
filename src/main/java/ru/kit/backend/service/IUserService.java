package ru.kit.backend.service;

import ru.kit.backend.exception.UserAlreadyExistException;
import ru.kit.backend.exception.UserNotFoundException;
import ru.kit.backend.model.User;

import java.util.List;

public interface IUserService {
    long saveUser(User user) throws UserAlreadyExistException;
    List<User> getUsers();
    long deleteUserById(long id) throws UserNotFoundException;
}

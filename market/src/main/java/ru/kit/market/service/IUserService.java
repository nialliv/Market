package ru.kit.market.service;

import ru.kit.market.exception.UserAlreadyExistException;
import ru.kit.market.exception.UserNotFoundException;
import ru.kit.market.model.User;

import java.util.List;

public interface IUserService {
    long saveUser(User user) throws UserAlreadyExistException;
    List<User> getUsers();
    long deleteUserById(long id) throws UserNotFoundException;
}

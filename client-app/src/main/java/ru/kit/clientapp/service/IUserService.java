package ru.kit.clientapp.service;

import ru.kit.clientapp.exception.UserAlreadyExistException;
import ru.kit.clientapp.exception.UserNotFoundException;
import ru.kit.clientapp.model.User;

import java.util.List;

public interface IUserService {
    long saveUser(User user) throws UserAlreadyExistException;
    List<User> getUsers();
    long deleteUserById(long id) throws UserNotFoundException;
}

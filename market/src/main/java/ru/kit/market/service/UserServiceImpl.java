package ru.kit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.kit.market.exception.UserAlreadyExistException;
import ru.kit.market.exception.UserNotFoundException;
import ru.kit.market.model.User;
import ru.kit.market.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public long saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.findByName(user.getName()) != null) {
            throw new UserAlreadyExistException("Error, this user has already been created");
        }
        return userRepository.save(user).getId();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("Error, this user was not found");
        } else {
            return userRepository.findById(id).get();
        }
    }

    @Override
    public long deleteUserById(long id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("Error, this user was not found");
        }
        userRepository.deleteById(id);
        return id;
    }
}

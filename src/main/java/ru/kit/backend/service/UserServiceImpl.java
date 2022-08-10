package ru.kit.backend.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kit.backend.exception.UserAlreadyExistException;
import ru.kit.backend.exception.UserNotFoundException;
import ru.kit.backend.model.User;
import ru.kit.backend.repository.UserRepository;

import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    public long deleteUserById(long id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("Error, this user was not found");
        }
        userRepository.deleteById(id);
        return id;
    }
}
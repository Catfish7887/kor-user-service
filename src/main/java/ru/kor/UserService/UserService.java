package ru.kor.UserService;

import java.util.Optional;

import ru.kor.Exceptions.User.InvalidFieldsException;
import ru.kor.Exceptions.UserRepository.RepositoryError;
import ru.kor.Exceptions.UserRepository.RepositoryErrorCodes;
import ru.kor.User.User;
import ru.kor.UserRepository.UserRepository;

public class UserService {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(long id) throws RepositoryError {
        Optional<User> data = repository.findById(id);
        if (data.isEmpty()) {
            throw new RepositoryError("Пользователь с указанным ID не найден.", RepositoryErrorCodes.USER_NOT_FOUND);
        }

        return data.get();
    }

    public User createUser(User user) throws InvalidFieldsException, RepositoryError {
            repository.save(user);
            return user;
        
    }

    public void deleteUser(long id) throws RepositoryError {
            repository.deleteById(id);
    }

}

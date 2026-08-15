package ru.kor.UserService;

import java.util.Optional;

import ru.kor.Exceptions.User.InvalidFieldsException;
import ru.kor.Exceptions.UserRepository.RepositoryError;
import ru.kor.Exceptions.UserService.InvalidDataException;
import ru.kor.Exceptions.UserService.UserNotFoundException;
import ru.kor.RequestParser.RequestParser;
import ru.kor.User.User;
import ru.kor.UserRepository.UserRepository;

public class UserService {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(long id) throws UserNotFoundException {
        Optional<User> data = repository.findById(id);
        if (data.isEmpty()) {
            throw new UserNotFoundException("Пользователь с указанным ID не найден.");
        }

        return data.get();
    }

    public void createUser(String data) throws InvalidDataException, RepositoryError {
        try {
            User user = RequestParser.parse(data);
            repository.save(user);
        } catch (InvalidFieldsException e) {
            throw new InvalidDataException("Некорректные данные: " + e.getMessage());
        } catch (RepositoryError e) {
            throw new RepositoryError("Произошла ошибка хранилища: " + e.getMessage());
        }

    }

    public void deleteUser(long id) throws UserNotFoundException, RepositoryError {
        Optional<User> data = repository.findById(id);
        if (data.isEmpty()) {
            throw new UserNotFoundException("Пользователь с указанным ID не найден.");
        }

        try {
            repository.deleteById(id);
        } catch (RepositoryError e) {
            throw new RepositoryError("Произошла ошибка хранилища: " + e.getMessage());
        }

    }

}

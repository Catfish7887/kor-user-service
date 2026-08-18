package ru.kor.UserService;

import java.util.Optional;

import ru.kor.User.User;
import ru.kor.UserRepository.UserRepository;
import ru.kor.Utils.Exceptions.UserRepository.RepositoryError;
import ru.kor.Utils.Exceptions.UserRepository.Utils.RepositoryErrorCodes;
import ru.kor.Utils.Exceptions.Validation.ValidationException;

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

    public User createUser(User user) throws ValidationException, RepositoryError {
            repository.save(user);
            return user;
        
    }

    public void deleteUser(long id) throws RepositoryError {
            repository.deleteById(id);
    }

}

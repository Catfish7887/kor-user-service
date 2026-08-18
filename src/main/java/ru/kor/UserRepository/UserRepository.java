package ru.kor.UserRepository;

import java.util.Optional;

import ru.kor.User.User;
import ru.kor.Utils.Exceptions.UserRepository.RepositoryError;
public interface UserRepository {

    void save(User user) throws RepositoryError;

    Optional<User> findById(long id);

    void deleteById(long id) throws RepositoryError;
}

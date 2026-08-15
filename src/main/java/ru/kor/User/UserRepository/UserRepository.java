package ru.kor.User.UserRepository;

import java.util.Optional;

import ru.kor.Exceptions.RepositoryError;
import ru.kor.User.User;
public interface UserRepository {

    void save(User user) throws RepositoryError;

    Optional<User> findById(long id);

    void deleteById(long id) throws RepositoryError;
}

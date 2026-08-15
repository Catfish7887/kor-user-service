package ru.kor.UserService;

import java.util.Optional;

import ru.kor.Exceptions.UserService.UserNotFoundException;
import ru.kor.User.User;
import ru.kor.UserRepository.UserRepository;

public class UserService {

    UserRepository repository;

    public UserService(UserRepository rep) {
        this.repository = rep;
    }

    public User findById(long id)throws UserNotFoundException{
        Optional<User> data = repository.findById(id);
        if(data.isEmpty())
            throw new UserNotFoundException("Пользователь с указанным ID не найден.");
        
        return data.get();
    }
}

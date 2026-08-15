package ru.kor.User.UserService;

import ru.kor.User.UserRepository.UserRepository;

public class UserService {

    UserRepository repository;

    public UserService(UserRepository rep) {
        this.repository = rep;
    }

    public void findById()
}

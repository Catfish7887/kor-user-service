package ru.kor.UserRepository;
import java.util.HashMap;
import java.util.Optional;

import ru.kor.Exceptions.UserRepository.RepositoryError;
import ru.kor.Exceptions.UserRepository.RepositoryErrorCodes;
import ru.kor.User.User;
public class InMemoryUserRepository implements UserRepository {
    final private HashMap<Long, User> storage;

    public InMemoryUserRepository(){
        this.storage = new HashMap<>();
    }

    @Override
    public Optional<User> findById(long id){
        return Optional.ofNullable(storage.get(id));
        
    }
    @Override
    public void deleteById(long id)throws RepositoryError{
        if(!(storage.containsKey(id)))
            throw new RepositoryError("Пользователь с указанным ID не найден", RepositoryErrorCodes.USER_NOT_FOUND);
        storage.remove(id);
    }
    @Override
    public void save(User user) throws RepositoryError{

        if(storage.containsKey(user.getId()))
            throw new RepositoryError("Пользователь с указанным ID уже существует", RepositoryErrorCodes.DUPLICATE_ID);

        storage.put(user.getId(), user);
    }
}


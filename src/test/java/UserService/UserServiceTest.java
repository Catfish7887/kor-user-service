package UserService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.kor.Exceptions.User.InvalidFieldsException;
import ru.kor.Exceptions.UserRepository.RepositoryError;
import ru.kor.Exceptions.UserService.UserNotFoundException;
import ru.kor.RequestParser.RequestParser;
import ru.kor.User.User;
import ru.kor.UserRepository.InMemoryUserRepository;
import ru.kor.UserRepository.UserRepository;
import ru.kor.UserService.UserService;

public class UserServiceTest {
    private  UserRepository repository;
    private UserService service;
    String data = "id=1;name=name;email=email";
    @BeforeEach
    @SuppressWarnings("unused")
    void setup(){
        repository = new InMemoryUserRepository();
        service = new UserService(repository);
    }
    
    @Test
    // Существующий идентификатор
    void testGetById()throws UserNotFoundException, InvalidFieldsException, RepositoryError{
        User user_1 = RequestParser.parse(data);
        // User user_2 = RequestParser.parse("id=2;name=name;email=email");

        repository.save(user_1);
        service.findById(user_1.getId());

        assertThrows(UserNotFoundException.class, () -> {
            service.findById(2);
        });
    }

    @Test
    void testCreateUser() throws InvalidFieldsException, RepositoryError, UserNotFoundException{
        User user = RequestParser.parse(data);
        service.createUser(user);
        service.findById(user.getId());
    }

    @Test
    void testDeleteUser()throws UserNotFoundException, RepositoryError, InvalidFieldsException {
        User user = RequestParser.parse(data);
        service.createUser(user);
        service.findById(user.getId());
        service.deleteUser(user.getId());
        assertThrows(UserNotFoundException.class, ()->{

            service.findById(user.getId());
        });
    }

}

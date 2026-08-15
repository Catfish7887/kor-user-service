package UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import ru.kor.Exceptions.InvalidFieldsException;
import ru.kor.Exceptions.RepositoryError;
import ru.kor.RequestParser.RequestParser;
import ru.kor.User.User;
import ru.kor.User.UserRepository.InMemoryUserRepository;

public class UserRepositoryTest {

    final String data = "name=name;email=email@ex.com;id=1";

    @Test
    void shouldAddUser() throws InvalidFieldsException, RepositoryError {
        User user = RequestParser.parse(data);

        InMemoryUserRepository rep = new InMemoryUserRepository();
        rep.save(user);
    }
    @Test
    void shouldThrowException() throws InvalidFieldsException, RepositoryError {
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        assertThrows(RepositoryError.class, () -> {
            rep.save(user);
        });

    }
    @Test
    void shouldNotThrowException() throws InvalidFieldsException, RepositoryError{
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        rep.deleteById(user.getId());
        rep.save(user);

    }
    @Test 
    void testGetById()throws InvalidFieldsException, RepositoryError{
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        assertEquals(user, rep.findById(user.getId()).get());
    }
    @Test
    void testRemoveById()throws InvalidFieldsException, RepositoryError{
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        rep.deleteById(user.getId());
        assertEquals(Optional.empty(), rep.findById(user.getId()));
    assertEquals(Optional.empty(), rep.findById(123));
    }
}

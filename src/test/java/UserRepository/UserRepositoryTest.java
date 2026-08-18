package UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import ru.kor.RequestParser.RequestParser;
import ru.kor.User.User;
import ru.kor.UserRepository.InMemoryUserRepository;
import ru.kor.Utils.Exceptions.UserRepository.RepositoryError;
import ru.kor.Utils.Exceptions.Validation.ValidationException;

public class UserRepositoryTest {

    final String data = "name=name;email=email@ex.com;id=1";

    @Test
    void shouldAddUser() throws ValidationException, RepositoryError {
        User user = RequestParser.parse(data);

        InMemoryUserRepository rep = new InMemoryUserRepository();
        rep.save(user);
    }
    @Test
    void shouldThrowException() throws ValidationException, RepositoryError {
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        assertThrows(RepositoryError.class, () -> {
            rep.save(user);
        });

    }
    @Test
    void shouldNotThrowException() throws ValidationException, RepositoryError{
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        rep.deleteById(user.getId());
        rep.save(user);

    }
    @Test 
    void testGetById()throws ValidationException, RepositoryError{
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        assertEquals(user, rep.findById(user.getId()).get());
    }
    @Test
    void testRemoveById()throws ValidationException, RepositoryError{
        InMemoryUserRepository rep = new InMemoryUserRepository();
        User user = RequestParser.parse(data);
        rep.save(user);
        rep.deleteById(user.getId());
        assertEquals(Optional.empty(), rep.findById(user.getId()));
    assertEquals(Optional.empty(), rep.findById(123));
    }
}

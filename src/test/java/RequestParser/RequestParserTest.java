package RequestParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import ru.kor.RequestParser.RequestParser;
import ru.kor.User.User;
import ru.kor.Utils.Exceptions.Validation.ValidationException;

public class RequestParserTest {

    @Test
    void shouldParse()  throws ValidationException{
        User user = RequestParser.parse("id=1;name=name1;email=email@xp.sa");
        assertEquals("name1", user.getName());
        assertEquals("email@xp.sa", user.getEmail());
        assertEquals(1, user.getId());

    }

    @Test
    void shouldThrowException() {
        assertThrows(ValidationException.class, () -> {
            User user = RequestParser.parse("id=; name=name");
        });

    }
}

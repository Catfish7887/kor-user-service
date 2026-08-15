

import ru.kor.Exceptions.User.InvalidFieldsException;
import ru.kor.RequestParser.RequestParser;
import ru.kor.User.User;
public class Main {
    public static void main(String[] args) {
        try {
            User user = RequestParser.parse("id=1;name=pole=po;email=example");
            System.out.println(user);
        } catch (InvalidFieldsException e) {
            System.out.println(e.getMessage());
        }
    }
}

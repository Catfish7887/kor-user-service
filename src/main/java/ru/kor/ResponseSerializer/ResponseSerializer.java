package ru.kor.ResponseSerializer;
import ru.kor.User.User;

public class ResponseSerializer {

    public static String serializeUser(User user) {
        String result = "{\"id\":" + user.getId()
                + ",\"email\":\"" + user.getEmail()
                + "\",\"name\":\"" + user.getName()
                + "\"}";
        return result;
    }
}

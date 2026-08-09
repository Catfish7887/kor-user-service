package ru.kor.RequestParser;

import ru.kor.Exceptions.InvalidFieldsException;
import ru.kor.User.User;

public class RequestParser {

    public static User parse(String data) throws InvalidFieldsException {
        // Начальная инициализация 
        User user = new User(-1, null, null);

        String[] dataArray = data.split(";");
        for (int i = 0; i < dataArray.length; i++) {
            String[] field = dataArray[i].split("=");
            if(field.length < 2)
                throw new InvalidFieldsException("Некорректный размер поля");
            String key = field[0];
            String value = field[1];

            // Если значение отсутствует
            if (key == null || value == null) {
                throw new InvalidFieldsException("Значение поля(ей) некорретно");
            }

            switch (key){
                case "id":{
                    Long id = Long.parseLong(value);
                    if(id < 0){
                        throw new InvalidFieldsException("Значение ID не может быть меньше 0");
                    }
                    user.setId(id);
                    break;
                }
                case "email":
                    user.setEmail(value);
                    break;
                case "name":
                    user.setName(value);
                    break;
                default:
                    throw new InvalidFieldsException("Значение поля(ей) некорретно");
            }
        }
        return user;
    }
}

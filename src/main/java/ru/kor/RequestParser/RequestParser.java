package ru.kor.RequestParser;

import ru.kor.User.User;
import ru.kor.Utils.Exceptions.Validation.Utils.ValidationErrorCodes;
import ru.kor.Utils.Exceptions.Validation.ValidationException;

public class RequestParser {

    public static User parse(String data) throws ValidationException {
        // Начальная инициализация 
        User user = new User(-1, null, null);

        String[] dataArray = data.split(";");
        for (int i = 0; i < dataArray.length; i++) {
            String[] field = dataArray[i].split("=",2);
            if (field.length < 2) {
                throw new ValidationException("Некорректный размер поля", ValidationErrorCodes.INCORRECT_FIELD_LEGTH);
            }
            String key = field[0];
            String value = field[1];

            // Если значение отсутствует
            switch (key) {
                case "id": {
                    try {
                        long id = Long.parseLong(value);
                        if (id < 0) {
                            throw new ValidationException("Значение ID не может быть меньше 0", ValidationErrorCodes.INCORRECT_FIELD_DATA);
                        }
                        user.setId(id);
                        break;
                    } catch (NumberFormatException e) {
                        throw new ValidationException("Неправильный формат поля ID", ValidationErrorCodes.INCORRECT_FIELD_DATA);
                    }

                }
                case "email":
                    user.setEmail(value);
                    break;
                case "name":
                    user.setName(value);
                    break;
                default:
                    throw new ValidationException("Значение поля(ей) некорретно", ValidationErrorCodes.INCORRECT_FIELD_DATA);
            }
        }

        if (user.getId() == -1 || user.getEmail() == null || user.getName() == null) {
            throw new ValidationException("Одно или несколько полей пустые", ValidationErrorCodes.NULL_FIELD);
        }

        return user;
    }
}

package ru.kor.ErrorMapper;

import ru.kor.APIresponse.APIresponse;

public class GlobalErrorMapper {
    public static APIresponse mapError(RuntimeException e) {
        // Тут будет логика логирования
        System.out.println(e);

        return new APIresponse("Произошла неизвестная ошибка", 500);
    }
}

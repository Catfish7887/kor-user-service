package ru.kor.ErrorRegistry;

import ru.kor.APIresponse.APIresponse;
import ru.kor.ErrorMapper.RepositoryErrorMapper;
import ru.kor.ErrorMapper.ValidationErrorMapper;
import ru.kor.ErrorMapper.utils.ErrorMapper;

import java.util.List;

public class ErrorRegistry {
    private static final List<Class<? extends ErrorMapper>> mappers = List.<Class<? extends ErrorMapper>>of(
            RepositoryErrorMapper.class,
            ValidationErrorMapper.class);

    public static ErrorMapper getMapper(Exception e) {

        for (Class<? extends ErrorMapper> mapper : mappers) {

        
                if (mapper.supportedCodes().contains(code)) {
                    return mapper;
                }
          
        }

        return null;
    }
}

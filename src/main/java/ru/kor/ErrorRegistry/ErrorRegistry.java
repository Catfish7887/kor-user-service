package ru.kor.ErrorRegistry;

import java.util.List;

import ru.kor.ErrorMapper.InternalServerErrorMapper;
import ru.kor.ErrorMapper.RepositoryErrorMapper;
import ru.kor.ErrorMapper.ValidationErrorMapper;
import ru.kor.ErrorMapper.utils.ErrorMapper;
import ru.kor.Utils.Exceptions.AppException;
import ru.kor.Utils.Exceptions.ErrorCode;

public class ErrorRegistry {
    private static final List<ErrorMapper> mappers = List.of(
            new RepositoryErrorMapper(),
            new ValidationErrorMapper());

    

    public static ErrorMapper getMapper(Exception e) {
        if (e instanceof AppException) {
            ErrorCode code = ((AppException) e).getCode();
            for (ErrorMapper mapper : mappers) {
                if (mapper.supportedCodes().contains(code)) {
                    return mapper;
                }
            }
        }
        return new InternalServerErrorMapper();
    }
}
package ru.kor.ErrorMapper;

import java.util.Set;

import ru.kor.APIresponse.APIresponse;
import ru.kor.ErrorMapper.utils.ErrorMapper;
import ru.kor.Utils.Exceptions.AppException;
import ru.kor.Utils.Exceptions.ErrorCode;
import ru.kor.Utils.Exceptions.UserRepository.Utils.RepositoryErrorCodes;

public class ValidationErrorMapper implements ErrorMapper {
    @Override
    public Set<ErrorCode> supportedCodes (){
        return Set.of(RepositoryErrorCodes.values());
    }

    @Override
    public APIresponse mapError(AppException e) {
        ErrorCode code = e.getCode();

        if (code instanceof RepositoryErrorCodes) {
            return switch (code) {
                case RepositoryErrorCodes.USER_NOT_FOUND -> new APIresponse(e.getMessage(), 404);
                case RepositoryErrorCodes.DATABASE_ERROR -> new APIresponse(e.getMessage(), 500);
                case RepositoryErrorCodes.DUPLICATE_ID -> new APIresponse(e.getMessage(), 409);
                default -> new APIresponse("Произошла неизвестная ошибка", 500);
            };

        }
        return new APIresponse("При выполнении операции с хранилищем произошла ошибка", 510);
    }
}
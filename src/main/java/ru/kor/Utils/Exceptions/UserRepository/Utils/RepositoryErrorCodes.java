package ru.kor.Utils.Exceptions.UserRepository.Utils;

import ru.kor.Utils.Exceptions.ErrorCode;

public enum RepositoryErrorCodes implements ErrorCode{
    USER_NOT_FOUND, 
    DATABASE_ERROR,
    DUPLICATE_ID,
}

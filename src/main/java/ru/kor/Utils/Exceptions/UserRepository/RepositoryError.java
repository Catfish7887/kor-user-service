package ru.kor.Utils.Exceptions.UserRepository;

import ru.kor.Utils.Exceptions.AppException;
import ru.kor.Utils.Exceptions.UserRepository.Utils.RepositoryErrorCodes;

public class RepositoryError extends AppException {
    public RepositoryError (String msg, RepositoryErrorCodes code){
        super(msg, code);
    }
}

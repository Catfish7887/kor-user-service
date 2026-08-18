package ru.kor.Utils.Exceptions.Validation;

import ru.kor.Utils.Exceptions.AppException;
import ru.kor.Utils.Exceptions.Validation.Utils.ValidationErrorCodes;
public class ValidationException extends AppException{
    ValidationErrorCodes code;

    public ValidationException(String message, ValidationErrorCodes code) {
        super(message, code);
    }
}

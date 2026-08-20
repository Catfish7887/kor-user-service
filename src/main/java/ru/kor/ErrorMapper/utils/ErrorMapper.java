package ru.kor.ErrorMapper.utils;

import java.util.Set;

import ru.kor.APIresponse.APIresponse;
import ru.kor.Utils.Exceptions.AppException;
import ru.kor.Utils.Exceptions.ErrorCode;
public interface ErrorMapper  {
    Set<ErrorCode> supportedCodes();
    APIresponse mapError(AppException e);
    
}

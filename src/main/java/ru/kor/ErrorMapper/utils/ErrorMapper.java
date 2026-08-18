package ru.kor.ErrorMapper.utils;

import ru.kor.APIresponse.APIresponse;
import ru.kor.Utils.Exceptions.AppException;

public interface ErrorMapper  {
    APIresponse mapError(AppException e);
    
}

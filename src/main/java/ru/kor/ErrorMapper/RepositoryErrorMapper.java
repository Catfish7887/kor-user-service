package ru.kor.ErrorMapper;

import ru.kor.APIresponse.APIresponse;
import ru.kor.ErrorMapper.utils.ErrorMapper;
import ru.kor.Utils.Exceptions.AppException;

public class RepositoryErrorMapper implements ErrorMapper{
    @Override
    public APIresponse mapError(AppException e){
        return new APIresponse("", 0);
    }
    
}

package ru.kor.UserController;

import ru.kor.APIresponse.APIresponse;
import ru.kor.Utils.Exceptions.User.InvalidFieldsException;
import ru.kor.Utils.Exceptions.UserRepository.RepositoryError;
import ru.kor.Utils.Exceptions.UserRepository.Utils.RepositoryErrorCodes;
import ru.kor.RequestParser.RequestParser;
import ru.kor.ResponseSerializer.ResponseSerializer;
import ru.kor.User.User;
import ru.kor.UserRepository.UserRepository;
import ru.kor.UserService.UserService;
public class UserController {
    
    UserService service;
    
    public UserController(UserRepository repository) {
        this.service = new UserService(repository);
        
    }
    
    // TODO создать централизованный Enum-класс с ошибками, куда  
    private int setStatusCode(RepositoryErrorCodes errorCodes){
        int code;
        switch (errorCodes) {
            case USER_NOT_FOUND:
                code = 404;
                break;
                case DUPLICATE_ID:
                    code = 409;
                    break;
                    default:
                        code = 500;
                    }
        return code;
    }

    APIresponse handleGet(long id) {
        String body;
        int statusCode;
        try {
            User user = service.findById(id);
            body = ResponseSerializer.serializeUser(user);
            statusCode = 200;  
        } catch (RepositoryError e) {
            body = e.getMessage();
            statusCode = setStatusCode(e.getCode());
        }
        return new APIresponse(body, statusCode);
    }

    APIresponse handlePost(String data){
        String body;
        int statusCode;
    
        try {
            User user = RequestParser.parse(data);
            service.createUser(user);
            
        } catch (InvalidFieldsException e) {
            body = e.getMessage();
            statusCode = 400;
        } catch(RepositoryError e) {
            body = e.getMessage();
            statusCode = setStatusCode(errorCodes)

        }

    }
}
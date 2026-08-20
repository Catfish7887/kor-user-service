package ru.kor.UserController;

import ru.kor.APIresponse.APIresponse;
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

    APIresponse handleGet(long id) {
        String body;
        int statusCode;
        try {
            User user = service.findById(id);
            return new APIresponse(ResponseSerializer.serializeUser(user), 200);
        } catch (RepositoryError e) {
            
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
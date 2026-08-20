package ru.kor.UserController;

import ru.kor.APIresponse.APIresponse;
import ru.kor.ErrorMapper.GlobalErrorMapper;
import ru.kor.ErrorMapper.utils.ErrorMapper;
import ru.kor.ErrorRegistry.ErrorRegistry;
import ru.kor.RequestParser.RequestParser;
import ru.kor.ResponseSerializer.ResponseSerializer;
import ru.kor.User.User;
import ru.kor.UserRepository.UserRepository;
import ru.kor.UserService.UserService;
import ru.kor.Utils.Exceptions.AppException;

public class UserController {

    UserService service;

    public UserController(UserRepository repository) {
        this.service = new UserService(repository);

    }

    APIresponse handleGet(long id) {
        try {
            User user = service.findById(id);
            return new APIresponse(ResponseSerializer.serializeUser(user), 200);
        } catch (AppException e) {
            ErrorMapper mapper = ErrorRegistry.getMapper(e);
            return mapper.mapError(e);
        } catch (RuntimeException e) {
            return GlobalErrorMapper.mapError(e);
        }
    }

    APIresponse handlePost(String data) {
        try {
            User user = RequestParser.parse(data);
            service.createUser(user);
            return new APIresponse(ResponseSerializer.serializeUser(user), 200);
        } catch (AppException e) {
            ErrorMapper mapper = ErrorRegistry.getMapper(e);
            return mapper.mapError(e);
        } catch (RuntimeException e) {
            return GlobalErrorMapper.mapError(e);
        }
    }

    APIresponse handleDelete(long id) {
        try {
            service.deleteUser(id);
            return new APIresponse("Deleted", 200);
        } catch (AppException e) {
            ErrorMapper mapper = ErrorRegistry.getMapper(e);
            return mapper.mapError(e);
        } catch (RuntimeException e) {
            return GlobalErrorMapper.mapError(e);
        }
    }
}
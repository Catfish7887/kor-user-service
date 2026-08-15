package ru.kor.Exceptions.UserRepository;

public class RepositoryError extends Exception {
    public RepositoryError(){
        super();
    }

    public RepositoryError (String msg){
        super(msg);

    }
}

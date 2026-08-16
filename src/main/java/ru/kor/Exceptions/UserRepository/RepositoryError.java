package ru.kor.Exceptions.UserRepository;

public class RepositoryError extends Exception {
    private RepositoryErrorCodes code;
    public RepositoryError(){
        super();
    }

    public RepositoryError (String msg){
        super(msg);

    }

    public RepositoryError (String msg, RepositoryErrorCodes code){
        super(msg);
        this.code = code;
    }

    public RepositoryErrorCodes getCode(){
        return this.code;

    }
}

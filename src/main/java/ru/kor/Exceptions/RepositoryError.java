package ru.kor.Exceptions;

public class RepositoryError extends Exception {
    public RepositoryError(){
        super();
    }

    public RepositoryError (String msg){
        super(msg);

    }
}

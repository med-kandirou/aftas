package com.mkandirou.aftas.Exception;

public class RecordAlreadyExistsException extends RuntimeException{
    private RecordAlreadyExistsException(String message){
        super(message);
    }
}

package com.flight.inventory.Exception;



//Custom Exception
public class ValidationException extends RuntimeException{

    public ValidationException(String message)
    {
        super(message);
    }
}

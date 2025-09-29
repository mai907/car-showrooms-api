package com.car.showrooms.exception;

public class CMRAlreadyExistsException extends RuntimeException {

    public CMRAlreadyExistsException() {
        super("Commercial Registration Number Already Exists");
    }

}

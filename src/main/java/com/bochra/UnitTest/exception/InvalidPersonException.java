package com.bochra.UnitTest.exception;

public class InvalidPersonException  extends  RuntimeException{
    public InvalidPersonException(String message) {
        super(message);
    }
}

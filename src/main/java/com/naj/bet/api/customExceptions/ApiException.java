package com.naj.bet.api.customExceptions;

import javax.annotation.Generated;

@Generated(value = "General Exception")
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}

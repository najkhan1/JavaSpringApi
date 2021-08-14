package com.naj.bet.api.customExceptions;


import javax.annotation.Generated;

@Generated("Id not found")
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}

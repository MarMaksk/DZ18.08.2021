package com.DZ3.Exception;

public class NicknameBusyException extends Exception {
    public NicknameBusyException() {
    }

    public NicknameBusyException(String message) {
        super(message);
    }

    public NicknameBusyException(String message, Throwable cause) {
        super(message, cause);
    }
}
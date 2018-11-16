package com.timur.pet_project.exceptions;

public class DaoCloseConnectionException extends RuntimeException {

    private static final long serialVersionUID = 5213445540555840583L;

    public DaoCloseConnectionException() {
        super();
    }

    public DaoCloseConnectionException(String s) {
        super(s);
    }

}

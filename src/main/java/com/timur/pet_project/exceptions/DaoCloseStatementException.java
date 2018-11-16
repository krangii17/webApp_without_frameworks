package com.timur.pet_project.exceptions;

public class DaoCloseStatementException extends RuntimeException {
    private static final long serialVersionUID = -2784168633154043383L;

    public DaoCloseStatementException() {
        super();
    }

    public DaoCloseStatementException(String s) {
        super(s);
    }
}

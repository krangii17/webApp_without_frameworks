package com.timur.pet_project.validator;

/**
 * Created by timyr on 16.08.18.
 */
public enum ValidatorEnum {

    EMAIL_VALIDATOR("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"),
    LOGIN_VALIDATOR("^[\\w0-9]{3,20}$"),
    NAME_VALIDATOR("[\\w]{3,25}$"),
    PASSWORD_VALIDATOR("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"),
    TOPIC_VALIDATOR("^[\\s\\w0-9]{3,}$");

    private final String statment;

    ValidatorEnum(String statment) {
        this.statment = statment;
    }

    public String getStatment() {
        return statment;
    }
}

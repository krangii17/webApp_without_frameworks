package com.timur.pet_project.validator;

import java.util.regex.Pattern;

/**
 * Created by timyr on 22.08.18.
 */
public class TestCreateValidator {

    public boolean testNameValidate(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(ValidatorEnum
                    .NAME_VALIDATOR
                    .getStatment());
            return pattern.matcher(name).matches();
        }
    }

    public boolean topicValidate(String topic) {
        if (topic == null || topic.isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(ValidatorEnum
                    .TOPIC_VALIDATOR
                    .getStatment());
            return pattern.matcher(topic).matches();
        }
    }

    public boolean levelValidator(int level) {
        if (level <= 0 || level >= 6) {
            return false;
        } else {
            return true;
        }
    }

    public boolean timeValidate(int time) {
        if (time <= 0 || time >= 100) {
            return false;
        } else {
            return true;
        }
    }

}

package com.timur.pet_project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by timyr on 12.08.18.
 */
public class Result implements Serializable {

    private static final long serialVersionUID = -8554490956542147218L;
    private int resultID;
    private int userID;
    private int testID;
    private boolean passed;
    private int points;
    private Test test;

    public Result(int userID, int testID, boolean passed, int points) {
        this.userID = userID;
        this.testID = testID;
        this.passed = passed;
        this.points = points;
    }

    public Result(int resultID, int userID, int testID, boolean passed, int points) {
        this.resultID = resultID;
        this.userID = userID;
        this.testID = testID;
        this.passed = passed;
        this.points = points;
    }

    public Result() {
    }


    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Result {" +
                "result id='" + resultID + '\'' +
                ", user id='" + userID + '\'' +
                ", test id='" + testID + '\'' +
                ", passed='" + passed + '\'' +
                ", points='" + points + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return getResultID() == result.getResultID() &&
                getUserID() == result.getUserID() &&
                getTestID() == result.getTestID() &&
                isPassed() == result.isPassed() &&
                getPoints() == result.getPoints() &&
                Objects.equals(getTest(), result.getTest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResultID(), getUserID(), getTestID(), isPassed(), getPoints(), getTest());
    }
}

package com.timur.pet_project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by timyr on 12.08.18.
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 1640924065683917150L;
    private int testID;
    private String testName;
    private int level;
    private String topic;
    private int testTime;

    public Test(int testID, String testName, int level, String topic, int testTime) {
        this.testID = testID;
        this.testName = testName;
        this.level = level;
        this.topic = topic;
        this.testTime = testTime;
    }

    public Test() {
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTestTime() {
        return testTime;
    }

    public void setTestTime(int testTime) {
        this.testTime = testTime;
    }

    @Override
    public String toString() {
        return "Test module {" +
                "test id='" + testID + '\'' +
                ", test name='" + testName + '\'' +
                ", level='" + level + '\'' +
                ", topic='" + topic + '\'' +
                ", test time='" + testTime + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return getTestID() == test.getTestID() &&
                getLevel() == test.getLevel() &&
                getTestTime() == test.getTestTime() &&
                Objects.equals(getTestName(), test.getTestName()) &&
                Objects.equals(getTopic(), test.getTopic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestID(), getTestName(), getLevel(), getTopic(), getTestTime());
    }
}

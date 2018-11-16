package com.timur.pet_project.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by timyr on 12.08.18.
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 5833191101731597206L;
    private int questionID;
    private String question;
    private int testID;
    private List<Answer> answerList;

    public Question(String question, int testID) {
        this.question = question;
        this.testID = testID;
    }

    public Question(int questionID, String question, int testID) {
        this.questionID = questionID;
        this.question = question;
        this.testID = testID;
    }

    public Question() {
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    @Override
    public String toString() {
        return "Question {" +
                "question id='" + questionID + '\'' +
                ", question='" + question + '\'' +
                ", test ID='" + testID + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return getQuestionID() == question1.getQuestionID() &&
                getTestID() == question1.getTestID() &&
                Objects.equals(getQuestion(), question1.getQuestion()) &&
                Objects.equals(getAnswerList(), question1.getAnswerList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionID(), getQuestion(), getTestID(), getAnswerList());
    }
}

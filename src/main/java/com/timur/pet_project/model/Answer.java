package com.timur.pet_project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by timyr on 12.08.18.
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 2621362995178031216L;
    private int answerID;
    private String answer;
    private boolean correct;
    private int questionID;

    public Answer(String answer, boolean correct, int questionID) {
        this.answer = answer;
        this.correct = correct;
        this.questionID = questionID;
    }

    public Answer(int answerID, String answer, boolean correct, int questionID) {
        this.answerID = answerID;
        this.answer = answer;
        this.correct = correct;
        this.questionID = questionID;
    }

    public Answer() {
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "Answer {" +
                "answer id='" + answerID + '\'' +
                ", answer='" + answer + '\'' +
                ", correct='" + correct + '\'' +
                ", question id='" + questionID + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer1 = (Answer) o;
        return getAnswerID() == answer1.getAnswerID() &&
                isCorrect() == answer1.isCorrect() &&
                getQuestionID() == answer1.getQuestionID() &&
                Objects.equals(getAnswer(), answer1.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerID(), getAnswer(), isCorrect(), getQuestionID());
    }
}

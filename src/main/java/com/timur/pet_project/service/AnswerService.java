package com.timur.pet_project.service;

import com.timur.pet_project.dao.AnswerDao;
import com.timur.pet_project.model.Answer;

import java.util.List;

/**
 * Created by timyr on 26.08.18.
 */
public class AnswerService {

    public Answer createAnswer(String answer, boolean correct, int questionID) {
        AnswerDao dao = new AnswerDao();
        Answer myAnswer = new Answer(answer, correct, questionID);
        dao.create(myAnswer);
        return myAnswer;

    }

    public List<Answer> getAnswersByQuestionID(int questionID) {
        AnswerDao dao = new AnswerDao();
        List<Answer> answers = dao.getAnswersByQuestionsID(questionID);
        return answers;

    }
}

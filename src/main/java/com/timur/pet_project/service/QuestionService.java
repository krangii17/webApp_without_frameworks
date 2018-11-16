package com.timur.pet_project.service;

import com.timur.pet_project.dao.AnswerDao;
import com.timur.pet_project.dao.QuestionsDao;
import com.timur.pet_project.model.Answer;
import com.timur.pet_project.model.Question;

import java.util.List;

/**
 * Created by timyr on 26.08.18.
 */
public class QuestionService {
    public Question createQuestion(String question, int testID) {
        QuestionsDao questionsDao = new QuestionsDao();
        Question myQuestion = new Question(question, testID);
        questionsDao.create(myQuestion);
        return myQuestion;
    }

    public List<Question> getAllQuestions() {
        QuestionsDao questionsDao = new QuestionsDao();
        return questionsDao.getList();
    }

    public List<Question> getQuestionsByTestID(int id) {
        QuestionsDao questionsDao = new QuestionsDao();
        List<Question> questions = questionsDao.getQuestionsByTestId(id);
        return questions;
    }

    public Question updateQuestion(int questionID, String question, int testID) {
        QuestionsDao dao = new QuestionsDao();
        Question quest = new Question(questionID, question, testID);
        return dao.update(quest);

    }

    public void deleteQuestion(int questionID) {
        QuestionsDao dao = new QuestionsDao();
        dao.delete(questionID);
    }

    public void addAnswersToQuestion(Question question) {
        AnswerDao dao = new AnswerDao();
        List<Answer> answers = dao.getAnswersByQuestionsID(question
                .getQuestionID());
        if (answers.isEmpty()) {
            return;
        } else {
            question.setAnswerList(answers);
        }
    }
}

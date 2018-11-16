package com.timur.pet_project.service;

import com.timur.pet_project.dao.QuestionsDao;
import com.timur.pet_project.dao.ResultDao;
import com.timur.pet_project.dao.TestDao;
import com.timur.pet_project.model.Result;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by timyr on 19.08.18.
 */
public class TestResultService {

    public Result getTestResult(int resultID) {
        ResultDao resultDao = new ResultDao();
        return resultDao.getById(resultID);
    }

    public ArrayList<Result> getSetOfResultsByUserId(int userID) {
        ResultDao resultDao = new ResultDao();
        TestDao testDao = new TestDao();
        ArrayList<Result> results = resultDao.getResultsByUserId(userID);
        for (Result result : results) {
            if (testDao.getById(result.getTestID()) != null) {
                result.setTest(testDao.getById(result.getTestID()));
            }
        }
        return results;
    }

    public void sortTestResults(ArrayList<Result> results, String sortType) {
        switch (sortType) {
            case "name":
                results.sort(Comparator.comparing(n -> n.getTest().getTestName()));
                break;
            case "topic":
                results.sort(Comparator.comparing(n -> n.getTest().getTopic()));
                break;
            case "questions":
                results.sort(Comparator.comparing(n -> getSizeOfQuestions(n.getTestID())));
                break;
            case "hard":
                results.sort(Comparator.comparing(n -> n.getTest().getLevel()));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private Integer getSizeOfQuestions(int testID) {
        QuestionsDao question = new QuestionsDao();
        return question.getQuestionsByTestId(testID).size();
    }
}

package com.timur.pet_project.service;

import com.timur.pet_project.dao.ResultDao;
import com.timur.pet_project.model.Result;

import java.util.List;

public class ResultService {

    public List<Result> getResults() {
        ResultDao dao = new ResultDao();
        return dao.getList();
    }

    public double getPercentage(int answerSize, int correctAnswerSize, int correctVal) {
        double percentage = 0;
        if (answerSize >= correctAnswerSize) {
            percentage = Math.round(Double.valueOf(correctVal) / Double.valueOf(answerSize) * 100);
        } else {
            percentage = Math.round(Double.valueOf(correctVal) / Double.valueOf(correctAnswerSize) * 100);
        }
        return percentage;
    }

    public void setResult(int userID, int testID, double percentage, int points) {
        ResultDao dao = new ResultDao();
        Result result = new Result(userID, testID, getPassed(percentage), points);
        dao.create(result);

    }

    private boolean getPassed(double persentage) {
        return persentage > 50;
    }
}

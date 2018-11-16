package com.timur.pet_project.service;

import com.timur.pet_project.dao.QuestionsDao;
import com.timur.pet_project.dao.TestDao;
import com.timur.pet_project.model.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by timyr on 20.08.18.
 */
public class TestService {

    public List<Test> getAllTests() {
        TestDao testDao = new TestDao();
        return testDao.getList();

    }

    public void createTest(String name, int level, String topic, int time) {
        TestDao testDao = new TestDao();
        Test test = new Test();
        test.setTestName(name);
        test.setLevel(level);
        test.setTopic(topic);
        test.setTestTime(time);
        testDao.create(test);
    }

    public Test getTestById(int id) {
        TestDao dao = new TestDao();
        Test getTest = dao.getById(id);
        return getTest;
    }

    public void updateTest(Integer id, String name, int level, String topic, int time) {
        TestDao dao = new TestDao();
        Test test = new Test(id, name, level, topic, time);
        dao.update(test);

    }

    public void deleteTest(int id) {
        TestDao dao = new TestDao();
        dao.delete(id);
    }

    public void sortTestResults(List<Test> tests, String sortType) {
        switch (sortType) {
            case "name":
                tests.sort(Comparator.comparing(Test::getTestName));
                break;
            case "topic":
                tests.sort(Comparator.comparing(Test::getTopic));
                break;
            case "questions":
                tests.sort(Comparator.comparing(n -> getSizeOfQuestions(n.getTestID())));
                break;
            case "hard":
                tests.sort(Comparator.comparing(Test::getLevel));
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

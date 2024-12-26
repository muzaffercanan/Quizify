package controller;

import model.QuizManager;
import model.Question;
import util.*;
import java.util.List;

public class QuizController {
    private QuizManager quizManager;
    private DifficultyStrategy strategy;

    public QuizController(String category, String difficulty) {
        quizManager = QuizManager.getInstance();
        quizManager.loadQuestions(category, difficulty);

        switch (difficulty) {
            case "Easy":
                strategy = new EasyStrategy();
                break;
            case "Medium":
                strategy = new MediumStrategy();
                break;
            case "Hard":
                strategy = new HardStrategy();
                break;
        }
    }

    public void submitAnswer(String answer, String correctAnswer) {
        int points = answer.equals(correctAnswer) ? 10 : 0;
        quizManager.updateScore(strategy.calculateScore(points));
    }

    // Buraya getQuestions metodunu ekliyoruz
    public List<Question> getQuestions() {
        return quizManager.getQuestions();
    }
}

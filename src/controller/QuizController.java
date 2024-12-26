package controller;

import model.QuizManager;
import model.Question;
import util.*;
import java.util.List;

public class QuizController {
    private QuizManager quizManager;
    private DifficultyStrategy strategy;
    private int currentQuestionIndex;

    public QuizController(String category, String difficulty) {
        quizManager = QuizManager.getInstance();
        quizManager.loadQuestions(category, difficulty);
        currentQuestionIndex = 0;

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
        currentQuestionIndex++;
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < quizManager.getQuestions().size()) {
            return quizManager.getQuestions().get(currentQuestionIndex);
        }
        return null; // Sorular bittiğinde null döndür.
    }

    public int getQuizScore() {
        return quizManager.getScore();
    }
}

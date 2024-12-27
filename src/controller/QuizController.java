package controller;

import util.*;
import model.*;

import java.util.List;

public class QuizController {
    private QuizManager quizManager;
    private List<Question> filteredQuestions;
    private int currentQuestionIndex;

    public QuizController(String category, String difficulty) {
        quizManager = QuizManager.getInstance();
        quizManager.loadQuestions(category, difficulty);
        filteredQuestions = quizManager.getQuestions();
        currentQuestionIndex = 0;

        // HintManager'ın ipucu kullanımını sıfırlaması
        HintManager.getInstance().resetHint();
    }

    public QuizManager getQuizManager() {
        return quizManager;
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < filteredQuestions.size()) {
            return filteredQuestions.get(currentQuestionIndex++);
        }
        return null;
    }

    public Question getNextQuestionWithHint(String hint) {
        HintManager hintManager = HintManager.getInstance();

        if (hintManager.isHintUsed()) {
            throw new IllegalStateException("Hint can only be used once per game.");
        }

        if (currentQuestionIndex > 0) {
            Question current = filteredQuestions.get(currentQuestionIndex - 1);
            hintManager.useHint(); // Hint kullanıldığını işaretle
            return new HintDecorator(current, hint);
        }
        return null;
    }

    public int getQuizScore() {
        return quizManager.getScore();
    }

    public void submitAnswer(String answer, Question question) {
        DifficultyStrategy strategy;
        switch (question.getDifficulty().toLowerCase()) {
            case "easy":
                strategy = new EasyStrategy();
                break;
            case "medium":
                strategy = new MediumStrategy();
                break;
            case "hard":
                strategy = new HardStrategy();
                break;
            default:
                throw new IllegalStateException("Unexpected difficulty: " + question.getDifficulty());
        }

        int baseScore = answer.equals(question.getCorrectAnswer()) ? 10 : 0;
        if (HintManager.getInstance().isHintUsed()) {
            baseScore /= 2; // Hint kullanıldıysa puanı yarıya düşür
        }

        quizManager.updateScore(strategy.calculateScore(baseScore));
    }

    public Question useHint(String hint) {
    HintManager hintManager = HintManager.getInstance();
    if (hintManager.isHintUsed()) {
        throw new IllegalStateException("Hint can only be used once per game.");
    }
    if (currentQuestionIndex > 0) {
        Question current = filteredQuestions.get(currentQuestionIndex - 1);
        hintManager.useHint();
        return new HintDecorator(current, hint); // HintDecorator döndürülür
    }
    throw new IllegalStateException("No question available to provide a hint.");
}
    
}
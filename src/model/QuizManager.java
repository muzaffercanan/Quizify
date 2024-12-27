package model;

import java.util.List;

public class QuizManager {
    private static QuizManager instance;
    private List<Question> currentQuestions;
    private int currentScore;

    private QuizManager() {
        currentScore = 0;
    }

    public static QuizManager getInstance() {
        if (instance == null) {
            instance = new QuizManager();
        }
        return instance;
    }

    public void loadQuestions(String category, String difficulty) {
        currentQuestions = QuestionFactory.generateQuestions(category, difficulty);
    }

    public List<Question> getQuestions() {
        return currentQuestions;
    }

    public int getScore() {
        return currentScore;
    }

    public void updateScore(int points) {
        currentScore += points;
    }
}

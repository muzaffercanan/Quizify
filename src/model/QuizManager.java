package model;

import java.util.List;

public class QuizManager {
    private static QuizManager instance;
    private List<Question> currentQuestions;
    private int currentScore;
    private int currentQuestionIndex;

    private QuizManager() {
        currentScore = 0;
        currentQuestionIndex = 0;
    }

    public static QuizManager getInstance() {
        if (instance == null) {
            instance = new QuizManager();
        }
        return instance;
    }

    public void loadQuestions(String category, String difficulty) {
        QuestionFactory factory = QuestionFactoryProvider.getFactory(category);
        currentQuestions = factory.generateQuestions(difficulty);
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            return currentQuestions.get(currentQuestionIndex++);
        }
        return null;
    }

    public Question getNextQuestionWithHint(String hint) {
        Question question = getNextQuestion();
        if (question != null) {
            return new HintDecorator(question, hint);
        }
        return null;
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

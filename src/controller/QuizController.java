package controller;

import model.Question;
import model.QuizManager;

import java.util.List;
import java.util.stream.Collectors;

public class QuizController {
    private QuizManager quizManager;
    private List<Question> filteredQuestions;
    private int currentQuestionIndex;

    public QuizController(String category, String difficulty) {
        quizManager = QuizManager.getInstance();
        // İki parametreli çağrı
        quizManager.loadQuestions(category, difficulty);

        // Soruları doğrudan al, filtreleme gerekmez
        filteredQuestions = quizManager.getQuestions();

        currentQuestionIndex = 0;
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < filteredQuestions.size()) {
            return filteredQuestions.get(currentQuestionIndex++);
        }
        return null; // Sorular bittiğinde null döndür
    }

    public int getQuizScore() {
        return quizManager.getScore();
    }

    public void submitAnswer(String answer, String correctAnswer) {
        if (answer.equals(correctAnswer)) {
            quizManager.updateScore(10); // Sabit bir puan eklenebilir ya da stratejiye göre değiştirilebilir
        }
    }
}

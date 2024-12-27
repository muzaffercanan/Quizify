package model;

import util.QuizObserver;
import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private static QuizManager instance;
    private List<Question> currentQuestions;
    private int currentScore;
    private int currentQuestionIndex;

    // Observer listesi
    private List<QuizObserver> observers;

    private QuizManager() {
        currentScore = 0;
        currentQuestionIndex = 0;
        observers = new ArrayList<>();
    }

    public static QuizManager getInstance() {
        if (instance == null) {
            instance = new QuizManager();
        }
        return instance;
    }

    // Observer ekleme
    public void addObserver(QuizObserver observer) {
        observers.add(observer);
    }

    // Observer kaldırma
    public void removeObserver(QuizObserver observer) {
        observers.remove(observer);
    }

    // Tüm Observer'ları bilgilendirme
    private void notifyObservers() {
        for (QuizObserver observer : observers) {
            observer.update(currentScore);
        }
    }

    public void loadQuestions(String category, String difficulty) {
        QuestionFactory factory = QuestionFactoryProvider.getFactory(category);
        currentQuestions = factory.generateQuestions(difficulty);
    }

    public List<Question> getQuestions() {
        return currentQuestions;
    }

    public int getScore() {
        return currentScore;
    }

    public void updateScore(int points) {
        currentScore += points;
        notifyObservers(); // Skor güncellendiğinde observer'lara bildir
    }
}
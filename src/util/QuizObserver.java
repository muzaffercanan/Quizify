package util;

public interface QuizObserver {
    void update(int newScore);
    void update(String feedback);
}
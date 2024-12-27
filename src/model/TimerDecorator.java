package model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TimerDecorator extends QuestionDecorator {
    private int timeLimit; // Zaman limiti (saniye cinsinden)
    private Timeline timer;

    public TimerDecorator(Question decoratedQuestion, int timeLimit) {
        super(decoratedQuestion);
        this.timeLimit = timeLimit;
    }

    public void startTimer(Label timerLabel, Runnable onTimeUp) {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLimit--;
            timerLabel.setText("Time Remaining: " + timeLimit + " seconds");

            if (timeLimit <= 0) {
                timer.stop();
                timerLabel.setText("Time's up!");
                onTimeUp.run(); // Süre dolduğunda çalıştırılacak işlev
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }
}
package view;

import controller.QuizController;
import model.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class QuizView extends Application {
    private QuizController controller;
    private VBox questionLayout;
    private Label questionLabel;
    private ToggleGroup optionsGroup;
    private Button submitButton;
    private Label feedbackLabel;
    private Label scoreLabel;
    private TimerDecorator timerDecorator; // TimerDecorator sınıf düzeyinde tanımlandı

    private Question currentQuestion;
    private String selectedCategory;
    private String selectedDifficulty;
    private String userName;

    public QuizView(String category, String difficulty, String userName) {
        this.selectedCategory = category;
        this.selectedDifficulty = difficulty;
        this.userName = userName;
    }

    @Override
    public void start(Stage primaryStage) {
        controller = new QuizController(selectedCategory, selectedDifficulty);

        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setStyle("-fx-padding: 10; -fx-background-color: linear-gradient(to bottom, #f0f8ff, #87cefa);");

        Label userInfoLabel = new Label("Player: " + userName + " | Category: " + selectedCategory + " | Difficulty: " + selectedDifficulty);
        userInfoLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        scoreLabel = new Label("Current Score: 0");
        scoreLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #34495e;");

        questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        optionsGroup = new ToggleGroup();

        submitButton = new Button("Submit");
        submitButton.setStyle(
                "-fx-font-size: 16px; -fx-background-color: #28a745; " +
                        "-fx-text-fill: white; -fx-padding: 10 20; " +
                        "-fx-border-radius: 10; -fx-background-radius: 10;"
        );
        submitButton.setOnAction(e -> handleSubmission());

        feedbackLabel = new Label();
        feedbackLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #555;");

        questionLayout = new VBox(20);
        questionLayout.setAlignment(Pos.CENTER);

        mainLayout.getChildren().addAll(userInfoLabel, scoreLabel, questionLayout, feedbackLabel, submitButton);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz - Welcome " + userName);
        primaryStage.show();

        loadNextQuestion();
    }

    private void loadNextQuestion() {
        HintManager.getInstance().resetHint();

        if (timerDecorator != null) {
            timerDecorator.stopTimer(); // Mevcut zamanlayıcıyı durdur
        }

        questionLayout.getChildren().clear();
        feedbackLabel.setText("");

        currentQuestion = controller.getNextQuestion();

        if (currentQuestion != null) {
            Label timerLabel = new Label("Time Remaining: 10 seconds");
            timerLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");

            timerDecorator = new TimerDecorator(currentQuestion, 10);
            timerDecorator.startTimer(timerLabel, () -> {
                feedbackLabel.setText("Time's up! Moving to next question...");
                feedbackLabel.setStyle("-fx-text-fill: red;");
                loadNextQuestion();
            });

            questionLabel.setText(currentQuestion.getQuestionText());
            questionLayout.getChildren().add(questionLabel);

            Button hintButton = new Button("Show Hint");
            hintButton.setStyle(
                    "-fx-font-size: 14px; -fx-background-color: #3498db; " +
                            "-fx-text-fill: white; -fx-padding: 5 10; " +
                            "-fx-border-radius: 5; -fx-background-radius: 5;"
            );

            hintButton.setOnAction(e -> {
                try {
                    HintManager hintManager = HintManager.getInstance();
                    if (!hintManager.isHintUsed()) {
                        currentQuestion = controller.getNextQuestionWithHint("Think about the basics!");
                        feedbackLabel.setText("Hint: " + ((HintDecorator) currentQuestion).getHint());
                        feedbackLabel.setStyle("-fx-text-fill: blue;");
                        hintManager.useHint();
                    } else {
                        currentQuestion = controller.getNextQuestionWithHint("!");
                        feedbackLabel.setText("Hint already used!");
                        feedbackLabel.setStyle("-fx-text-fill: red;");
                    }
                    hintButton.setDisable(true); // Hint butonunu devre dışı bırak
                    hintButton.setText("Hint already used!"); // Buton mesajını güncelle
                } catch (IllegalStateException ex) {
                    feedbackLabel.setText(ex.getMessage());
                    feedbackLabel.setStyle("-fx-text-fill: red;");
                }
            });

            questionLayout.getChildren().add(hintButton);

            for (String option : currentQuestion.getOptions()) {
                RadioButton rb = new RadioButton(option);
                rb.setToggleGroup(optionsGroup);
                rb.setStyle("-fx-font-size: 16px; -fx-text-fill: #34495e;");
                questionLayout.getChildren().add(rb);
            }

            questionLayout.getChildren().addAll(timerLabel, feedbackLabel);
        } else {
            FinishView finishView = new FinishView(userName, selectedCategory, selectedDifficulty, controller.getQuizScore());
            try {
                finishView.start((Stage) questionLayout.getScene().getWindow());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void handleSubmission() {
        if (timerDecorator != null) {
            timerDecorator.stopTimer();
        }

        RadioButton selected = (RadioButton) optionsGroup.getSelectedToggle();
        if (selected == null) {
            feedbackLabel.setText("Please select an option!");
            return;
        }

        String selectedAnswer = selected.getText();
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            feedbackLabel.setText("Correct!");
            feedbackLabel.setStyle("-fx-text-fill: green;");
        } else {
            feedbackLabel.setText("Incorrect! Correct answer: " + currentQuestion.getCorrectAnswer());
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }

        controller.submitAnswer(selectedAnswer, currentQuestion);
        scoreLabel.setText("Current Score: " + controller.getQuizManager().getScore());
        loadNextQuestion();
    }

    
}
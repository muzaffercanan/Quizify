package view;

import controller.QuizController;
import model.Question;
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
    private Question currentQuestion;
    private String selectedCategory;
    private String selectedDifficulty;

    // Yeni Constructor (Kategori ve Zorluk ile birlikte)
    public QuizView(String category, String difficulty) {
        this.selectedCategory = category;
        this.selectedDifficulty = difficulty;
    }

    @Override
    public void start(Stage primaryStage) {
        controller = new QuizController(selectedCategory, selectedDifficulty);

        HBox mainLayout = new HBox();
        mainLayout.setStyle("-fx-background-color: #f4f4f4;");

        VBox imageColumn = new VBox();
        imageColumn.setStyle(
                "-fx-background-image: url('/resources/quizPhoto2.jpg'); " +
                        "-fx-background-size: 100% 100%; " +
                        "-fx-background-position: center; " +
                        "-fx-background-repeat: no-repeat;");
        imageColumn.setPrefWidth(400);
        HBox.setHgrow(imageColumn, Priority.NEVER);

        questionLayout = new VBox(20);
        questionLayout.setAlignment(Pos.CENTER);
        questionLayout.setStyle("-fx-padding: 20; -fx-background-color: #ffffff;");

        questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #333;");

        optionsGroup = new ToggleGroup();

        submitButton = new Button("Submit");
        submitButton.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;");

        submitButton.setOnAction(e -> handleSubmission());

        feedbackLabel = new Label();
        feedbackLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #555;");

        questionLayout.getChildren().addAll(questionLabel, submitButton, feedbackLabel);

        loadNextQuestion();

        HBox.setHgrow(questionLayout, Priority.ALWAYS);
        mainLayout.getChildren().addAll(imageColumn, questionLayout);

        Scene scene = new Scene(mainLayout, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz Application");
        primaryStage.show();
    }

    private void loadNextQuestion() {
        questionLayout.getChildren().removeIf(node -> node instanceof RadioButton);
        feedbackLabel.setText("");

        String hint = "Think about the basics!"; // Örnek ipucu
        currentQuestion = controller.getNextQuestionWithHint(hint);

        if (currentQuestion != null) {
            questionLabel.setText(currentQuestion.getQuestionText());

            for (String option : currentQuestion.getOptions()) {
                RadioButton rb = new RadioButton(option);
                rb.setToggleGroup(optionsGroup);
                rb.setStyle("-fx-font-size: 14px; -fx-text-fill: #333;");
                questionLayout.getChildren().add(questionLayout.getChildren().size() - 2, rb);
            }
        } else {
            questionLabel.setText("Quiz Complete! Your score: " + controller.getQuizScore());
            submitButton.setDisable(true);
        }
    }

    private void handleSubmission() {
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
        }

        controller.submitAnswer(selectedAnswer, currentQuestion.getCorrectAnswer());
        loadNextQuestion();
    }
}

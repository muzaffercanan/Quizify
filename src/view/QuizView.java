package view;

import controller.QuizController;
import model.Question;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class QuizView extends Application {
    private QuizController controller;
    private VBox layout;
    private Label questionLabel;
    private ToggleGroup optionsGroup;
    private Button submitButton;
    private Label feedbackLabel;
    private Question currentQuestion;

    @Override
    public void start(Stage primaryStage) {
        controller = new QuizController("Science", "Easy");
        layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        questionLabel = new Label();
        optionsGroup = new ToggleGroup();
        submitButton = new Button("Submit");
        feedbackLabel = new Label();

        submitButton.setOnAction(e -> handleSubmission());

        layout.getChildren().addAll(questionLabel, submitButton, feedbackLabel);

        loadNextQuestion();

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz Application");
        primaryStage.show();
    }

    private void loadNextQuestion() {
        layout.getChildren().removeIf(node -> node instanceof RadioButton);
        feedbackLabel.setText("");

        currentQuestion = controller.getNextQuestion();
        if (currentQuestion != null) {
            questionLabel.setText(currentQuestion.getQuestionText());

            for (String option : currentQuestion.getOptions()) {
                RadioButton rb = new RadioButton(option);
                rb.setToggleGroup(optionsGroup);
                layout.getChildren().add(rb);
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
        } else {
            feedbackLabel.setText("Incorrect! Correct answer: " + currentQuestion.getCorrectAnswer());
        }

        controller.submitAnswer(selectedAnswer, currentQuestion.getCorrectAnswer());

        // Bir sonraki soruyu yükle
        loadNextQuestion();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

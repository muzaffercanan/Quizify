
package view;

import controller.QuizController;
import model.Question;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuizView extends Application {
    private QuizController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new QuizController("Science", "Easy");
        VBox layout = new VBox(10);

        for (Question question : controller.getQuestions()) {
            Label questionLabel = new Label(question.getQuestionText());
            ToggleGroup optionsGroup = new ToggleGroup();
            for (String option : question.getOptions()) {
                RadioButton rb = new RadioButton(option);
                rb.setToggleGroup(optionsGroup);
                layout.getChildren().add(rb);
            }

            Button submitButton = new Button("Submit");
            submitButton.setOnAction(e -> {
                RadioButton selected = (RadioButton) optionsGroup.getSelectedToggle();
                controller.submitAnswer(selected.getText(), question.getCorrectAnswer());
            });

            layout.getChildren().addAll(questionLabel, submitButton);
        }

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz Application");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}

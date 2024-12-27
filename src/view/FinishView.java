package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinishView extends Application {
    private String userName;
    private String selectedCategory;
    private String selectedDifficulty;
    private int finalScore;

    public FinishView(String userName, String category, String difficulty, int score) {
        this.userName = userName;
        this.selectedCategory = category;
        this.selectedDifficulty = difficulty;
        this.finalScore = score;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox(20); // Daha geniş aralıklar
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 50; -fx-background-color: linear-gradient(to bottom, #ffffff, #87cefa);");

        Label titleLabel = new Label("Quiz Completed!");
        titleLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        Label userLabel = new Label("Player: " + userName);
        userLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #34495e;");

        Label categoryLabel = new Label("Category: " + selectedCategory);
        categoryLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #34495e;");

        Label difficultyLabel = new Label("Difficulty: " + selectedDifficulty);
        difficultyLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #34495e;");

        Label scoreLabel = new Label("Your Final Score: " + finalScore);
        scoreLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #4CAF50;");

        // Restart Button
        Button restartButton = new Button("Restart Quiz");
        restartButton.setStyle(
                "-fx-font-size: 18px; -fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; -fx-padding: 10px 30px; " +
                        "-fx-border-radius: 10px; -fx-background-radius: 10px;"
        );
        restartButton.setOnAction(e -> {
            CategorySelectionView categorySelectionView = new CategorySelectionView();
            try {
                categorySelectionView.start(primaryStage); // Kategori seçim ekranına dön
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Quit Button
        Button quitButton = new Button("Quit");
        quitButton.setStyle(
                "-fx-font-size: 18px; -fx-background-color: #e74c3c; " +
                        "-fx-text-fill: white; -fx-padding: 10px 30px; " +
                        "-fx-border-radius: 10px; -fx-background-radius: 10px;"
        );
        quitButton.setOnAction(e -> {
            primaryStage.close(); // Uygulamayı kapat
        });

        layout.getChildren().addAll(titleLabel, userLabel, categoryLabel, difficultyLabel, scoreLabel, restartButton, quitButton);

        Scene scene = new Scene(layout, 800, 600); // Daha büyük boyut
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz Finished");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
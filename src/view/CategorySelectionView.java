package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CategorySelectionView extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        // Kategori seçimi için ComboBox
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Science", "History", "Geography", "Literature", "Sports", "Technology",
                "Movies", "Music", "Math");
        categoryComboBox.setPromptText("Select a category");

        // Başlat butonu
        Button startButton = new Button("Start Quiz");
        startButton.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;");

        // Start butonuna tıklama olayı
        startButton.setOnAction(e -> {
            String selectedCategory = categoryComboBox.getValue();
            if (selectedCategory != null) {
                QuizView quizView = new QuizView(selectedCategory);
                try {
                    quizView.start(primaryStage); // QuizView'i başlat
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        layout.getChildren().addAll(categoryComboBox, startButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select Category");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

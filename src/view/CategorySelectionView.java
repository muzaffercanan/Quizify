package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CategorySelectionView extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30; -fx-background-color: linear-gradient(to bottom, #ffffff, #87cefa);");

        // Animasyonlu hoş geldiniz mesajı
        Label welcomeLabel = new Label();
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        animateWelcomeMessage(welcomeLabel, "Welcome to the QUIZIFY!");

        // Kullanıcı adını almak için TextField
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name here...");
        nameField.setMaxWidth(200); // Daha küçük bir genişlik

        // Kategori seçimi için ComboBox
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Science", "History", "Geography", "Literature", "Sports", "Technology",
                "Movies", "Music", "Math");
        categoryComboBox.setPromptText("Select a category");

        // Zorluk seçimi için ComboBox
        ComboBox<String> difficultyComboBox = new ComboBox<>();
        difficultyComboBox.getItems().addAll("Easy", "Medium", "Hard");
        difficultyComboBox.setPromptText("Select a difficulty");

        // Quiz başlatma butonu
        Button startButton = new Button("Start Quiz");
        startButton.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;");

        // Başlat butonuna tıklama işlemi
        startButton.setOnAction(e -> {
            String userName = nameField.getText();
            String selectedCategory = categoryComboBox.getValue();
            String selectedDifficulty = difficultyComboBox.getValue();

            // Zorunlu alan kontrolleri
            if (userName == null || userName.trim().isEmpty()) {
                showAlert("Name is required!");
                return;
            }
            if (selectedCategory == null) {
                showAlert("Please select a category!");
                return;
            }
            if (selectedDifficulty == null) {
                showAlert("Please select a difficulty level!");
                return;
            }

            QuizView quizView = new QuizView(selectedCategory, selectedDifficulty, userName);
            try {
                quizView.start(primaryStage); // QuizView'i başlat
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        layout.getChildren().addAll(welcomeLabel, nameField, categoryComboBox, difficultyComboBox, startButton);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz - Select Category and Difficulty");
        primaryStage.show();
    }

    // Hata mesajı göstermek için
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Hoş geldiniz mesajını animasyonlu göstermek için
    private void animateWelcomeMessage(Label label, String message) {
        final int[] index = {0};
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            if (index[0] < message.length()) {
                label.setText(label.getText() + message.charAt(index[0])); // Harf harf ekle
                index[0]++;
            }
        }));
        timeline.setCycleCount(message.length());
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
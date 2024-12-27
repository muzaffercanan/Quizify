package main;


import javafx.application.Application;
import javafx.stage.Stage;
import view.CategorySelectionView;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        CategorySelectionView categorySelectionView = new CategorySelectionView();
        categorySelectionView.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
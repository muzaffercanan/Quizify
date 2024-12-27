// package controller;

// import model.Question;
// import model.QuizManager;
// import model.HintDecorator;

// import java.util.List;
// //import java.util.stream.Collectors;

// public class QuizController {
//     private QuizManager quizManager;
//     private List<Question> filteredQuestions;
//     private int currentQuestionIndex;

//     public QuizController(String category, String difficulty) {
//         quizManager = QuizManager.getInstance();
//         // İki parametreli çağrı
//         quizManager.loadQuestions(category, difficulty);

//         // Soruları doğrudan al, filtreleme gerekmez
//         filteredQuestions = quizManager.getQuestions();

//         currentQuestionIndex = 0;
//     }

//     public Question getNextQuestion() {
//         if (currentQuestionIndex < filteredQuestions.size()) {
//             return filteredQuestions.get(currentQuestionIndex++);
//         }
//         return null; // Sorular bittiğinde null döndür
//     }

//     public Question getNextQuestionWithHint(String hint) {
//         Question question = getNextQuestion();
//         if (question != null) {
//             return new HintDecorator(question, hint);
//         }
//         return null;
//     }

//     public int getQuizScore() {
//         return quizManager.getScore();
//     }

//     public void submitAnswer(String answer, String correctAnswer) {
//         if (answer.equals(correctAnswer)) {
//             quizManager.updateScore(10); // Sabit bir puan eklenebilir ya da stratejiye göre değiştirilebilir
//         }
//     }
// }



package controller;

import model.Question;
import model.QuizManager;
import model.HintDecorator;
import util.DifficultyStrategy;
import util.EasyStrategy;
import util.MediumStrategy;
import util.HardStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class QuizController {
    private QuizManager quizManager;
    private List<Question> filteredQuestions;
    private int currentQuestionIndex;

    public QuizController(String category, String difficulty) {
        quizManager = QuizManager.getInstance();
        // İki parametreli çağrı
        quizManager.loadQuestions(category, difficulty);

        // Soruları doğrudan al, filtreleme gerekmez
        filteredQuestions = quizManager.getQuestions();

        currentQuestionIndex = 0;
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < filteredQuestions.size()) {
            return filteredQuestions.get(currentQuestionIndex++);
        }
        return null; // Sorular bittiğinde null döndür
    }

    public Question getNextQuestionWithHint(String hint) {
        Question question = getNextQuestion();
        if (question != null) {
            return new HintDecorator(question, hint);
        }
        return null;
    }

    public int getQuizScore() {
        return quizManager.getScore();
    }

    public void submitAnswer(String answer, Question question) {
        DifficultyStrategy strategy;
        switch (question.getDifficulty().toLowerCase()) {
            case "easy":
                strategy = new EasyStrategy();
                break;
            case "medium":
                strategy = new MediumStrategy();
                break;
            case "hard":
                strategy = new HardStrategy();
                break;
            default:
                throw new IllegalStateException("Unexpected difficulty: " + question.getDifficulty());
        }

        int baseScore = answer.equals(question.getCorrectAnswer()) ? 10 : 0;
        quizManager.updateScore(strategy.calculateScore(baseScore));
    }

    // Overloaded submitAnswer to match current usage
    public void submitAnswer(String answer, String correctAnswer) {
        if (currentQuestionIndex > 0) {
            Question question = filteredQuestions.get(currentQuestionIndex - 1);
            submitAnswer(answer, question);
        }
    }
}

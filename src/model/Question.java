package model;

public class Question {
    private String category;
    private String questionText;
    private String correctAnswer;
    private String[] options;
    private String difficulty; // Zorluk seviyesi

    public Question(String category, String questionText, String[] options, String correctAnswer, String difficulty) {
        this.category = category;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory(){
        return category;
    }
}

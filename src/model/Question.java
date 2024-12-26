
package model;

public class Question {
    private String category;
    private String questionText;
    private String correctAnswer;
    private String[] options;

    public Question(String category, String questionText, String[] options, String correctAnswer) {
        this.category = category;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() { return questionText; }
    public String[] getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
}

package model;

public abstract class QuestionDecorator extends Question {
    protected Question decoratedQuestion;

    public QuestionDecorator(Question decoratedQuestion) {
        super(decoratedQuestion.getCategory(),
                decoratedQuestion.getQuestionText(),
                decoratedQuestion.getOptions(),
                decoratedQuestion.getCorrectAnswer(),
                decoratedQuestion.getDifficulty());
        this.decoratedQuestion = decoratedQuestion;
    }

    @Override
    public String getQuestionText() {
        return decoratedQuestion.getQuestionText();
    }
}

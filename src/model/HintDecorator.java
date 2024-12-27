package model;

public class HintDecorator extends QuestionDecorator {
    private String hint;

    public HintDecorator(Question decoratedQuestion, String hint) {
        super(decoratedQuestion);
        this.hint = hint;
    }

    @Override
    public String getQuestionText() {
        return super.getQuestionText() + "\nHint: " + hint; // İpucunu ekrana göster
    }

    public String getHint() {
        return hint;
    }
}
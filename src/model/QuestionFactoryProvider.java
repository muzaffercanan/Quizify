package model;

// Factory Selector
class QuestionFactoryProvider {
    public static QuestionFactory getFactory(String category) {
        switch (category) {
            case "Science":
                return new ScienceQuestionFactory();
            case "History":
                return new HistoryQuestionFactory();
            // More factories can be added here
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}

package model;

// Factory Selector
class QuestionFactoryProvider {
    public static QuestionFactory getFactory(String category) {
        switch (category) {
            case "Science":
                return new ScienceQuestionFactory();
            case "History":
                return new HistoryQuestionFactory();
            case "Geography":
                return new GeographyQuestionFactory();
            case "Literature":
                return new LiteratureQuestionFactory();
            case "Sports":
                return new SportsQuestionFactory();
            case "Technology":
                return new TechnologyQuestionFactory();
            case "Movies":
                return new MoviesQuestionFactory();
            case "Music":
                return new MusicQuestionFactory();
            case "Math":
                return new MathQuestionFactory();
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}

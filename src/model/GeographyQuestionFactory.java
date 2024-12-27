package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Geography Factory
class GeographyQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Geography", "What is the largest continent?",
                new String[] { "Asia", "Africa", "Europe" }, "Asia", "Easy"));
        questions.add(new Question("Geography", "What is the capital of Australia?",
                new String[] { "Canberra", "Sydney", "Melbourne" }, "Canberra", "Medium"));
        questions.add(new Question("Geography", "Which desert is the largest in the world?",
                new String[] { "Sahara", "Gobi", "Arctic" }, "Sahara", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

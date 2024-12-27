package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Concrete Factory for Science
class ScienceQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Science", "What is H2O?",
                new String[] { "Water", "Oxygen", "Helium" }, "Water", "Easy"));
        questions.add(new Question("Science", "What planet is known as the Red Planet?",
                new String[] { "Mars", "Earth", "Jupiter" }, "Mars", "Medium"));
        questions.add(new Question("Science", "What gas do plants absorb from the atmosphere?",
                new String[] { "Carbon Dioxide", "Oxygen", "Nitrogen" }, "Carbon Dioxide", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}
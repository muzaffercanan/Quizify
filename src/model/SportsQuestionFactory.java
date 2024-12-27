package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SportsQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Sports", "Which country won the FIFA World Cup in 2018?",
                new String[] { "France", "Germany", "Brazil" }, "France", "Easy"));
        questions.add(new Question("Sports", "What is the national sport of Japan?",
                new String[] { "Sumo", "Judo", "Karate" }, "Sumo", "Medium"));
        questions.add(new Question("Sports", "Who holds the record for the most Olympic gold medals?",
                new String[] { "Michael Phelps", "Usain Bolt", "Carl Lewis" }, "Michael Phelps", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

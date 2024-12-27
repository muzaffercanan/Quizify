package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class HistoryQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("History", "Who discovered America?",
                new String[] { "Columbus", "Magellan", "Vasco" }, "Columbus", "Easy"));
        questions.add(new Question("History", "When did World War II end?",
                new String[] { "1945", "1939", "1918" }, "1945", "Medium"));
        questions.add(new Question("History", "Who built the Great Wall of China?",
                new String[] { "Qin Dynasty", "Han Dynasty", "Tang Dynasty" }, "Qin Dynasty", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

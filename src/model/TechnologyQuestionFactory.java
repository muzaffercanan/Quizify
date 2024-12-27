package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TechnologyQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Technology", "Who invented the telephone?",
                new String[] { "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla" }, "Alexander Graham Bell",
                "Easy"));
        questions.add(new Question("Technology", "What does HTTP stand for?",
                new String[] { "HyperText Transfer Protocol", "Hyperlink Text Protocol",
                        "High Transfer Text Protocol" },
                "HyperText Transfer Protocol", "Medium"));
        questions.add(new Question("Technology", "What is the most used programming language?",
                new String[] { "Python", "Java", "C++" }, "Python", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

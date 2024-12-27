package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MoviesQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Movies", "Who directed 'Titanic'?",
                new String[] { "James Cameron", "Steven Spielberg", "Christopher Nolan" }, "James Cameron", "Easy"));
        questions.add(new Question("Movies", "Who played Jack in 'Titanic'?",
                new String[] { "Leonardo DiCaprio", "Brad Pitt", "Johnny Depp" }, "Leonardo DiCaprio", "Medium"));
        questions.add(new Question("Movies", "What year was the first Harry Potter movie released?",
                new String[] { "2001", "2000", "2002" }, "2001", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class LiteratureQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Literature", "Who wrote 'Hamlet'?",
                new String[] { "William Shakespeare", "Charles Dickens", "J.K. Rowling" }, "William Shakespeare",
                "Easy"));
        questions.add(new Question("Literature", "Who wrote 'Pride and Prejudice'?",
                new String[] { "Jane Austen", "Emily Bronte", "Virginia Woolf" }, "Jane Austen", "Medium"));
        questions.add(new Question("Literature", "Who wrote 'The Divine Comedy'?",
                new String[] { "Dante", "Homer", "Virgil" }, "Dante", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

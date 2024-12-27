package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MathQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Math", "What is the value of Pi (to two decimal places)?",
                new String[] { "3.14", "3.15", "3.13" }, "3.14", "Easy"));
        questions.add(new Question("Math", "What is the square root of 144?",
                new String[] { "12", "14", "16" }, "12", "Medium"));
        questions.add(new Question("Math", "What is 7 x 8?",
                new String[] { "56", "54", "58" }, "56", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

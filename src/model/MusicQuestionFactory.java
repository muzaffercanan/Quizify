package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MusicQuestionFactory implements QuestionFactory {
    @Override
    public List<Question> generateQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Music", "Who is known as the King of Pop?",
                new String[] { "Michael Jackson", "Elvis Presley", "Prince" }, "Michael Jackson", "Easy"));
        questions.add(new Question("Music", "What band was Freddie Mercury the lead singer for?",
                new String[] { "Queen", "The Beatles", "The Rolling Stones" }, "Queen", "Medium"));
        questions.add(new Question("Music", "Who composed the Four Seasons?",
                new String[] { "Vivaldi", "Mozart", "Beethoven" }, "Vivaldi", "Hard"));
        return questions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}

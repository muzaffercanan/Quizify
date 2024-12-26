package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionFactory {
    public static List<Question> generateQuestions(String category, String difficulty) {
        List<Question> questions = new ArrayList<>();

        if ("Science".equals(category)) {
            questions
                    .add(new Question(category, "What is H2O?", new String[] { "Water", "Oxygen", "Helium" }, "Water"));
            questions.add(new Question(category, "What planet is known as the Red Planet?",
                    new String[] { "Mars", "Earth", "Jupiter" }, "Mars"));
            questions.add(new Question(category, "What gas do plants absorb from the atmosphere?",
                    new String[] { "Carbon Dioxide", "Oxygen", "Nitrogen" }, "Carbon Dioxide"));
            questions.add(new Question(category, "What is the chemical symbol for Gold?",
                    new String[] { "Au", "Ag", "Fe" }, "Au"));
            questions.add(new Question(category, "How many bones are in the human body?",
                    new String[] { "206", "210", "180" }, "206"));
        } 
        else if ("History".equals(category)) {
            questions.add(new Question(category, "Who discovered America?",
                    new String[] { "Columbus", "Magellan", "Vasco" }, "Columbus"));
            questions.add(new Question(category, "When did World War II end?", new String[] { "1945", "1939", "1918" },
                    "1945"));
            questions.add(new Question(category, "Who was the first president of the United States?",
                    new String[] { "George Washington", "Abraham Lincoln", "Thomas Jefferson" }, "George Washington"));
            questions.add(new Question(category, "What year did the Titanic sink?",
                    new String[] { "1912", "1920", "1905" }, "1912"));
            questions.add(new Question(category, "What was the name of the first human-made satellite?",
                    new String[] { "Sputnik", "Apollo", "Luna" }, "Sputnik"));
        }

        Collections.shuffle(questions); // Soruları karıştır
        return questions;
    }
}

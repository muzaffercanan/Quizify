
package model;

import java.util.ArrayList;
import java.util.List;

public class QuestionFactory {
    public static List<Question> generateQuestions(String category, String difficulty) {
        List<Question> questions = new ArrayList<>();
        
        if ("Science".equals(category)) {
            questions.add(new Question(category, "What is H2O?", new String[]{"Water", "Oxygen", "Helium"}, "Water"));
        } else if ("History".equals(category)) {
            questions.add(new Question(category, "Who discovered America?", new String[]{"Columbus", "Magellan", "Vasco"}, "Columbus"));
        }
        return questions;
    }
}

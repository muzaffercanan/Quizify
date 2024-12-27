package model;
import java.util.List;


// Factory Interface
public interface QuestionFactory {
        List<Question> generateQuestions(String difficulty);
}
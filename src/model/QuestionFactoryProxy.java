package model;

import java.util.List;

// Proxy sınıfı
public class QuestionFactoryProxy implements QuestionFactory {
    private String category;
    private QuestionFactory realFactory;

    public QuestionFactoryProxy(String category) {
        this.category = category;
    }

    @Override
    public List<Question> generateQuestions(String difficulty) {
        if (realFactory == null) {
            // Gerçek factory yalnızca gerektiğinde oluşturulur
            realFactory = QuestionFactoryProvider.getFactory(category);
        }
        return realFactory.generateQuestions(difficulty);
    }
}

        package model;

        import java.util.ArrayList;
        import java.util.List;

        public class JSONQuestionAdapter implements QuestionFactory {
            private JSONQuestionProvider jsonProvider;

            public JSONQuestionAdapter(JSONQuestionProvider jsonProvider) {
                this.jsonProvider = jsonProvider;
            }

            @Override
            public List<Question> generateQuestions(String difficulty) {
                List<Question> questions = new ArrayList<>();
                List<JSONQuestion> jsonQuestions = jsonProvider.getQuestions();

                for (JSONQuestion jsonQuestion : jsonQuestions) {
                    if (jsonQuestion.getDifficulty().equalsIgnoreCase(difficulty)) {
                        questions.add(new Question(
                                jsonQuestion.getCategory(),
                                jsonQuestion.getQuestionText(),
                                jsonQuestion.getOptions(),
                                jsonQuestion.getCorrectAnswer(),
                                jsonQuestion.getDifficulty()));
                    }
                }

                return questions;
            }
        }

        // JSON Soru Sağlayıcı
        class JSONQuestionProvider {
            public List<JSONQuestion> getQuestions() {
                List<JSONQuestion> jsonQuestions = new ArrayList<>();
                jsonQuestions.add(new JSONQuestion("Science", "What is H2O?", new String[] { "Water", "Oxygen", "Helium" },
                        "Water", "Easy"));
                jsonQuestions.add(new JSONQuestion("Math", "What is 2 + 2?", new String[] { "3", "4", "5" }, "4", "Easy"));
                // Daha fazla JSON verisi eklenebilir
                return jsonQuestions;
            }
        }

        // JSON formatındaki soru yapısı
        class JSONQuestion {
            private String category;
            private String questionText;
            private String[] options;
            private String correctAnswer;
            private String difficulty;

            public JSONQuestion(String category, String questionText, String[] options, String correctAnswer,
                    String difficulty) {
                this.category = category;
                this.questionText = questionText;
                this.options = options;
                this.correctAnswer = correctAnswer;
                this.difficulty = difficulty;
            }

            public String getCategory() {
                return category;
            }

            public String getQuestionText() {
                return questionText;
            }

            public String[] getOptions() {
                return options;
            }

            public String getCorrectAnswer() {
                return correctAnswer;
            }

            public String getDifficulty() {
                return difficulty;
            }
        }

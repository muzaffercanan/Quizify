package model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// Factory Interface
public interface QuestionFactory {
        List<Question> generateQuestions(String difficulty);
}

class GeographyQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
            questions.add(new Question("Geography", "What is the largest continent?",
                    new String[] { "Asia", "Africa", "Europe" }, "Asia", "Easy"));
            questions.add(new Question("Geography", "What is the capital of Australia?",
                    new String[] { "Canberra", "Sydney", "Melbourne" }, "Canberra", "Medium"));
            questions.add(new Question("Geography", "Which desert is the largest in the world?",
                    new String[] { "Sahara", "Gobi", "Arctic" }, "Sahara", "Hard"));
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

    class HistoryQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
            questions.add(new Question("History", "Who discovered America?",
                    new String[] { "Columbus", "Magellan", "Vasco" }, "Columbus", "Easy"));
            questions.add(new Question("History", "When did World War II end?",
                    new String[] { "1945", "1939", "1918" }, "1945", "Medium"));
            questions.add(new Question("History", "Who built the Great Wall of China?",
                    new String[] { "Qin Dynasty", "Han Dynasty", "Tang Dynasty" }, "Qin Dynasty", "Hard"));
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

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

    class ScienceQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
            questions.add(new Question("Science", "What is H2O?",
                    new String[] { "Water", "Oxygen", "Helium" }, "Water", "Easy"));
            questions.add(new Question("Science", "What planet is known as the Red Planet?",
                    new String[] { "Mars", "Earth", "Jupiter" }, "Mars", "Medium"));
            questions.add(new Question("Science", "What gas do plants absorb from the atmosphere?",
                    new String[] { "Carbon Dioxide", "Oxygen", "Nitrogen" }, "Carbon Dioxide", "Hard"));
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

    class SportsQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
            questions.add(new Question("Sports", "Which country won the FIFA World Cup in 2018?",
                    new String[] { "France", "Germany", "Brazil" }, "France", "Easy"));
            questions.add(new Question("Sports", "What is the national sport of Japan?",
                    new String[] { "Sumo", "Judo", "Karate" }, "Sumo", "Medium"));
            questions.add(new Question("Sports", "Who holds the record for the most Olympic gold medals?",
                    new String[] { "Michael Phelps", "Usain Bolt", "Carl Lewis" }, "Michael Phelps", "Hard"));
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

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
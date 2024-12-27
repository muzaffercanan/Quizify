package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionFactory {
        public static List<Question> generateQuestions(String category, String difficulty) {
                List<Question> questions = new ArrayList<>();

                if ("Science".equals(category)) {
                        questions.add(new Question(category, "What is H2O?",
                                        new String[] { "Water", "Oxygen", "Helium" }, "Water", "Easy"));
                        questions.add(new Question(category, "What planet is known as the Red Planet?",
                                        new String[] { "Mars", "Earth", "Jupiter" }, "Mars", "Medium"));
                        questions.add(new Question(category, "What gas do plants absorb from the atmosphere?",
                                        new String[] { "Carbon Dioxide", "Oxygen", "Nitrogen" }, "Carbon Dioxide",
                                        "Hard"));
                } else if ("History".equals(category)) {
                        questions.add(new Question(category, "Who discovered America?",
                                        new String[] { "Columbus", "Magellan", "Vasco" }, "Columbus", "Easy"));
                        questions.add(new Question(category, "When did World War II end?",
                                        new String[] { "1945", "1939", "1918" }, "1945", "Medium"));
                        questions.add(new Question(category, "Who built the Great Wall of China?",
                                        new String[] { "Qin Dynasty", "Han Dynasty", "Tang Dynasty" }, "Qin Dynasty",
                                        "Hard"));
                } else if ("Geography".equals(category)) {
                        questions.add(new Question(category, "What is the largest continent?",
                                        new String[] { "Asia", "Africa", "Europe" }, "Asia", "Easy"));
                        questions.add(new Question(category, "What is the capital of Australia?",
                                        new String[] { "Canberra", "Sydney", "Melbourne" }, "Canberra", "Medium"));
                        questions.add(new Question(category, "Which desert is the largest in the world?",
                                        new String[] { "Sahara", "Gobi", "Arctic" }, "Sahara", "Hard"));
                } else if ("Literature".equals(category)) {
                        questions.add(new Question(category, "Who wrote 'Hamlet'?",
                                        new String[] { "William Shakespeare", "Charles Dickens", "J.K. Rowling" },
                                        "William Shakespeare", "Easy"));
                        questions.add(new Question(category, "Who wrote 'Pride and Prejudice'?",
                                        new String[] { "Jane Austen", "Emily Bronte", "Virginia Woolf" }, "Jane Austen",
                                        "Medium"));
                        questions.add(new Question(category, "Who wrote 'The Divine Comedy'?",
                                        new String[] { "Dante", "Homer", "Virgil" }, "Dante", "Hard"));
                } else if ("Sports".equals(category)) {
                        questions.add(new Question(category, "Which country won the FIFA World Cup in 2018?",
                                        new String[] { "France", "Germany", "Brazil" }, "France", "Easy"));
                        questions.add(new Question(category, "What is the national sport of Japan?",
                                        new String[] { "Sumo", "Judo", "Karate" }, "Sumo", "Medium"));
                        questions.add(new Question(category, "Who holds the record for the most Olympic gold medals?",
                                        new String[] { "Michael Phelps", "Usain Bolt", "Carl Lewis" }, "Michael Phelps",
                                        "Hard"));
                } else if ("Technology".equals(category)) {
                        questions.add(new Question(category, "Who invented the telephone?",
                                        new String[] { "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla" },
                                        "Alexander Graham Bell", "Easy"));
                        questions.add(new Question(category, "What does HTTP stand for?",
                                        new String[] { "HyperText Transfer Protocol", "Hyperlink Text Protocol",
                                                        "High Transfer Text Protocol" },
                                        "HyperText Transfer Protocol", "Medium"));
                        questions.add(new Question(category, "What is the most used programming language?",
                                        new String[] { "Python", "Java", "C++" }, "Python", "Hard"));
                } else if ("Movies".equals(category)) {
                        questions.add(new Question(category, "Who directed 'Titanic'?",
                                        new String[] { "James Cameron", "Steven Spielberg", "Christopher Nolan" },
                                        "James Cameron", "Easy"));
                        questions.add(new Question(category, "Who played Jack in 'Titanic'?",
                                        new String[] { "Leonardo DiCaprio", "Brad Pitt", "Johnny Depp" },
                                        "Leonardo DiCaprio", "Medium"));
                        questions.add(new Question(category, "What year was the first Harry Potter movie released?",
                                        new String[] { "2001", "2000", "2002" }, "2001", "Hard"));
                } else if ("Music".equals(category)) {
                        questions.add(new Question(category, "Who is known as the King of Pop?",
                                        new String[] { "Michael Jackson", "Elvis Presley", "Prince" },
                                        "Michael Jackson", "Easy"));
                        questions.add(new Question(category, "What band was Freddie Mercury the lead singer for?",
                                        new String[] { "Queen", "The Beatles", "The Rolling Stones" }, "Queen",
                                        "Medium"));
                        questions.add(new Question(category, "Who composed the Four Seasons?",
                                        new String[] { "Vivaldi", "Mozart", "Beethoven" }, "Vivaldi", "Hard"));
                } else if ("Math".equals(category)) {
                        questions.add(new Question(category, "What is the value of Pi (to two decimal places)?",
                                        new String[] { "3.14", "3.15", "3.13" }, "3.14", "Easy"));
                        questions.add(new Question(category, "What is the square root of 144?",
                                        new String[] { "12", "14", "16" }, "12", "Medium"));
                        questions.add(new Question(category, "What is 7 x 8?",
                                        new String[] { "56", "54", "58" }, "56", "Hard"));
                }

                // Zorluk seviyesine göre filtrele
                return questions.stream()
                                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                                .collect(Collectors.toList());
        }
}

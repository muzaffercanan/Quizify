package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionFactory {
        public static List<Question> generateQuestions(String category, String difficulty) {
                List<Question> questions = new ArrayList<>();

                if ("Science".equals(category)) {
                        questions.add(new Question(category, "What is H2O?",
                                        new String[] { "Water", "Oxygen", "Helium" }, "Water"));
                        questions.add(new Question(category, "What planet is known as the Red Planet?",
                                        new String[] { "Mars", "Earth", "Jupiter" }, "Mars"));
                        questions.add(new Question(category, "What gas do plants absorb from the atmosphere?",
                                        new String[] { "Carbon Dioxide", "Oxygen", "Nitrogen" }, "Carbon Dioxide"));
                        questions.add(new Question(category, "What is the chemical symbol for Gold?",
                                        new String[] { "Au", "Ag", "Fe" }, "Au"));
                        questions.add(new Question(category, "How many bones are in the human body?",
                                        new String[] { "206", "210", "180" }, "206"));
                        questions.add(new Question(category, "What is the speed of light in vacuum?",
                                        new String[] { "300,000 km/s", "150,000 km/s", "100,000 km/s" },
                                        "300,000 km/s"));
                        questions.add(new Question(category, "What is the smallest unit of life?",
                                        new String[] { "Cell", "Atom", "Molecule" }, "Cell"));
                } else if ("History".equals(category)) {
                        questions.add(new Question(category, "Who discovered America?",
                                        new String[] { "Columbus", "Magellan", "Vasco" }, "Columbus"));
                        questions.add(new Question(category, "When did World War II end?",
                                        new String[] { "1945", "1939", "1918" }, "1945"));
                        questions.add(new Question(category, "Who was the first president of the United States?",
                                        new String[] { "George Washington", "Abraham Lincoln", "Thomas Jefferson" },
                                        "George Washington"));
                        questions.add(new Question(category, "What year did the Titanic sink?",
                                        new String[] { "1912", "1920", "1905" }, "1912"));
                        questions.add(new Question(category, "What was the name of the first human-made satellite?",
                                        new String[] { "Sputnik", "Apollo", "Luna" }, "Sputnik"));
                        questions.add(new Question(category, "Who built the Great Wall of China?",
                                        new String[] { "Qin Dynasty", "Han Dynasty", "Tang Dynasty" }, "Qin Dynasty"));
                        questions.add(new Question(category, "What year did the Berlin Wall fall?",
                                        new String[] { "1989", "1990", "1985" }, "1989"));
                } else if ("Geography".equals(category)) {
                        questions.add(new Question(category, "What is the largest continent?",
                                        new String[] { "Asia", "Africa", "Europe" }, "Asia"));
                        questions.add(new Question(category, "What is the capital of Australia?",
                                        new String[] { "Canberra", "Sydney", "Melbourne" }, "Canberra"));
                        questions.add(new Question(category, "Which desert is the largest in the world?",
                                        new String[] { "Sahara", "Gobi", "Arctic" }, "Sahara"));
                        questions.add(new Question(category, "Which country has the most natural lakes?",
                                        new String[] { "Canada", "Russia", "USA" }, "Canada"));
                        questions.add(new Question(category, "What is the longest river in the world?",
                                        new String[] { "Nile", "Amazon", "Yangtze" }, "Nile"));
                } else if ("Literature".equals(category)) {
                        questions.add(new Question(category, "Who wrote 'Hamlet'?",
                                        new String[] { "William Shakespeare", "Charles Dickens", "J.K. Rowling" },
                                        "William Shakespeare"));
                        questions.add(new Question(category, "What is the first book of the Bible?",
                                        new String[] { "Genesis", "Exodus", "Leviticus" }, "Genesis"));
                        questions.add(new Question(category, "Who wrote 'Pride and Prejudice'?",
                                        new String[] { "Jane Austen", "Emily Bronte", "Virginia Woolf" },
                                        "Jane Austen"));
                        questions.add(new Question(category, "What is the longest novel in the world?",
                                        new String[] { "War and Peace", "In Search of Lost Time", "The Odyssey" },
                                        "In Search of Lost Time"));
                        questions.add(new Question(category, "Who wrote 'The Divine Comedy'?",
                                        new String[] { "Dante", "Homer", "Virgil" }, "Dante"));
                } else if ("Sports".equals(category)) {
                        questions.add(new Question(category, "Which country won the FIFA World Cup in 2018?",
                                        new String[] { "France", "Germany", "Brazil" }, "France"));
                        questions.add(new Question(category, "What is the national sport of Japan?",
                                        new String[] { "Sumo", "Judo", "Karate" }, "Sumo"));
                        questions.add(new Question(category, "Who holds the record for the most Olympic gold medals?",
                                        new String[] { "Michael Phelps", "Usain Bolt", "Carl Lewis" },
                                        "Michael Phelps"));
                        questions.add(new Question(category,
                                        "What is the term for scoring three goals in a soccer match?",
                                        new String[] { "Hat Trick", "Hattrick", "Triple" }, "Hat Trick"));
                        questions.add(new Question(category, "Which sport is known as 'the king of sports'?",
                                        new String[] { "Football", "Basketball", "Tennis" }, "Football"));
                } else if ("Technology".equals(category)) {
                        questions.add(new Question(category, "Who invented the telephone?",
                                        new String[] { "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla" },
                                        "Alexander Graham Bell"));
                        questions.add(new Question(category, "What does HTTP stand for?",
                                        new String[] { "HyperText Transfer Protocol", "Hyperlink Text Protocol",
                                                        "High Transfer Text Protocol" },
                                        "HyperText Transfer Protocol"));
                        questions.add(new Question(category, "What year was the first iPhone released?",
                                        new String[] { "2007", "2008", "2005" }, "2007"));
                        questions.add(new Question(category, "What is the most used programming language?",
                                        new String[] { "Python", "Java", "C++" }, "Python"));
                        questions.add(new Question(
                                        category, "What does RAM stand for?", new String[] { "Random Access Memory",
                                                        "Read Access Memory", "Run Access Memory" },
                                        "Random Access Memory"));
                } else if ("Movies".equals(category)) {
                        questions.add(new Question(category, "Who directed 'Titanic'?",
                                        new String[] { "James Cameron", "Steven Spielberg", "Christopher Nolan" },
                                        "James Cameron"));
                        questions.add(new Question(category, "What is the highest-grossing movie of all time?",
                                        new String[] { "Avatar", "Avengers: Endgame", "Titanic" }, "Avatar"));
                        questions.add(new Question(category, "Who played Jack in 'Titanic'?",
                                        new String[] { "Leonardo DiCaprio", "Brad Pitt", "Johnny Depp" },
                                        "Leonardo DiCaprio"));
                        questions.add(new Question(category, "What year was the first Harry Potter movie released?",
                                        new String[] { "2001", "2000", "2002" }, "2001"));
                        questions.add(new Question(category, "Who directed 'Inception'?",
                                        new String[] { "Christopher Nolan", "Quentin Tarantino", "Ridley Scott" },
                                        "Christopher Nolan"));
                } else if ("Music".equals(category)) {
                        questions.add(new Question(category, "Who is known as the King of Pop?",
                                        new String[] { "Michael Jackson", "Elvis Presley", "Prince" },
                                        "Michael Jackson"));
                        questions.add(new Question(category, "What is the most streamed song on Spotify?",
                                        new String[] { "Blinding Lights", "Shape of You", "Despacito" },
                                        "Blinding Lights"));
                        questions.add(new Question(category, "Who composed the Four Seasons?",
                                        new String[] { "Vivaldi", "Mozart", "Beethoven" }, "Vivaldi"));
                        questions.add(new Question(category, "What band was Freddie Mercury the lead singer for?",
                                        new String[] { "Queen", "The Beatles", "The Rolling Stones" }, "Queen"));
                        questions.add(new Question(category, "Who is known as the Queen of Pop?",
                                        new String[] { "Madonna", "Lady Gaga", "Beyonce" }, "Madonna"));
                } else if ("Math".equals(category)) {
                        questions.add(new Question(category, "What is the value of Pi (to two decimal places)?",
                                        new String[] { "3.14", "3.15", "3.13" }, "3.14"));
                        questions.add(new Question(category, "What is the square root of 144?",
                                        new String[] { "12", "14", "16" }, "12"));
                        questions.add(new Question(category, "What is 7 x 8?", new String[] { "56", "54", "58" },
                                        "56"));
                        questions.add(new Question(category, "What is the result of 2^3?",
                                        new String[] { "8", "6", "9" }, "8"));
                        questions.add(new Question(category, "What is 100 divided by 4?",
                                        new String[] { "25", "20", "24" }, "25"));
                }

                Collections.shuffle(questions); // Soruları karıştır
                return questions;
        }
}

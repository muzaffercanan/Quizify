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
    
            // Easy Questions
            questions.add(new Question("Geography", "What is the largest continent?",
                    new String[]{"Asia", "Africa", "Europe"}, "Asia", "Easy"));
            questions.add(new Question("Geography", "What is the smallest continent?",
                    new String[]{"Australia", "Europe", "Antarctica"}, "Australia", "Easy"));
            questions.add(new Question("Geography", "What is the capital of France?",
                    new String[]{"Paris", "Rome", "Berlin"}, "Paris", "Easy"));
            questions.add(new Question("Geography", "Which ocean is the largest?",
                    new String[]{"Pacific", "Atlantic", "Indian"}, "Pacific", "Easy"));
            questions.add(new Question("Geography", "Which country has the most population?",
                    new String[]{"China", "India", "USA"}, "China", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Geography", "What is the capital of Australia?",
                    new String[]{"Canberra", "Sydney", "Melbourne"}, "Canberra", "Medium"));
            questions.add(new Question("Geography", "Which country has the most volcanoes?",
                    new String[]{"Indonesia", "Japan", "Iceland"}, "Indonesia", "Medium"));
            questions.add(new Question("Geography", "Which river is the longest in the world?",
                    new String[]{"Nile", "Amazon", "Yangtze"}, "Nile", "Medium"));
            questions.add(new Question("Geography", "What is the capital of South Africa?",
                    new String[]{"Pretoria", "Cape Town", "Johannesburg"}, "Pretoria", "Medium"));
            questions.add(new Question("Geography", "What is the tallest mountain in the world?",
                    new String[]{"Mount Everest", "K2", "Kangchenjunga"}, "Mount Everest", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Geography", "Which desert is the largest in the world?",
                    new String[]{"Sahara", "Gobi", "Arctic"}, "Sahara", "Hard"));
            questions.add(new Question("Geography", "Which country has the most natural lakes?",
                    new String[]{"Canada", "Russia", "Brazil"}, "Canada", "Hard"));
            questions.add(new Question("Geography", "Which city is the most populous in the world?",
                    new String[]{"Tokyo", "Shanghai", "Mumbai"}, "Tokyo", "Hard"));
            questions.add(new Question("Geography", "Which country has the highest altitude capital city?",
                    new String[]{"Bolivia", "Peru", "Nepal"}, "Bolivia", "Hard"));
            questions.add(new Question("Geography", "Which sea is the saltiest in the world?",
                    new String[]{"Dead Sea", "Red Sea", "Mediterranean"}, "Dead Sea", "Hard"));
    
            // Soruları zorluk seviyesine göre filtrele ve döndür
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class HistoryQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("History", "Who discovered America?",
                    new String[]{"Columbus", "Magellan", "Vasco"}, "Columbus", "Easy"));
            questions.add(new Question("History", "Who was the first President of the United States?",
                    new String[]{"George Washington", "Abraham Lincoln", "Thomas Jefferson"}, "George Washington", "Easy"));
            questions.add(new Question("History", "When was the Declaration of Independence signed?",
                    new String[]{"1776", "1775", "1781"}, "1776", "Easy"));
            questions.add(new Question("History", "What year did World War I start?",
                    new String[]{"1914", "1918", "1939"}, "1914", "Easy"));
            questions.add(new Question("History", "What was the name of the ship on which the Pilgrims traveled to America?",
                    new String[]{"Mayflower", "Santa Maria", "Endeavour"}, "Mayflower", "Easy"));
    
            // Medium Questions
            questions.add(new Question("History", "When did World War II end?",
                    new String[]{"1945", "1939", "1918"}, "1945", "Medium"));
            questions.add(new Question("History", "Which year did the Berlin Wall fall?",
                    new String[]{"1989", "1991", "1987"}, "1989", "Medium"));
            questions.add(new Question("History", "Who was known as the Iron Lady?",
                    new String[]{"Margaret Thatcher", "Indira Gandhi", "Angela Merkel"}, "Margaret Thatcher", "Medium"));
            questions.add(new Question("History", "What empire did Genghis Khan rule?",
                    new String[]{"Mongol Empire", "Ottoman Empire", "Roman Empire"}, "Mongol Empire", "Medium"));
            questions.add(new Question("History", "What year did the Titanic sink?",
                    new String[]{"1912", "1911", "1913"}, "1912", "Medium"));
    
            // Hard Questions
            questions.add(new Question("History", "Who built the Great Wall of China?",
                    new String[]{"Qin Dynasty", "Han Dynasty", "Tang Dynasty"}, "Qin Dynasty", "Hard"));
            questions.add(new Question("History", "What was the capital of the Byzantine Empire?",
                    new String[]{"Constantinople", "Rome", "Athens"}, "Constantinople", "Hard"));
            questions.add(new Question("History", "Who was the first Emperor of Rome?",
                    new String[]{"Augustus", "Julius Caesar", "Nero"}, "Augustus", "Hard"));
            questions.add(new Question("History", "Which treaty ended World War I?",
                    new String[]{"Treaty of Versailles", "Treaty of Paris", "Treaty of Tordesillas"}, "Treaty of Versailles", "Hard"));
            questions.add(new Question("History", "Which pharaoh built the Great Pyramid of Giza?",
                    new String[]{"Khufu", "Tutankhamun", "Ramses II"}, "Khufu", "Hard"));
    
            // Soruları zorluk seviyesine göre filtrele ve döndür
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class LiteratureQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Literature", "Who wrote 'Hamlet'?",
                    new String[]{"William Shakespeare", "Charles Dickens", "J.K. Rowling"}, "William Shakespeare", "Easy"));
            questions.add(new Question("Literature", "Who wrote 'Pride and Prejudice'?",
                    new String[]{"Jane Austen", "Emily Bronte", "Virginia Woolf"}, "Jane Austen", "Easy"));
            questions.add(new Question("Literature", "Who wrote 'The Great Gatsby'?",
                    new String[]{"F. Scott Fitzgerald", "Ernest Hemingway", "Mark Twain"}, "F. Scott Fitzgerald", "Easy"));
            questions.add(new Question("Literature", "Who wrote '1984'?",
                    new String[]{"George Orwell", "Aldous Huxley", "Ray Bradbury"}, "George Orwell", "Easy"));
            questions.add(new Question("Literature", "Who wrote 'Moby Dick'?",
                    new String[]{"Herman Melville", "Mark Twain", "Nathaniel Hawthorne"}, "Herman Melville", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Literature", "Who wrote 'The Divine Comedy'?",
                    new String[]{"Dante", "Homer", "Virgil"}, "Dante", "Medium"));
            questions.add(new Question("Literature", "What is the name of the wizard in J.R.R. Tolkien's 'The Hobbit'?",
                    new String[]{"Gandalf", "Saruman", "Radagast"}, "Gandalf", "Medium"));
            questions.add(new Question("Literature", "Who wrote the novel 'To Kill a Mockingbird'?",
                    new String[]{"Harper Lee", "Margaret Atwood", "Alice Walker"}, "Harper Lee", "Medium"));
            questions.add(new Question("Literature", "Which poet wrote 'The Raven'?",
                    new String[]{"Edgar Allan Poe", "Walt Whitman", "Robert Frost"}, "Edgar Allan Poe", "Medium"));
            questions.add(new Question("Literature", "Who wrote 'Brave New World'?",
                    new String[]{"Aldous Huxley", "George Orwell", "Philip K. Dick"}, "Aldous Huxley", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Literature", "Which ancient poet wrote 'The Iliad'?",
                    new String[]{"Homer", "Sophocles", "Virgil"}, "Homer", "Hard"));
            questions.add(new Question("Literature", "Who wrote the play 'Waiting for Godot'?",
                    new String[]{"Samuel Beckett", "Tennessee Williams", "Arthur Miller"}, "Samuel Beckett", "Hard"));
            questions.add(new Question("Literature", "Who wrote the epic 'Paradise Lost'?",
                    new String[]{"John Milton", "Geoffrey Chaucer", "William Blake"}, "John Milton", "Hard"));
            questions.add(new Question("Literature", "Who is the author of 'War and Peace'?",
                    new String[]{"Leo Tolstoy", "Fyodor Dostoevsky", "Anton Chekhov"}, "Leo Tolstoy", "Hard"));
            questions.add(new Question("Literature", "Who wrote the 'One Hundred Years of Solitude'?",
                    new String[]{"Gabriel Garcia Marquez", "Jorge Luis Borges", "Pablo Neruda"}, "Gabriel Garcia Marquez", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class MathQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Math", "What is 2 + 2?",
                    new String[]{"4", "3", "5"}, "4", "Easy"));
            questions.add(new Question("Math", "What is the value of Pi (to two decimal places)?",
                    new String[]{"3.14", "3.15", "3.13"}, "3.14", "Easy"));
            questions.add(new Question("Math", "What is 10 - 3?",
                    new String[]{"7", "6", "8"}, "7", "Easy"));
            questions.add(new Question("Math", "What is the square root of 16?",
                    new String[]{"4", "5", "6"}, "4", "Easy"));
            questions.add(new Question("Math", "What is 5 x 3?",
                    new String[]{"15", "20", "10"}, "15", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Math", "What is the square root of 144?",
                    new String[]{"12", "14", "16"}, "12", "Medium"));
            questions.add(new Question("Math", "What is 7 x 8?",
                    new String[]{"56", "54", "58"}, "56", "Medium"));
            questions.add(new Question("Math", "What is 15 divided by 3?",
                    new String[]{"5", "6", "4"}, "5", "Medium"));
            questions.add(new Question("Math", "What is 9 squared?",
                    new String[]{"81", "72", "64"}, "81", "Medium"));
            questions.add(new Question("Math", "What is 25% of 200?",
                    new String[]{"50", "40", "60"}, "50", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Math", "What is the derivative of x^2?",
                    new String[]{"2x", "x", "2"}, "2x", "Hard"));
            questions.add(new Question("Math", "What is the integral of 2x dx?",
                    new String[]{"x^2 + C", "x^2", "2x + C"}, "x^2 + C", "Hard"));
            questions.add(new Question("Math", "What is the value of sin(90°)?",
                    new String[]{"1", "0", "0.5"}, "1", "Hard"));
            questions.add(new Question("Math", "What is the solution to the equation x^2 - 4 = 0?",
                    new String[]{"2 and -2", "4 and -4", "1 and -1"}, "2 and -2", "Hard"));
            questions.add(new Question("Math", "What is the factorial of 5?",
                    new String[]{"120", "60", "24"}, "120", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class MoviesQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Movies", "Who directed 'Titanic'?",
                    new String[]{"James Cameron", "Steven Spielberg", "Christopher Nolan"}, "James Cameron", "Easy"));
            questions.add(new Question("Movies", "Who played Jack in 'Titanic'?",
                    new String[]{"Leonardo DiCaprio", "Brad Pitt", "Johnny Depp"}, "Leonardo DiCaprio", "Easy"));
            questions.add(new Question("Movies", "Which movie features a singing lion cub?",
                    new String[]{"The Lion King", "Madagascar", "Zootopia"}, "The Lion King", "Easy"));
            questions.add(new Question("Movies", "What is the name of the wizard in 'The Lord of the Rings'?",
                    new String[]{"Gandalf", "Dumbledore", "Saruman"}, "Gandalf", "Easy"));
            questions.add(new Question("Movies", "Which Disney movie features a princess named Belle?",
                    new String[]{"Beauty and the Beast", "Cinderella", "Sleeping Beauty"}, "Beauty and the Beast", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Movies", "Who directed 'Inception'?",
                    new String[]{"Christopher Nolan", "James Cameron", "Steven Spielberg"}, "Christopher Nolan", "Medium"));
            questions.add(new Question("Movies", "Which year was the first Harry Potter movie released?",
                    new String[]{"2001", "2000", "2002"}, "2001", "Medium"));
            questions.add(new Question("Movies", "Which movie won the Best Picture Oscar in 2020?",
                    new String[]{"Parasite", "1917", "Joker"}, "Parasite", "Medium"));
            questions.add(new Question("Movies", "What is the name of the first Avengers movie?",
                    new String[]{"The Avengers", "Avengers Assemble", "Infinity War"}, "The Avengers", "Medium"));
            questions.add(new Question("Movies", "What is the highest-grossing movie of all time?",
                    new String[]{"Avatar", "Avengers: Endgame", "Titanic"}, "Avatar", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Movies", "Who composed the score for 'Star Wars'?",
                    new String[]{"John Williams", "Hans Zimmer", "James Horner"}, "John Williams", "Hard"));
            questions.add(new Question("Movies", "Which director is known for the movie 'Pulp Fiction'?",
                    new String[]{"Quentin Tarantino", "Martin Scorsese", "Steven Spielberg"}, "Quentin Tarantino", "Hard"));
            questions.add(new Question("Movies", "What is the name of the first James Bond movie?",
                    new String[]{"Dr. No", "Goldfinger", "From Russia with Love"}, "Dr. No", "Hard"));
            questions.add(new Question("Movies", "Who played the Joker in 'The Dark Knight'?",
                    new String[]{"Heath Ledger", "Joaquin Phoenix", "Jack Nicholson"}, "Heath Ledger", "Hard"));
            questions.add(new Question("Movies", "What year was the first Academy Awards held?",
                    new String[]{"1929", "1930", "1928"}, "1929", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class MusicQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Music", "Who is known as the King of Pop?",
                    new String[]{"Michael Jackson", "Elvis Presley", "Prince"}, "Michael Jackson", "Easy"));
            questions.add(new Question("Music", "What band was Freddie Mercury the lead singer for?",
                    new String[]{"Queen", "The Beatles", "The Rolling Stones"}, "Queen", "Easy"));
            questions.add(new Question("Music", "Who composed the Four Seasons?",
                    new String[]{"Vivaldi", "Mozart", "Beethoven"}, "Vivaldi", "Easy"));
            questions.add(new Question("Music", "Which artist sang 'Shape of You'?",
                    new String[]{"Ed Sheeran", "Justin Bieber", "Adele"}, "Ed Sheeran", "Easy"));
            questions.add(new Question("Music", "Which instrument has 88 keys?",
                    new String[]{"Piano", "Guitar", "Violin"}, "Piano", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Music", "Who won the Eurovision Song Contest in 2021?",
                    new String[]{"Måneskin", "Lordi", "Duncan Laurence"}, "Måneskin", "Medium"));
            questions.add(new Question("Music", "What is the best-selling album of all time?",
                    new String[]{"Thriller", "Back in Black", "The Dark Side of the Moon"}, "Thriller", "Medium"));
            questions.add(new Question("Music", "Which band released the album 'The Wall'?",
                    new String[]{"Pink Floyd", "The Beatles", "Led Zeppelin"}, "Pink Floyd", "Medium"));
            questions.add(new Question("Music", "What is the real name of the artist known as Lady Gaga?",
                    new String[]{"Stefani Germanotta", "Stephanie Jones", "Stefanie Carter"}, "Stefani Germanotta", "Medium"));
            questions.add(new Question("Music", "Who is the youngest artist to win a Grammy?",
                    new String[]{"Billie Eilish", "Taylor Swift", "Adele"}, "Billie Eilish", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Music", "Which composer wrote the 'Moonlight Sonata'?",
                    new String[]{"Beethoven", "Mozart", "Bach"}, "Beethoven", "Hard"));
            questions.add(new Question("Music", "What year was the song 'Bohemian Rhapsody' released?",
                    new String[]{"1975", "1977", "1974"}, "1975", "Hard"));
            questions.add(new Question("Music", "Which artist is known as the 'Godfather of Soul'?",
                    new String[]{"James Brown", "Ray Charles", "Sam Cooke"}, "James Brown", "Hard"));
            questions.add(new Question("Music", "What is the name of The Beatles' first album?",
                    new String[]{"Please Please Me", "Help!", "Abbey Road"}, "Please Please Me", "Hard"));
            questions.add(new Question("Music", "Which composer wrote the opera 'Carmen'?",
                    new String[]{"Bizet", "Puccini", "Verdi"}, "Bizet", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class ScienceQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Science", "What is H2O?",
                    new String[]{"Water", "Oxygen", "Helium"}, "Water", "Easy"));
            questions.add(new Question("Science", "What planet is known as the Red Planet?",
                    new String[]{"Mars", "Earth", "Jupiter"}, "Mars", "Easy"));
            questions.add(new Question("Science", "What gas do plants absorb from the atmosphere?",
                    new String[]{"Carbon Dioxide", "Oxygen", "Nitrogen"}, "Carbon Dioxide", "Easy"));
            questions.add(new Question("Science", "What is the primary source of energy for the Earth?",
                    new String[]{"Sun", "Wind", "Water"}, "Sun", "Easy"));
            questions.add(new Question("Science", "What is the boiling point of water at sea level?",
                    new String[]{"100°C", "90°C", "120°C"}, "100°C", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Science", "What is the chemical symbol for gold?",
                    new String[]{"Au", "Ag", "Fe"}, "Au", "Medium"));
            questions.add(new Question("Science", "What is the main gas in the Earth's atmosphere?",
                    new String[]{"Nitrogen", "Oxygen", "Carbon Dioxide"}, "Nitrogen", "Medium"));
            questions.add(new Question("Science", "What is the speed of light?",
                    new String[]{"299,792 km/s", "300,000 km/s", "250,000 km/s"}, "299,792 km/s", "Medium"));
            questions.add(new Question("Science", "Who developed the theory of relativity?",
                    new String[]{"Albert Einstein", "Isaac Newton", "Galileo Galilei"}, "Albert Einstein", "Medium"));
            questions.add(new Question("Science", "What is the smallest unit of life?",
                    new String[]{"Cell", "Molecule", "Atom"}, "Cell", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Science", "What is the scientific name for humans?",
                    new String[]{"Homo sapiens", "Homo erectus", "Homo habilis"}, "Homo sapiens", "Hard"));
            questions.add(new Question("Science", "What is the chemical formula for table salt?",
                    new String[]{"NaCl", "KCl", "MgCl"}, "NaCl", "Hard"));
            questions.add(new Question("Science", "Who discovered penicillin?",
                    new String[]{"Alexander Fleming", "Marie Curie", "Louis Pasteur"}, "Alexander Fleming", "Hard"));
            questions.add(new Question("Science", "What is the second most abundant element in the Earth's crust?",
                    new String[]{"Silicon", "Oxygen", "Aluminum"}, "Silicon", "Hard"));
            questions.add(new Question("Science", "What is the name of the first artificial satellite sent into space?",
                    new String[]{"Sputnik", "Apollo", "Voyager"}, "Sputnik", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class SportsQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Sports", "Which country won the FIFA World Cup in 2018?",
                    new String[]{"France", "Germany", "Brazil"}, "France", "Easy"));
            questions.add(new Question("Sports", "What is the national sport of Japan?",
                    new String[]{"Sumo", "Judo", "Karate"}, "Sumo", "Easy"));
            questions.add(new Question("Sports", "Which sport is known as 'The Beautiful Game'?",
                    new String[]{"Soccer", "Basketball", "Tennis"}, "Soccer", "Easy"));
            questions.add(new Question("Sports", "Which country hosts the Wimbledon tournament?",
                    new String[]{"England", "USA", "Australia"}, "England", "Easy"));
            questions.add(new Question("Sports", "How many players are on a basketball team?",
                    new String[]{"5", "7", "6"}, "5", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Sports", "Who holds the record for the most Olympic gold medals?",
                    new String[]{"Michael Phelps", "Usain Bolt", "Carl Lewis"}, "Michael Phelps", "Medium"));
            questions.add(new Question("Sports", "Which country won the first FIFA World Cup in 1930?",
                    new String[]{"Uruguay", "Brazil", "Italy"}, "Uruguay", "Medium"));
            questions.add(new Question("Sports", "What is the length of a marathon?",
                    new String[]{"42.195 km", "40 km", "50 km"}, "42.195 km", "Medium"));
            questions.add(new Question("Sports", "Which athlete is known as 'The Fastest Man Alive'?",
                    new String[]{"Usain Bolt", "Carl Lewis", "Michael Johnson"}, "Usain Bolt", "Medium"));
            questions.add(new Question("Sports", "What sport is associated with Wimbledon?",
                    new String[]{"Tennis", "Cricket", "Football"}, "Tennis", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Sports", "Which country has won the most Cricket World Cups?",
                    new String[]{"Australia", "India", "West Indies"}, "Australia", "Hard"));
            questions.add(new Question("Sports", "Which football player has the most Ballon d'Or awards?",
                    new String[]{"Lionel Messi", "Cristiano Ronaldo", "Zinedine Zidane"}, "Lionel Messi", "Hard"));
            questions.add(new Question("Sports", "Which year were the first modern Olympic Games held?",
                    new String[]{"1896", "1900", "1888"}, "1896", "Hard"));
            questions.add(new Question("Sports", "Who is the all-time top scorer in the UEFA Champions League?",
                    new String[]{"Cristiano Ronaldo", "Lionel Messi", "Raúl"}, "Cristiano Ronaldo", "Hard"));
            questions.add(new Question("Sports", "Which country hosted the 2008 Summer Olympics?",
                    new String[]{"China", "USA", "Australia"}, "China", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }

class TechnologyQuestionFactory implements QuestionFactory {
        @Override
        public List<Question> generateQuestions(String difficulty) {
            List<Question> questions = new ArrayList<>();
    
            // Easy Questions
            questions.add(new Question("Technology", "Who invented the telephone?",
                    new String[]{"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla"}, "Alexander Graham Bell", "Easy"));
            questions.add(new Question("Technology", "What does HTTP stand for?",
                    new String[]{"HyperText Transfer Protocol", "Hyperlink Text Protocol", "High Transfer Text Protocol"},
                    "HyperText Transfer Protocol", "Easy"));
            questions.add(new Question("Technology", "What is the most used programming language?",
                    new String[]{"Python", "Java", "C++"}, "Python", "Easy"));
            questions.add(new Question("Technology", "Who is known as the father of computers?",
                    new String[]{"Charles Babbage", "Alan Turing", "John von Neumann"}, "Charles Babbage", "Easy"));
            questions.add(new Question("Technology", "What is the name of Apple's personal assistant?",
                    new String[]{"Siri", "Alexa", "Google Assistant"}, "Siri", "Easy"));
    
            // Medium Questions
            questions.add(new Question("Technology", "What year was the first iPhone released?",
                    new String[]{"2007", "2005", "2008"}, "2007", "Medium"));
            questions.add(new Question("Technology", "What does GPU stand for?",
                    new String[]{"Graphics Processing Unit", "Global Processing Unit", "General Processing Unit"},
                    "Graphics Processing Unit", "Medium"));
            questions.add(new Question("Technology", "What is the term for malicious software?",
                    new String[]{"Malware", "Spyware", "Adware"}, "Malware", "Medium"));
            questions.add(new Question("Technology", "What company is known for developing the Windows operating system?",
                    new String[]{"Microsoft", "Apple", "Google"}, "Microsoft", "Medium"));
            questions.add(new Question("Technology", "Which company created the Android operating system?",
                    new String[]{"Google", "Apple", "Samsung"}, "Google", "Medium"));
    
            // Hard Questions
            questions.add(new Question("Technology", "What was the name of the first electronic computer?",
                    new String[]{"ENIAC", "UNIVAC", "IBM 701"}, "ENIAC", "Hard"));
            questions.add(new Question("Technology", "What is the name of the programming language created by Dennis Ritchie?",
                    new String[]{"C", "C++", "Java"}, "C", "Hard"));
            questions.add(new Question("Technology", "What year was the World Wide Web invented?",
                    new String[]{"1989", "1990", "1991"}, "1989", "Hard"));
            questions.add(new Question("Technology", "Who invented the Linux operating system?",
                    new String[]{"Linus Torvalds", "Richard Stallman", "Steve Jobs"}, "Linus Torvalds", "Hard"));
            questions.add(new Question("Technology", "What is the term for a network security system that monitors and controls incoming and outgoing traffic?",
                    new String[]{"Firewall", "Proxy", "Router"}, "Firewall", "Hard"));
    
            return questions.stream()
                    .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }
    }
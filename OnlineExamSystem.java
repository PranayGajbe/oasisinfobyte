import java.util.Scanner;

class User {
     String username;
     String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters for username and password
    // Add methods for updating user profile and password
}

class Question {
     String text;
     String[] choices;
    int correctChoice;

    public Question(String text, String[] choices, int correctChoice) {
        this.text = text;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctChoice;
    }
}

class Exam {
     User user;
     Question[] questions;
     int[] userAnswers;

    public Exam(User user, Question[] questions) {
        this.user = user;
        this.questions = questions;
        this.userAnswers = new int[questions.length];
    }

    public void startExam() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].text);

            for (int j = 0; j < questions[i].choices.length; j++) {
                System.out.println((j + 1) + ". " + questions[i].choices[j]);
            }

            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();

            userAnswers[i] = userChoice;
        }
    }

    public int calculateScore() {
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            if (questions[i].isCorrect(userAnswers[i])) {
                score++;
            }
        }

        return score;
    }
}

public class OnlineExamSystem {
    public static void main(String[] args) {
        // Create a sample user
        User user = new User("john_doe", "password");

        // Create sample questions
        Question[] questions = new Question[3];
        questions[0] = new Question("What is 2 + 2?", new String[]{"3", "4", "5"}, 2);
        questions[1] = new Question("What is the capital of France?", new String[]{"London", "Paris", "Berlin"}, 2);
        questions[2] = new Question("What is the largest planet in our solar system?", new String[]{"Earth", "Mars", "Jupiter"}, 3);

        // Create an exam for the user
        Exam exam = new Exam(user, questions);

        // Start the exam
        exam.startExam();

        // Calculate and display the score
        int score = exam.calculateScore();
        System.out.println("Your score: " + score);
    }
}

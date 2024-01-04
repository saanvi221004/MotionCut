import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Question {
    private String text;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String text, List<String> options, int correctAnswerIndex) {
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

public class week_1 {
    public static void main(String[] args) {
        // Create questions
        Question question1 = new Question("What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2);

        Question question2 = new Question("Which planet is known as the Red Planet?",
                Arrays.asList("Earth", "Mars", "Jupiter", "Venus"), 1);

        Question question3 = new Question("In which year did Christopher Columbus reach the Americas?",
                Arrays.asList("1492", "1520", "1605", "1622"), 0);

        // Create quiz and add questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        // Take the quiz
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : quiz.getQuestions()) {
            // Display question
            System.out.println(question.getText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            // Get user input
            int userAnswer;
            do {
                System.out.print("Your answer (1-" + options.size() + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // consume the invalid input
                }
                userAnswer = scanner.nextInt();
            } while (userAnswer < 1 || userAnswer > options.size());

            // Check answer
            if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.getCorrectAnswerIndex() + 1) + ". "
                        + options.get(question.getCorrectAnswerIndex()) + "\n");
            }
        }

        // Display final score
        System.out.println("Quiz completed. Your score: " + score + " out of " + quiz.getQuestions().size());

        // Close scanner
        scanner.close();
    }
}

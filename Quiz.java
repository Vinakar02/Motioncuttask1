import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = getUserAnswer(scanner, options.length);

            if (question.isCorrect(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("Your final score is: " + score + "/" + questions.size());
        scanner.close();
    }

    private int getUserAnswer(Scanner scanner, int optionsLength) {
        int userAnswer = -1;
        while (userAnswer < 1 || userAnswer > optionsLength) {
            System.out.print("Your answer: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            userAnswer = scanner.nextInt();
            if (userAnswer < 1 || userAnswer > optionsLength) {
                System.out.println("Please enter a number between 1 and " + optionsLength);
            }
        }
        return userAnswer;
    }
}

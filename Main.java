public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Example questions
        String[] options1 = {"Paris", "London", "Rome", "Berlin"};
        quiz.addQuestion(new Question("What is the capital of France?", options1, 0));

        String[] options2 = {"True", "False"};
        quiz.addQuestion(new Question("Java is a programming language.", options2, 0));

        quiz.start();
    }
}


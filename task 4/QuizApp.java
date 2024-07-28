import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Question {
    String question;
    List<String> options;
    int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    List<Question> questions;
    int score;
    Map<Integer, Boolean> results;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.results = new java.util.HashMap<>();
    }

    public void startQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println(question.question);
            for (String option : question.options) {
                System.out.println(option);
            }
            int answer = new java.util.Scanner(System.in).nextInt();
            if (answer == question.correctAnswer) {
                score++;
                results.put(i + 1, true);
            } else {
                results.put(i + 1, false);
            }
        }
        displayResults();
    }

    private void displayResults() {
        System.out.println("\nQuiz Completed! ");
        System.out.println("Your Score: " + score + "/" + questions.size());
        for (Map.Entry<Integer, Boolean> entry : results.entrySet()) {
            System.out.println("Question " + entry.getKey() + ": " + (entry.getValue() ? "Correct" : "Incorrect"));
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France? ",
                Arrays.asList("1. Berlin", "2. Madrid", "3. Paris", "4. Rome"), 3));
        questions.add(new Question("Which planet is known as the Red Planet? ",
                Arrays.asList("1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"), 2));
        questions.add(new Question("What is the largest ocean on Earth? ",
                Arrays.asList("1. Atlantic", "2. Indian", "3. Arctic", "4. Pacific"), 4));

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}

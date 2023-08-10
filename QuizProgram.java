import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizProgram extends JFrame {
    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[][] questions = {
            {"What is the capital of France?", "Paris", "Berlin", "Madrid", "London"},
            {"Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn"},
            {"Which famous scientist developed the theory of relativity?", "Albert Einstein", "Isaac Newton", "Stephen Hawking", "Galileo Galilei"}
    };

    private int[] correctAnswers = {1, 0, 0}; // Index of the correct option for each question

    public QuizProgram() {
        setTitle("Quiz Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 1));

        questionLabel = new JLabel(questions[currentQuestionIndex][0]);
        add(questionLabel);

        option1 = new JRadioButton(questions[currentQuestionIndex][1]);
        option2 = new JRadioButton(questions[currentQuestionIndex][2]);
        option3 = new JRadioButton(questions[currentQuestionIndex][3]);
        option4 = new JRadioButton(questions[currentQuestionIndex][4]);

        optionGroup = new ButtonGroup();
        optionGroup.add(option1);
        optionGroup.add(option2);
        optionGroup.add(option3);
        optionGroup.add(option4);

        add(option1);
        add(option2);
        add(option3);
        add(option4);

        nextButton = new JButton("Next");
        add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    updateQuestion();
                } else {
                    showResult();
                }
            }
        });

        updateQuestion();
    }

    private void updateQuestion() {
        questionLabel.setText(questions[currentQuestionIndex][0]);
        option1.setText(questions[currentQuestionIndex][1]);
        option2.setText(questions[currentQuestionIndex][2]);
        option3.setText(questions[currentQuestionIndex][3]);
        option4.setText(questions[currentQuestionIndex][4]);
        optionGroup.clearSelection();
    }

    private void checkAnswer() {
        if (option1.isSelected() && correctAnswers[currentQuestionIndex] == 0) {
            score++;
        } else if (option2.isSelected() && correctAnswers[currentQuestionIndex] == 1) {
            score++;
        } else if (option3.isSelected() && correctAnswers[currentQuestionIndex] == 2) {
            score++;
        } else if (option4.isSelected() && correctAnswers[currentQuestionIndex] == 3) {
            score++;
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz completed!\nYour score: " + score + " out of " + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizProgram().setVisible(true);
            }
        });
    }
}

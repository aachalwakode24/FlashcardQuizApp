import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlashcardQuizApp extends JFrame {

    ArrayList<String[]> flashcards = new ArrayList<>();

    JLabel questionLabel;
    JLabel answerLabel;

    int currentIndex = 0;

    public FlashcardQuizApp() {

        setTitle("Flashcard Quiz App");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        flashcards.add(new String[]{"What is Java?", "A Programming Language"});
        flashcards.add(new String[]{"What is OOP?", "Object Oriented Programming"});
        flashcards.add(new String[]{"What is JVM?", "Java Virtual Machine"});flashcards.add(new String[]{"What is CPU?", "Central Processing Unit"});
        flashcards.add(new String[]{"What is RAM?", "Random Access Memory"});
        flashcards.add(new String[]{"What is OS?", "Operating System"});
        flashcards.add(new String[]{"What is HTML?", "HyperText Markup Language"});
        flashcards.add(new String[]{"What is CSS?", "Cascading Style Sheets"});
        flashcards.add(new String[]{"What is JavaScript?", "Programming language for web pages"});
        flashcards.add(new String[]{"What is Compiler?", "Converts source code into machine code"});
        flashcards.add(new String[]{"What is Database?", "Collection of organized data"});



        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));

        answerLabel = new JLabel("", SwingConstants.CENTER);
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel centerPanel = new JPanel(new GridLayout(2,1));
        centerPanel.add(questionLabel);
        centerPanel.add(answerLabel);

        JButton showAnswerBtn = new JButton("Show Answer");
        JButton nextBtn = new JButton("Next");
        JButton previousBtn = new JButton("Previous");
        JButton addBtn = new JButton("Add Card");
        JButton deleteBtn = new JButton("Delete Card");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(previousBtn);
        buttonPanel.add(showAnswerBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        displayQuestion();

        showAnswerBtn.addActionListener(e ->
                answerLabel.setText(flashcards.get(currentIndex)[1]));

        nextBtn.addActionListener(e -> {
            if(currentIndex < flashcards.size() - 1) {
                currentIndex++;
                displayQuestion();
            }
        });

        previousBtn.addActionListener(e -> {
            if(currentIndex > 0) {
                currentIndex--;
                displayQuestion();
            }
        });

        addBtn.addActionListener(e -> {
            String question = JOptionPane.showInputDialog("Enter Question");
            String answer = JOptionPane.showInputDialog("Enter Answer");

            if(question != null && answer != null) {
                flashcards.add(new String[]{question, answer});
            }
        });

        deleteBtn.addActionListener(e -> {
            if(flashcards.size() > 1) {
                flashcards.remove(currentIndex);

                if(currentIndex >= flashcards.size()) {
                    currentIndex = flashcards.size() - 1;
                }

                displayQuestion();
            }
        });

        setVisible(true);
    }

    private void displayQuestion() {
        questionLabel.setText(flashcards.get(currentIndex)[0]);
        answerLabel.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new FlashcardQuizApp());
    }
}
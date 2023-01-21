package frames;

import repository.GameRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder; 

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JFrame implements ActionListener {

    private JScrollPane scroll;
    private JTextArea history;
    private JTextField answerArea, currentWord;
    private JPanel buttonsPanel;
    private JProgressBar progressBar;
    private JButton backButton, skipButton, checkButton;
    private int level, score, progress = 0;
    private String user, scrambledWord, correctWord;
    private repository.GameRepository gameRepository;
    private repository.AccountRepository accountRepository;
    private ArrayList<String> words, resultHistory;
    private Random random;

    public String getScrambledWords(String wordToBeScrambeled) {

        char[] wordArray = wordToBeScrambeled.toCharArray();
        char[] dummyWordArray = wordToBeScrambeled.toCharArray();
        random = new Random();

        int r = random.nextInt(wordArray.length - 1);
        int i = 0;
        int j = r + 1;

        while (i <= r) {
            dummyWordArray[wordArray.length - i - 1] = wordArray[i];
            i++;
        }

        while (j <= wordArray.length - 1) {
            dummyWordArray[j - r - 1] = wordArray[j];
            j++;
        }

        String newWord = String.valueOf(dummyWordArray);
        newWord = newWord.replace("", "  ").trim();
        return newWord.toUpperCase();
    }

    public Game(String user, int level) {

        ImageIcon image = new ImageIcon("asset/logo.png");
        setIconImage(image.getImage());

        this.level = level;
        this.score = 0;
        this.user = user;
        resultHistory = new ArrayList<String>();
        accountRepository = new repository.AccountRepository();

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());

        history = new JTextArea(10,35);
        history.setEditable(false);
        // history.setPreferredSize(new Dimension(400, 200));
        history.setFont(new Font("Arial", Font.PLAIN, 20));
        history.setBorder(new EmptyBorder(0,0,0,0));

        scroll = new JScrollPane(history, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        gameRepository = new GameRepository();
        words = gameRepository.getWords(level);
        random = new Random();

        correctWord = words.get(random.nextInt(words.size() - 1));
        scrambledWord = getScrambledWords(correctWord);

        currentWord = new JTextField(scrambledWord);
        currentWord.setFont(new Font("Arial", Font.PLAIN, 20));
        currentWord.setPreferredSize(new Dimension(400, 50));
        currentWord.setHorizontalAlignment(JTextField.LEFT);
        currentWord.setEditable(false);
        currentWord.setBorder(new EmptyBorder(0,0,0,0));
        GridBagConstraints currentWordConstraint = new GridBagConstraints();
        currentWordConstraint.gridx = 0;
        currentWordConstraint.gridy = 1;
        currentWordConstraint.insets = new Insets(50,0,0,0);

        answerArea = new JTextField();
        answerArea.setFont(new Font("Arial", Font.PLAIN, 20));
        answerArea.setPreferredSize(new Dimension(400, 50));
        GridBagConstraints answerAreaConstraint = new GridBagConstraints();
        answerAreaConstraint.gridx = 0;
        answerAreaConstraint.gridy = 2;


        progressBar = new JProgressBar(0, 10);
        progressBar.setValue(progress);
        progressBar.setPreferredSize(new Dimension(400, 10));
        GridBagConstraints progressConstraint = new GridBagConstraints();
        progressConstraint.gridx = 0;
        progressConstraint.gridy = 3;

        buttonsPanel = new JPanel();
        GridBagConstraints buttonsPanelConstraint = new GridBagConstraints();
        buttonsPanelConstraint.gridx = 0;
        buttonsPanelConstraint.gridy = 4;
        buttonsPanelConstraint.insets = new Insets(50, 0, 0, 0);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(this);

        skipButton = new JButton("Skip");
        skipButton.setFocusable(false);
        skipButton.setPreferredSize(new Dimension(100, 30));
        skipButton.addActionListener(this);

        checkButton = new JButton("Check");
        checkButton.setFocusable(false);
        checkButton.setPreferredSize(new Dimension(100, 30));
        checkButton.addActionListener(this);

        buttonsPanel.add(backButton);
        buttonsPanel.add(skipButton);
        buttonsPanel.add(checkButton);

        add(scroll);
        add(currentWord, currentWordConstraint);
        add(answerArea, answerAreaConstraint);
        add(progressBar, progressConstraint);
        add(buttonsPanel, buttonsPanelConstraint);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        progress++;

        if (e.getActionCommand().equals("Back")) {
            this.dispose();
            new DifficultySelection(user);
        }

        if (e.getActionCommand().equals("Check") || e.getActionCommand().equals("Skip")) {

            if (correctWord.equalsIgnoreCase(answerArea.getText())) {
                history.append(answerArea.getText() + " :correct" + " \n\n");
                score++;
            } else {
                history.append(answerArea.getText() + " :wrong" + " \n\n");
            }
            resultHistory.add(answerArea.getText());
            resultHistory.add(correctWord);

            correctWord = words.get(random.nextInt(words.size() - 1));
            scrambledWord = getScrambledWords(correctWord);
            currentWord.setText(scrambledWord);
            answerArea.setText("");
        }

        progressBar.setValue(progress);
        if (progress >= 10) {
            long millis = System.currentTimeMillis();   
            java.util.Date date = new java.util.Date(millis);      
            String currentDate = date.toString();
            accountRepository.savaUserHistory(user, score, currentDate);
            dispose();
            new GameResult(user, score, resultHistory, level);
        }
    }
}

package frames;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import static java.lang.Thread.sleep;

public class Game extends JFrame implements ActionListener {

    private JScrollPane scroll;
    private JTextArea history;
    private JTextField answerArea;
    private JLabel currentWord;
    private JPanel buttonsPanel;
    private JProgressBar progressBar;
    private JButton skipButton, checkButton;
    private int progress = 0;

    public Game() {

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());

        history = new JTextArea(10, 36);
        history.setEditable(false);

        scroll = new JScrollPane(history, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        currentWord = new JLabel("a c b r m e s l d");
        currentWord.setFont(new Font("Arial", Font.BOLD, 30));
        currentWord.setPreferredSize(new Dimension(400, 50));
        currentWord.setHorizontalAlignment(JLabel.LEFT);
        GridBagConstraints currentWordConstraint = new GridBagConstraints();
        currentWordConstraint.gridx = 0;
        currentWordConstraint.gridy = 1;

        answerArea = new JTextField();
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

        skipButton = new JButton("Skip");
        skipButton.setPreferredSize(new Dimension(100, 30));
        skipButton.addActionListener(this);

        checkButton = new JButton("Check");
        checkButton.setPreferredSize(new Dimension(100, 30));
        checkButton.addActionListener(this);

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

        if (e.getActionCommand().equals("Skip")) {
            history.append(currentWord.getText() + "\n\n");
        }

        if (e.getActionCommand().equals("Check")) {
            history.append(currentWord.getText() + "\n\n");
        }

        progressBar.setValue(progress);
        if (progress >= 10) {
            dispose();
            new GameResult();
        }
    }
}

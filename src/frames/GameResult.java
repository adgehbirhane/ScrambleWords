package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameResult extends JFrame implements ActionListener {

    private JLabel score;
    private JTextField metrics;
    private JPanel buttonsPanel;
    private JButton exitButton, replayButton;

    public GameResult() {
        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());

        score = new JLabel("9/10");
        score.setFont(new Font("Arial", Font.BOLD, 80));
        GridBagConstraints scoreConstraints = new GridBagConstraints();
        scoreConstraints.gridx = 0;
        scoreConstraints.gridy = 0;

        metrics = new JTextField();
        metrics.setEditable(false);
        metrics.setPreferredSize(new Dimension(400, 100));
        GridBagConstraints metricsAreaConstraint = new GridBagConstraints();
        metricsAreaConstraint.gridx = 0;
        metricsAreaConstraint.gridy = 1;

        buttonsPanel = new JPanel();
        GridBagConstraints buttonsPanelConstraint = new GridBagConstraints();
        buttonsPanelConstraint.gridx = 0;
        buttonsPanelConstraint.gridy = 2;
        buttonsPanelConstraint.insets = new Insets(50, 0, 0, 0);

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(100, 30));
        exitButton.addActionListener(this);

        replayButton = new JButton("Replay");
        replayButton.setPreferredSize(new Dimension(100, 30));
        replayButton.addActionListener(this);

        buttonsPanel.add(exitButton);
        buttonsPanel.add(replayButton);

        add(score, scoreConstraints);
        add(metrics, metricsAreaConstraint);
        add(buttonsPanel, buttonsPanelConstraint);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            dispose();
        }
        if (e.getActionCommand().equals("Replay")) {
            dispose();
            new Game();
        }
    }
}

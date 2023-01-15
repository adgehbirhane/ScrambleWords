package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultySelection extends JFrame implements ActionListener {

    private JComboBox<String> difficultyComboBox;
    private JButton continueButton, backButton;
    private JLabel level1JLabel, level2JLabel, level3JLabel, level4JLabel, level5JLabel, level6JLabel, level7JLabel,
            level8JLabel, level9JLabel, level10JLabel;

    private JLabel username, pageTitle, levelLabels[] = new JLabel[10];
    private JPanel headerPanel, levelPanel, actionButtonPanel, levelSelectionPanel;

    public DifficultySelection(String user) {

        setTitle("Guess the Scrambled Word");
        setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("asset/logo.png");
        setIconImage(image.getImage());

        headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(Color.LIGHT_GRAY);

        username = new JLabel(user);
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        username.setHorizontalAlignment(JLabel.RIGHT);
        headerPanel.add(username, BorderLayout.WEST);

        levelSelectionPanel = new JPanel();
        levelSelectionPanel.setLayout(new GridBagLayout());

        // These are difficulties of the game.
        difficultyComboBox = new JComboBox<String>();
        difficultyComboBox.addItem("Easy");
        difficultyComboBox.addItem("Moderate");
        difficultyComboBox.addItem("Hard");
        difficultyComboBox.addItem("Extreme");
        difficultyComboBox.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints difficultyComboBoxConstraint = new GridBagConstraints();
        difficultyComboBoxConstraint.gridx = 0;
        difficultyComboBoxConstraint.gridy = 0;
        difficultyComboBoxConstraint.insets = new Insets(0, 0, 10, 0);

        levelPanel = new JPanel();
        levelPanel.setLayout(new FlowLayout());
        levelPanel.setBackground(new Color(150, 140, 140));
        levelPanel.setPreferredSize(new Dimension(400, 100));
        GridBagConstraints levelConstraint = new GridBagConstraints();
        levelConstraint.gridx = 0;
        levelConstraint.gridy = 1;

        level1JLabel = new JLabel("1");
        level2JLabel = new JLabel("2");
        level3JLabel = new JLabel("3");
        level4JLabel = new JLabel("4");
        level5JLabel = new JLabel("5");
        level6JLabel = new JLabel("6");
        level7JLabel = new JLabel("7");
        level8JLabel = new JLabel("8");
        level9JLabel = new JLabel("9");
        level10JLabel = new JLabel(user);

        levelLabels[0] = level1JLabel;
        levelLabels[1] = level2JLabel;
        levelLabels[2] = level3JLabel;
        levelLabels[3] = level4JLabel;
        levelLabels[4] = level5JLabel;
        levelLabels[5] = level6JLabel;
        levelLabels[6] = level7JLabel;
        levelLabels[7] = level8JLabel;
        levelLabels[8] = level9JLabel;
        levelLabels[9] = level10JLabel;

        for (JLabel label : levelLabels) {
            label.setBackground(Color.pink);
            label.setForeground(Color.white);
            label.setFont(new Font("Dialog", Font.BOLD, 20));
            label.setPreferredSize(new Dimension(30, 30));
        }

        levelPanel.add(level1JLabel);
        levelPanel.add(level2JLabel);
        levelPanel.add(level3JLabel);
        levelPanel.add(level4JLabel);
        levelPanel.add(level5JLabel);
        levelPanel.add(level6JLabel);
        levelPanel.add(level7JLabel);
        levelPanel.add(level8JLabel);
        levelPanel.add(level9JLabel);
        levelPanel.add(level10JLabel);

        levelSelectionPanel.add(difficultyComboBox, difficultyComboBoxConstraint);
        levelSelectionPanel.add(levelPanel, levelConstraint);

        actionButtonPanel = new JPanel();
        actionButtonPanel.setBorder(new EmptyBorder(0, 0, 25, 0));

        backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.setBackground(new Color(60, 20, 20));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.addActionListener(this);

        continueButton = new JButton("PLAY");
        continueButton.setPreferredSize(new Dimension(200, 50));
        continueButton.setBackground(new Color(20, 60, 20));
        continueButton.setFont(new Font("Arial", Font.PLAIN, 20));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusable(false);
        continueButton.setBorder(null);
        continueButton.addActionListener(this);

        actionButtonPanel.add(backButton);
        actionButtonPanel.add(continueButton);

        add(headerPanel, BorderLayout.NORTH);
        add(levelSelectionPanel, BorderLayout.CENTER);
        add(actionButtonPanel, BorderLayout.SOUTH);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BACK")) {
            this.dispose();
            new Home();
        }

        if (e.getActionCommand().equals("PLAY")) {
             this.dispose();
             new Game();
        }
    }
}

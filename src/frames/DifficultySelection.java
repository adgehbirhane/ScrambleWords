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

    private JLabel username, levelLabels[] = new JLabel[10];
    private JPanel headerPanel, levelPanel, actionButtonPanel, levelSelectionPanel;
    private String user;

    public DifficultySelection(String user) {
        this.user = user;

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
        difficultyComboBox.addItem("Fantastic");
        difficultyComboBox.setPreferredSize(new Dimension(400, 40));
        difficultyComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints difficultyComboBoxConstraint = new GridBagConstraints();
        difficultyComboBoxConstraint.gridx = 0;
        difficultyComboBoxConstraint.gridy = 0;
        difficultyComboBoxConstraint.insets = new Insets(0, 0, 10, 0);

        levelSelectionPanel.add(difficultyComboBox, difficultyComboBoxConstraint);

        actionButtonPanel = new JPanel();
        actionButtonPanel.setBorder(new EmptyBorder(0, 0, 25, 0));

        backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.setBackground(new Color(192, 57, 43));
        backButton.setForeground(new Color(236, 240, 241));
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.addActionListener(this);

        continueButton = new JButton("PLAY");
        continueButton.setPreferredSize(new Dimension(200, 50));
        continueButton.setBackground(new Color(52, 152, 219));
        continueButton.setFont(new Font("Arial", Font.PLAIN, 20));
        continueButton.setForeground(new Color(236, 240, 241));
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
            int level = 1;
            if(difficultyComboBox.getSelectedItem().equals("Moderate")){ 
                level = 2;
            }else if(difficultyComboBox.getSelectedItem().equals("Hard")){ 
                level = 3;
            }else if(difficultyComboBox.getSelectedItem().equals("Extreme")){ 
                level = 4;
            }else if(difficultyComboBox.getSelectedItem().equals("Fantastic")){ 
                level = 5;
            } 
            this.dispose();
            new Game(user, level); 
        }
    }
}

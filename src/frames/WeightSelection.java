package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightSelection extends JFrame implements ActionListener { 
    private JLabel banner;
    private JComboBox<String> usernameComboBox;
    private JButton continueButton;

    private JRadioButton level1JRadioButton;
    private JRadioButton level2JRadioButton;
    private JRadioButton level3JRadioButton;
    private JRadioButton level4JRadioButton;
    private JRadioButton level5JRadioButton;
    private JRadioButton level6JRadioButton; 
    private JRadioButton level7JRadioButton; 
    private JRadioButton level8JRadioButton; 
    private JRadioButton level9JRadioButton; 
    private JRadioButton level10JRadioButton; 


    private JPanel levelPanel;


    public WeightSelection() {

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout()); 

        banner = new JLabel("Guess the Scrambled Word");
        banner.setFont(new Font("Ariel", Font.BOLD, 40));
        GridBagConstraints bannerConstraint = new GridBagConstraints();
        bannerConstraint.gridx = 0;
        bannerConstraint.gridy = 0;
        bannerConstraint.insets = new Insets(0, 0, 50, 0);

        // This are hardness of the game. 
        usernameComboBox = new JComboBox<String>(); 
            usernameComboBox.addItem("Easy");
            usernameComboBox.addItem("Moderate");
            usernameComboBox.addItem("Hard"); 
            usernameComboBox.addItem("Extreme"); 

        usernameComboBox.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints usernameConstraint = new GridBagConstraints();
        usernameConstraint.gridx = 0;
        usernameConstraint.gridy = 1;
        usernameConstraint.insets = new Insets(0, 0, 10, 0);


        levelPanel = new JPanel();  // This panel will contains all graphical symbol for levels. 
        levelPanel.setLayout(new GridBagLayout()); 
        levelPanel.setPreferredSize(new Dimension(400,300));
        GridBagConstraints levelConstraint = new GridBagConstraints();
        levelConstraint.gridx = 0;
        levelConstraint.gridy = 2;


        level1JRadioButton = new JRadioButton("1"); 
        GridBagConstraints level1Constraint = new GridBagConstraints();
        level1Constraint.gridx = 0;
        level1Constraint.gridy = 0; 

        level2JRadioButton = new JRadioButton("2"); 
        GridBagConstraints level2Constraint = new GridBagConstraints();
        level2Constraint.gridx = 1;
        level2Constraint.gridy = 0; 

        level3JRadioButton = new JRadioButton("3"); 
        GridBagConstraints level3Constraint = new GridBagConstraints();
        level3Constraint.gridx = 2;
        level3Constraint.gridy = 0; 

        level4JRadioButton = new JRadioButton("4"); 
        GridBagConstraints level4Constraint = new GridBagConstraints();
        level4Constraint.gridx = 3;
        level4Constraint.gridy = 0; 

        level5JRadioButton = new JRadioButton("5"); 
        GridBagConstraints level5Constraint = new GridBagConstraints();
        level5Constraint.gridx = 4;
        level5Constraint.gridy = 0; 

        level6JRadioButton = new JRadioButton("6"); 
        GridBagConstraints level6Constraint = new GridBagConstraints();
        level6Constraint.gridx = 0;
        level6Constraint.gridy = 1; 
 
        level7JRadioButton = new JRadioButton("7"); 
        GridBagConstraints level7Constraint = new GridBagConstraints();
        level7Constraint.gridx = 1;
        level7Constraint.gridy = 1; 

        level8JRadioButton = new JRadioButton("8"); 
        GridBagConstraints level8Constraint = new GridBagConstraints();
        level8Constraint.gridx = 2;
        level8Constraint.gridy = 1; 

        level9JRadioButton = new JRadioButton("9");
        GridBagConstraints level9Constraint = new GridBagConstraints();
        level9Constraint.gridx = 3;
        level9Constraint.gridy =1;

        level10JRadioButton = new JRadioButton("10");
        GridBagConstraints level10Constraint = new GridBagConstraints();
        level10Constraint.gridx = 4;
        level10Constraint.gridy =1;


        continueButton = new JButton("Next");
        continueButton.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 0;
        continueConstraint.gridy = 3; 

        add(banner, bannerConstraint);
        add(usernameComboBox, usernameConstraint);

        add(levelPanel,levelConstraint);
        levelPanel.add(level1JRadioButton,level1Constraint);
        levelPanel.add(level2JRadioButton,level2Constraint);
        levelPanel.add(level3JRadioButton,level3Constraint);
        levelPanel.add(level4JRadioButton,level4Constraint);
        levelPanel.add(level5JRadioButton,level5Constraint);
        levelPanel.add(level6JRadioButton,level6Constraint);
        levelPanel.add(level7JRadioButton,level7Constraint);
        levelPanel.add(level8JRadioButton,level8Constraint);
        levelPanel.add(level9JRadioButton,level9Constraint);
        levelPanel.add(level10JRadioButton,level10Constraint);
        
        add(continueButton, continueConstraint);

        setSize(1500, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
 
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}

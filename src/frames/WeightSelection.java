package frames;

import javax.swing.*;
// import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightSelection extends JFrame implements ActionListener { 

    private JLabel banner;  // we use for header
    private JComboBox<String> usernameComboBox; // we use to choose hardness of the game.
    private JButton continueButton;  // we use to go forward.
    private JButton backButton;  // we use to go backward.


// All of this Radio buttons are the graphical sub-level chooses of the game.
    private JLabel level1JLabel;
    private JLabel level2JLabel;
    private JLabel level3JLabel;
    private JLabel level4JLabel;
    private JLabel level5JLabel;
    private JLabel level6JLabel; 
    private JLabel level7JLabel; 
    private JLabel level8JLabel; 
    private JLabel level9JLabel; 
    private JLabel level10JLabel; 

// for the container of the above sub-level chooses.
    private JPanel levelPanel;    

// constractor
    /**
     * 
     */
    public WeightSelection() {

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout()); 

        // border = BorderFactory.createLineBorder(Color.green,3);
        // setBorder(border);
        // setContentPane(new JLabel(new ImageIcon("C:\\Users\\Administrator\\Pictures\\bg.png")));
        //  

        banner = new JLabel("Guess the Scrambled Word");
        banner.setFont(new Font("Serif",Font.PLAIN, 40));
        GridBagConstraints bannerConstraint = new GridBagConstraints();
        bannerConstraint.gridx = 0;
        bannerConstraint.gridy = 0;
        bannerConstraint.insets = new Insets(0, 100, 50, 0);

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
        usernameConstraint.insets = new Insets(0, 100, 10, 0);

// for the container of the above sub-level chooses.
        levelPanel = new JPanel();  
        levelPanel.setLayout(new GridBagLayout()); 
        levelPanel.setPreferredSize(new Dimension(500,150));
        levelPanel.setBackground(new Color(150, 140, 140));
        GridBagConstraints levelConstraint = new GridBagConstraints();
        levelConstraint.gridx = 0;
        levelConstraint.gridy = 2;
        levelConstraint.insets = new Insets(50, 500, 10, 0);
         
        level1JLabel = new JLabel("1"); 
        level1JLabel.setBackground(Color.pink);
        level1JLabel.setForeground(Color.white);
        level1JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level1JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level1Constraint = new GridBagConstraints();
        level1Constraint.gridx = 0;
        level1Constraint.gridy = 0; 
        level1Constraint.insets = new Insets(0, 0, 10, 50);
        
        level2JLabel = new JLabel("2"); 
        level2JLabel.setBackground(Color.pink);
        level2JLabel.setForeground(Color.white);
        level2JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level2JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level2Constraint = new GridBagConstraints();
        level2Constraint.gridx = 1;
        level2Constraint.gridy = 0; 
        level2Constraint.insets = new Insets(0, 0, 10, 50);

        level3JLabel = new JLabel("3"); 
        level3JLabel.setBackground(Color.pink);
        level3JLabel.setForeground(Color.white);
        level3JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level3JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level3Constraint = new GridBagConstraints();
        level3Constraint.gridx = 2;
        level3Constraint.gridy = 0; 
        level3Constraint.insets = new Insets(0, 0, 10, 50);
        
        level4JLabel = new JLabel("4"); 
        level4JLabel.setBackground(Color.pink);
        level4JLabel.setForeground(Color.white);
        level4JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level4JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level4Constraint = new GridBagConstraints();
        level4Constraint.gridx = 3;
        level4Constraint.gridy = 0; 
        level4Constraint.insets = new Insets(0, 0, 10, 50);

        level5JLabel = new JLabel("5"); 
        level5JLabel.setBackground(Color.pink);
        level5JLabel.setForeground(Color.white);
        level5JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level5JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level5Constraint = new GridBagConstraints();
        level5Constraint.gridx = 4;
        level5Constraint.gridy = 0; 
        level5Constraint.insets = new Insets(0, 0, 10, 50);
        
        level6JLabel = new JLabel("6");
        level6JLabel.setBackground(Color.pink);
        level6JLabel.setForeground(Color.white);
        level6JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level6JLabel.setPreferredSize(new Dimension(30,30)); 
        GridBagConstraints level6Constraint = new GridBagConstraints();
        level6Constraint.gridx = 0;
        level6Constraint.gridy = 1; 
        level6Constraint.insets = new Insets(0, 0, 10, 50);
        
        level7JLabel = new JLabel("7"); 
        level7JLabel.setBackground(Color.pink);
        level7JLabel.setForeground(Color.white);
        level7JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level7JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level7Constraint = new GridBagConstraints();
        level7Constraint.gridx = 1;
        level7Constraint.gridy = 1; 
        level7Constraint.insets = new Insets(0, 0, 10, 50);
        
        level8JLabel = new JLabel("8"); 
        level8JLabel.setBackground(Color.pink);
        level8JLabel.setForeground(Color.white);
        level8JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level8JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level8Constraint = new GridBagConstraints();
        level8Constraint.gridx = 2;
        level8Constraint.gridy = 1; 
        level8Constraint.insets = new Insets(0, 0, 10, 50);
        
        level9JLabel = new JLabel("9");
        level9JLabel.setBackground(Color.pink);
        level9JLabel.setForeground(Color.white);
        level9JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level9JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level9Constraint = new GridBagConstraints();
        level9Constraint.gridx = 3;
        level9Constraint.gridy =1;
        level9Constraint.insets = new Insets(0, 0, 10, 50);
        
        level10JLabel = new JLabel("10");
        level10JLabel.setBackground(Color.pink);
        level10JLabel.setForeground(Color.white);
        level10JLabel.setFont(new Font("Dialog",Font.BOLD, 20));
        level10JLabel.setPreferredSize(new Dimension(30,30));
        GridBagConstraints level10Constraint = new GridBagConstraints();
        level10Constraint.gridx = 4;
        level10Constraint.gridy =1;
        level10Constraint.insets = new Insets(0, 0, 10, 50);

        
        backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(200, 30));
        backButton.setBackground(new Color(60, 20, 20));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(new Font("Serif",Font.PLAIN, 20));
        backButton.addActionListener(this);
        GridBagConstraints backConstraint = new GridBagConstraints();
        backConstraint.gridx = 0;
        backConstraint.gridy = 6;
        backConstraint.insets = new Insets(50, 0, 0, 0); 
        
        continueButton = new JButton("NEXT");
        continueButton.setPreferredSize(new Dimension(200, 30));
        continueButton.setBackground(new Color(20, 60, 20));
        continueButton.setFont(new Font("Serif",Font.PLAIN,20));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusable(false);
        GridBagConstraints continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 1;
        continueConstraint.gridy = 6; 
        continueConstraint.insets = new Insets(50, 0, 0, 100); 

        add(banner, bannerConstraint);
        add(usernameComboBox, usernameConstraint);

        add(levelPanel,levelConstraint);
            levelPanel.add(level1JLabel,level1Constraint);
            levelPanel.add(level2JLabel,level2Constraint);
            levelPanel.add(level3JLabel,level3Constraint);
            levelPanel.add(level4JLabel,level4Constraint);
            levelPanel.add(level5JLabel,level5Constraint);
            levelPanel.add(level6JLabel,level6Constraint);
            levelPanel.add(level7JLabel,level7Constraint);
            levelPanel.add(level8JLabel,level8Constraint);
            levelPanel.add(level9JLabel,level9Constraint);
            levelPanel.add(level10JLabel,level10Constraint);
        
        add(continueButton, continueConstraint);
        add(backButton, backConstraint);

        setSize(1500, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
 
    } 

    @Override
    public void actionPerformed(ActionEvent e) { 

        if(e.getActionCommand().equals("BACK")){
            this.dispose();
            new Home();
        }

        if(e.getActionCommand().equals("NEXT")){
            // this.dispose();
            // new Game();
        }
    }
}

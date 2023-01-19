package frames;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener {

  private JLabel banner,question1,question2,question3;
  private JButton skipButton,checkButton;
  private JTextArea ansewArea;
  private JPanel header,footer;

  public Game() {

    setTitle("Guess the Scrambled Word");
    setLayout(new GridBagLayout());

    // create header panel
    // Border blackline = BorderFactory.createLineBorder(Color.black);
    header = new JPanel();
    header.setLayout(new GridBagLayout());
    header.setPreferredSize(new Dimension(200, 150));
    // header.setBorder(blackline);
    GridBagConstraints headerConstraint = new GridBagConstraints();
    headerConstraint.gridx = 0;
    headerConstraint.gridy = 0;
    headerConstraint.insets = new Insets(0, 600, 200, 0);

          // add labels to header
          question1 = new JLabel("carpenter");
          question1.setFont(new Font("Ariel", Font.BOLD, 20));
          GridBagConstraints question1Constraint = new GridBagConstraints();
          question1Constraint.gridx = 0;
          question1Constraint.gridy = 3;
          question1Constraint.insets = new Insets(0, 0, 10, 0);

          question2 = new JLabel("business");
          question2.setFont(new Font("Ariel", Font.BOLD, 20));
          GridBagConstraints question2Constraint = new GridBagConstraints();
          question2Constraint.gridx = 0;
          question2Constraint.gridy = 5;
          question2Constraint.insets = new Insets(0, 0, 10, 0);

          question3 = new JLabel("accomodation");
          question3.setFont(new Font("Ariel", Font.BOLD, 20));
          GridBagConstraints question3Constraint = new GridBagConstraints();
          question3Constraint.gridx = 0;
          question3Constraint.gridy = 7;
          question3Constraint.insets = new Insets(0, 0, 10, 0);



    banner = new JLabel("a c b r m e s l d");
    banner.setFont(new Font("Ariel", Font.BOLD, 20));
    GridBagConstraints bannerConstraint = new GridBagConstraints();
    bannerConstraint.gridx = 0;
    bannerConstraint.gridy = 0;
    bannerConstraint.insets = new Insets(300, 500, 0, 200);


    // usernameComboBox = new JComboBox<>();
    // usernameComboBox.setPreferredSize(new Dimension(400, 30));
    // GridBagConstraints usernameConstraint = new GridBagConstraints();
    // usernameConstraint.gridx = 0;
    // usernameConstraint.gridy = 1;
    // usernameConstraint.insets = new Insets(0, 0, 10, 0);

    ansewArea = new JTextArea();
    ansewArea.setPreferredSize(new Dimension(400, 150));
    GridBagConstraints answerAreaConstraint = new GridBagConstraints();
    answerAreaConstraint.gridx = 0;
    answerAreaConstraint.gridy = 1;
    answerAreaConstraint.insets = new Insets(0, 500, 10, 50);

    skipButton = new JButton("Skip");
    skipButton.setPreferredSize(new Dimension(100, 30));
    GridBagConstraints skipConstraint = new GridBagConstraints();
    skipConstraint.gridx = 0;
    skipConstraint.gridy = 2;
    skipButton.addActionListener(this);

    checkButton = new JButton("Check");
    checkButton.setPreferredSize(new Dimension(100, 30));
    GridBagConstraints checkConstraint = new GridBagConstraints();
    checkConstraint.gridx = 1;
    checkConstraint.gridy = 2;
    checkButton.addActionListener(this);

    add(header, headerConstraint);
      header.add(question1,question1Constraint);
      header.add(question2,question2Constraint);
      header.add(question3,question3Constraint);
    add(banner, bannerConstraint);
    add(ansewArea, answerAreaConstraint);
    add(skipButton, skipConstraint);
    add(checkButton, checkConstraint);
    

    setSize(1500, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) { 
    
    // if (e.getActionCommand().equals("Check")) {
    //   this.dispose();
    //   new WeightSelection();
    // }

  }
}

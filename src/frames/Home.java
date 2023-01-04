package frames;

import javax.swing.*;
import java.awt.*;        
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    private JLabel banner;
    private JComboBox<String> usernameComboBox;
    private JButton continueButton;

    public Home() {

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());

        banner = new JLabel("Guess the Scrambled Word");
        banner.setFont(new Font("Ariel", Font.BOLD, 40));
        GridBagConstraints bannerConstraint = new GridBagConstraints();
        bannerConstraint.gridx = 0;
        bannerConstraint.gridy = 0;
        bannerConstraint.insets = new Insets(0, 0, 50, 0);

        usernameComboBox = new JComboBox<>();
        usernameComboBox.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints usernameConstraint = new GridBagConstraints();
        usernameConstraint.gridx = 0;
        usernameConstraint.gridy = 1;
        usernameConstraint.insets = new Insets(0, 0, 10, 0);

        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 0;
        continueConstraint.gridy = 2;
        continueButton.addActionListener(this);

        add(banner, bannerConstraint);
        add(usernameComboBox, usernameConstraint);
        add(continueButton, continueConstraint);

        setSize(1500, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("Continue")){
            this.dispose();
            new WeightSelection();
        }
        
    }
}

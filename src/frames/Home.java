package frames;

import javax.swing.*; 

import repository.AccountRepository;
import module.Account;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Home extends JFrame implements ActionListener {

    private JLabel banner, banner2;
    private JComboBox<String> usernameComboBox;
    private JButton continueButton;
    private JButton newUserButton; // it forwards to the registration page.
    private ArrayList<String> usersList;
    private AccountRepository accountRepository;

    public Home() {

        setTitle("Guess the Scrambled Word");
        setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("logo.png");
        setIconImage(image.getImage());

        JLabel background=new JLabel(new ImageIcon("bg.png"));
        background.setLayout(new FlowLayout());
        add(background,BorderLayout.NORTH); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); 
        panel.setOpaque(false);  
        background.add(panel,BorderLayout.CENTER);
        
        banner = new JLabel("Guess to Correct");
        banner.setForeground(Color.green);
        banner.setFont(new Font("Ariel", Font.BOLD, 80));
        GridBagConstraints bannerConstraint = new GridBagConstraints();
        bannerConstraint.gridx = 0;
        bannerConstraint.gridy = 0;
        bannerConstraint.insets = new Insets(0, 0, 50, 0);

        banner2 = new JLabel(" the SCRAMBLED WORD");
        banner2.setForeground(Color.green);
        banner2.setFont(new Font("Ariel", Font.BOLD, 50));
        GridBagConstraints banner2Constraint = new GridBagConstraints();
        banner2Constraint.gridx = 0;
        banner2Constraint.gridy = 1;
        banner2Constraint.insets = new Insets(0, 0, 50, 0);

        accountRepository = new AccountRepository();
        usersList = accountRepository.getUsername();
        usernameComboBox = new JComboBox<String>();
        for(String singleUser: usersList){
            usernameComboBox.addItem(singleUser);
        }

        usernameComboBox.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints usernameConstraint = new GridBagConstraints();
        usernameConstraint.gridx = 0;
        usernameConstraint.gridy = 2;
        usernameConstraint.insets = new Insets(0, 0, 10, 0);
        
        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 30)); 
        continueButton.setBackground(Color.GRAY);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusable(false);
        continueButton.setFont(new Font("Arial", Font.PLAIN, 20));
        continueButton.setBorder(null);
        continueButton.addActionListener(this);
        GridBagConstraints continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 0;
        continueConstraint.gridy = 3;
        
        newUserButton = new JButton("new account");
        newUserButton.setPreferredSize(new Dimension(200, 30));
        newUserButton.setBackground(new Color(0xDAD3D3));
        newUserButton.setBorder(null);
        newUserButton.setFocusable(false);
        newUserButton.addActionListener(this);
        GridBagConstraints newUserConstraint = new GridBagConstraints();
        newUserConstraint.gridx = 0;
        newUserConstraint.gridy = 4;
        newUserConstraint.insets = new Insets(20, 200, 0, 0);

        panel.add(banner, bannerConstraint);
        panel.add(banner2, banner2Constraint);
        panel.add(usernameComboBox, usernameConstraint);
        panel.add(continueButton, continueConstraint);
        panel.add(newUserButton, newUserConstraint);

        setSize(1000, 600);
        // setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e) { 
        
        if(e.getActionCommand().equals("Continue")){
            Account account = new Account();
            AccountRepository accountRepository = new AccountRepository();
            account.setUsername((String)usernameComboBox.getSelectedItem()); 

            this.dispose();
            String user = account.getUsername();
            String fullName = accountRepository.getFullName(user);
            new WeightSelection(fullName);
        }
        if(e.getActionCommand().equals("new account")){
            this.dispose();
            new Registration();
        }
         
    }
}

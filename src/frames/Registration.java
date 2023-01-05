package frames;

import javax.swing.*;

import module.Account;
import repository.AccountRepository;

import java.awt.*;        
import java.awt.event.*;

public class Registration extends JFrame implements ActionListener{

    private JLabel banner;
    private JLabel fullNameJLabel;
    private JLabel emailJLabel;
    private JLabel usernameJLabel;
    
    private JTextField fullNameTextField;
    private JTextField emailTextField;
    private JTextField usernameTextField; 
    private JButton continueButton;
    private JButton cancelButton;

    private GridBagConstraints bannerConstraint;
    private GridBagConstraints fullNameTConstraint;
    private GridBagConstraints fullNameLConstraint;
    private GridBagConstraints emailLConstraint;
    private GridBagConstraints emailTConstraint;
    private GridBagConstraints usernameLConstraint;
    private GridBagConstraints usernameTConstraint;
    private GridBagConstraints continueConstraint;
    private GridBagConstraints cancelConstraint;

    private Account account;
    private AccountRepository accountRepository;

    public Registration() {

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());

        banner = new JLabel("Guess the Scrambled Word");
        banner.setFont(new Font("Ariel", Font.BOLD, 40));
        bannerConstraint = new GridBagConstraints();
        bannerConstraint.gridx = 0;
        bannerConstraint.gridy = 0;
        bannerConstraint.insets = new Insets(0, 0, 50, 0);

        fullNameJLabel = new JLabel("Full Name*");
        fullNameJLabel.setPreferredSize(new Dimension(400, 40));
        fullNameLConstraint = new GridBagConstraints();
        fullNameLConstraint.gridx = 0;
        fullNameLConstraint.gridy = 1;
        fullNameLConstraint.insets = new Insets(10, 0, 0, 0);

        fullNameTextField = new JTextField();
        fullNameTextField.setPreferredSize(new Dimension(400, 40));
        fullNameTConstraint = new GridBagConstraints();
        fullNameTConstraint.gridx = 0;
        fullNameTConstraint.gridy = 2;
        fullNameTConstraint.insets = new Insets(0, 0, 10, 0);

        emailJLabel = new JLabel("Email*");
        emailJLabel.setPreferredSize(new Dimension(400, 40));
        emailLConstraint = new GridBagConstraints();
        emailLConstraint.gridx = 0;
        emailLConstraint.gridy = 3;
        emailLConstraint.insets = new Insets(10, 0, 0, 0);

        emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(400, 40));
        emailTConstraint = new GridBagConstraints();
        emailTConstraint.gridx = 0;
        emailTConstraint.gridy = 4;
        emailTConstraint.insets = new Insets(0, 0, 10, 0);

        usernameJLabel = new JLabel("username*");
        usernameJLabel.setPreferredSize(new Dimension(400, 40));
        usernameLConstraint = new GridBagConstraints();
        usernameLConstraint.gridx = 0;
        usernameLConstraint.gridy = 5;
        usernameLConstraint.insets = new Insets(10, 0, 0, 0);

        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(400, 40));
        usernameTConstraint = new GridBagConstraints();
        usernameTConstraint.gridx = 0;
        usernameTConstraint.gridy = 6;
        usernameTConstraint.insets = new Insets(0, 0, 10, 0);
        
        
        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 30));
        continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 0;
        continueConstraint.gridy = 7;
        continueConstraint.insets = new Insets(20, 0, 0, 0);
        continueButton.addActionListener(this);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(400, 30));
        cancelButton.setBackground(Color.red);
        cancelButton.setFocusable(false);
        cancelConstraint = new GridBagConstraints();
        cancelConstraint.gridx = 0;
        cancelConstraint.gridy = 8;
        cancelConstraint.insets = new Insets(20, 0, 0, 0);
        cancelButton.addActionListener(this);

        add(banner, bannerConstraint);

        add(fullNameTextField, fullNameTConstraint);
        add(fullNameJLabel, fullNameLConstraint);

        add(emailJLabel, emailLConstraint);
        add(emailTextField, emailTConstraint);

        add(usernameJLabel, usernameLConstraint);
        add(usernameTextField, usernameTConstraint);
        
        add(continueButton, continueConstraint);
        add(continueButton, continueConstraint);
        
        add(cancelButton, cancelConstraint);
        add(cancelButton, cancelConstraint);

        setSize(1500, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent e) { 
        
        if(e.getActionCommand().equals("Continue")){

            account = new Account();
            accountRepository = new AccountRepository();

            try{ 
                account.setFull_name(fullNameTextField.getText());
                account.setEmail(emailTextField.getText());
                account.setUsername(usernameTextField.getText());
                if(!fullNameTextField.getText().equals("") && !emailTextField.getText().equals("") && !usernameTextField.getText().equals("") ){
                    accountRepository.save(account); 
                    this.dispose();
                    new Home();
                }else{
                    JOptionPane.showMessageDialog(null,"To continue you have to fill all required space","fill the required info.",2);
                }
            } catch (Exception r) { 
                JOptionPane.showMessageDialog(null,r,"fill the required info.",2);
            }
        } 
        if(e.getActionCommand().equals("Cancel")){
            this.dispose();
            new Home();
        }
    }
}


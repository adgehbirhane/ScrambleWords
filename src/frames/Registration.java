package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import module.Account;
import repository.AccountRepository;

import java.awt.*;        
import java.awt.event.*;

public class Registration extends JFrame implements ActionListener{

    private JLabel pageTitle, fullNameJLabel, emailJLabel, usernameJLabel;
    
    private JTextField fullNameTextField, emailTextField, usernameTextField;

    private JButton continueButton, cancelButton;

    private GridBagConstraints fullNameTConstraint, fullNameLConstraint, actionButtonPannelConst,
                               emailLConstraint, emailTConstraint, usernameLConstraint, 
                               usernameTConstraint, continueConstraint, cancelConstraint;
    private Account account;
    private AccountRepository accountRepository;

    private JPanel headerPanel, totalPanel, actionButtonPannel; 

    public Registration() {

        setTitle("Guess the Scrambled Word");
        setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("logo.png");
        setIconImage(image.getImage()); 
        
        headerPanel = new JPanel(); 
        headerPanel.setBackground(new Color(128,128,128)); 
        add(headerPanel, BorderLayout.NORTH);
        
        pageTitle = new JLabel("Guess the Scrambled Word");
        pageTitle.setFont(new Font("Dialog", Font.BOLD, 30)); 
        headerPanel.add(pageTitle, BorderLayout.CENTER);
        
        totalPanel = new JPanel();
        totalPanel.setLayout(new GridBagLayout());
        add(totalPanel); 

        fullNameJLabel = new JLabel("Full Name*");
        fullNameJLabel.setPreferredSize(new Dimension(400, 40));
        fullNameLConstraint = new GridBagConstraints();
        fullNameLConstraint.gridx = 0;
        fullNameLConstraint.gridy = 1;
        fullNameLConstraint.insets = new Insets(10, 0, 0, 0);

        fullNameTextField = new JTextField();
        fullNameTextField.setPreferredSize(new Dimension(400, 40));
        fullNameTextField.setBorder(new EmptyBorder(0, 25, 0, 0));
        fullNameTextField.setBackground(new Color(0xDAD3D3));
        fullNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
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
        emailTextField.setBorder(new EmptyBorder(0,25,0,0));
        emailTextField.setBackground(new Color(0xDAD3D3));
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 20));
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
        usernameTextField.setBackground(new Color(0xDAD3D3));
        usernameTextField.setBorder(new EmptyBorder(0, 25, 0, 0));
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameTConstraint = new GridBagConstraints();
        usernameTConstraint.gridx = 0;
        usernameTConstraint.gridy = 6;
        usernameTConstraint.insets = new Insets(0, 0, 10, 0);
        
        
        actionButtonPannel = new JPanel();
        actionButtonPannel.setBorder(new EmptyBorder(0, 0, 25, 0));
        actionButtonPannelConst = new GridBagConstraints();
        actionButtonPannelConst.gridx = 0;
        actionButtonPannelConst.gridy = 7;
        actionButtonPannelConst.insets = new Insets(50, 0, 0, 0);
        
        
        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(200,50));
        cancelButton.setBackground(new Color(60, 20, 20));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false);
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 20));
        cancelConstraint = new GridBagConstraints();
        cancelConstraint.gridx = 0;
        cancelConstraint.gridy = 0;
        cancelConstraint.insets = new Insets(50, 100, 0, 0);
        cancelButton.addActionListener(this); 
        
        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(200,50));
        continueButton.setBackground(new Color(20, 60, 20));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusable(false);
        continueButton.setFont(new Font("Arial", Font.PLAIN, 20));
        continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 0;
        continueConstraint.gridy = 1;
        continueConstraint.insets = new Insets(50, 100, 0, 0);
        continueButton.addActionListener(this); 
    
        totalPanel.add(fullNameTextField, fullNameTConstraint);
        totalPanel.add(fullNameJLabel, fullNameLConstraint);

        totalPanel.add(emailJLabel, emailLConstraint);
        totalPanel.add(emailTextField, emailTConstraint);

        totalPanel.add(usernameJLabel, usernameLConstraint);
        totalPanel.add(usernameTextField, usernameTConstraint);
        
        
        totalPanel.add(actionButtonPannel, actionButtonPannelConst);
        actionButtonPannel.add(cancelButton, cancelConstraint); 
        actionButtonPannel.add(continueButton, continueConstraint); 

        setSize(1000, 600);
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


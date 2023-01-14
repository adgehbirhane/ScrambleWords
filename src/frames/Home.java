package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import repository.AccountRepository;
import models.Account;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Home extends JFrame implements ActionListener {

    private JLabel banner;
    private JComboBox<String> usernameComboBox;
    private JButton continueButton;
    private ArrayList<String> usersList;
    private AccountRepository accountRepository;

    public Home() {
        accountRepository = new AccountRepository();

        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());

        ImageIcon image = new ImageIcon("asset/logo.png");
        setIconImage(image.getImage());

        banner = new JLabel("Guess the Scrambled Word");
        banner.setFont(new Font("Ariel", Font.BOLD, 40));
        GridBagConstraints bannerConstraint = new GridBagConstraints();
        bannerConstraint.gridx = 0;
        bannerConstraint.gridy = 0;
        bannerConstraint.insets = new Insets(0, 0, 50, 0);

        usersList = accountRepository.getUsername();
        usernameComboBox = new JComboBox<String>();
        usernameComboBox.setEditable(true);

        if (!(usersList.isEmpty() == true))
            for (String singleUser : usersList) {
                usernameComboBox.addItem(singleUser);
            }

        usernameComboBox.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints usernameConstraint = new GridBagConstraints();
        usernameConstraint.gridx = 0;
        usernameConstraint.gridy = 2;
        usernameConstraint.insets = new Insets(0, 0, 10, 0);

        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 30));
        continueButton.setFont(new Font("Arial", Font.PLAIN, 20));
        continueButton.addActionListener(this);
        GridBagConstraints continueConstraint = new GridBagConstraints();
        continueConstraint.gridx = 0;
        continueConstraint.gridy = 3;

        add(banner, bannerConstraint);
        add(usernameComboBox, usernameConstraint);
        add(continueButton, continueConstraint);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Continue")) {
            String username = (String) usernameComboBox.getSelectedItem();
            if (username == null) {
                System.out.println("nullllllllll");
            } else if (usersList.contains(username)) {
                this.dispose();
                new DifficultySelection(username);
            } else {
                Account account = new Account();
                account.setUsername(username);
                accountRepository.save(account);
                this.dispose();
                new DifficultySelection(username);
            }
        }
    }
}

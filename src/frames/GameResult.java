package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections; 

public class GameResult extends JFrame implements ActionListener {

    private JLabel score; 
    private JPanel buttonsPanel, metrics;
    private JButton exitButton, replayButton;
    private int level, bestScore;
    private String user;
    private ArrayList<Integer> myScore;
    private repository.AccountRepository accountRepository; 

    public int getBestScore( ArrayList<Integer> yourScore){
        int max = Collections.max(yourScore);
        return max;
    }
    public GameResult(String user, int result, ArrayList<String> resultHistory, int level) {
        this.user = user;
        this.level = level;
        
        setTitle("Guess the Scrambled Word");
        setLayout(new GridBagLayout());
        
        ImageIcon image = new ImageIcon("asset/logo.png");
        setIconImage(image.getImage());

        accountRepository = new repository.AccountRepository(); 

        myScore = accountRepository.getMyScore(user);
        bestScore = getBestScore(myScore);

        score = new JLabel(Integer.toString(result)+"/10    Best: " + bestScore );
        score.setFont(new Font("Arial", Font.BOLD, 50));
        GridBagConstraints scoreConstraints = new GridBagConstraints();
        scoreConstraints.gridx = 0;
        scoreConstraints.gridy = 0;

        metrics = new JPanel(); 
        metrics.setPreferredSize(new Dimension(400, 200));
        metrics.setFont(new Font("Arial", Font.PLAIN, 20));
        metrics.setLayout(new GridLayout(11,3)); 
        JLabel header1 = new JLabel("Your answer");
        header1.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel header2 = new JLabel("Correct Answer ");
        header2.setFont(new Font("Arial", Font.BOLD, 20));
        // JLabel header3 = new JLabel(" Prious Score");
        // header3.setFont(new Font("Arial", Font.BOLD, 20));

        metrics.add(header1);
        metrics.add(header2);
        // metrics.add(header3);

        // int passer=0, count=0;
        for(int idx=0; idx<resultHistory.size(); idx++) {
            metrics.add(new JLabel(resultHistory.get(idx)));
            // passer++;
            // if(passer == 2){
            //     if(!myScore.isEmpty()){
            //         int value = myScore.get(count).intValue();
            //         String str = Integer.toString(value);
            //         count++;
            //         metrics.add(new JLabel(str));
            //     }else{
            //     metrics.add(new JLabel(""));
            // }
            //     passer = 0;
            // }
        }

        GridBagConstraints metricsAreaConstraint = new GridBagConstraints();
        metricsAreaConstraint.gridx = 0;
        metricsAreaConstraint.gridy = 1;

        buttonsPanel = new JPanel();
        GridBagConstraints buttonsPanelConstraint = new GridBagConstraints();
        buttonsPanelConstraint.gridx = 0;
        buttonsPanelConstraint.gridy = 2;
        buttonsPanelConstraint.insets = new Insets(50, 0, 0, 0);

        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.setPreferredSize(new Dimension(100, 30));
        exitButton.addActionListener(this);

        replayButton = new JButton("Replay");
        replayButton.setFocusable(false);
        replayButton.setPreferredSize(new Dimension(100, 30));
        replayButton.addActionListener(this); 

        buttonsPanel.add(exitButton);
        buttonsPanel.add(replayButton);

        add(score, scoreConstraints);
        add(metrics, metricsAreaConstraint); 
        add(buttonsPanel, buttonsPanelConstraint);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            dispose();
        }
        if (e.getActionCommand().equals("Replay")) {
            dispose();
            new Game(user, level);
        }
    }
}

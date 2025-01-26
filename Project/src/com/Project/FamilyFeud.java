package com.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FamilyFeud 
{
    private JFrame frame;
    private Font customFont;
    private Player[] players = new Player[6];

    public FamilyFeud() 
    {
        loadCustomFont();
        initializeMainScreen();
        //displayTeamDetails();
    }

    private void loadCustomFont() 
    {
        try {
            customFont = Font.createFont(
                Font.TRUETYPE_FONT,
                getClass().getResourceAsStream("/com/Project/MightySouly-lxggD.ttf")
            ).deriveFont(100f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (FontFormatException | IOException | NullPointerException e) {
            System.out.println("Error loading font: " + e.getMessage());
            customFont = new Font("Comic Sans MS", Font.BOLD, 50);
        }
    }

    private void initializeMainScreen() {
        frame = new JFrame("Family Feud");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("FAMILY");
        titleLabel.setFont(customFont);
        titleLabel.setForeground(new Color(30, 144, 255));
        titleLabel.setBounds(61, 48, 300, 85);
        panel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("FEUD");
        subtitleLabel.setFont(customFont);
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setBounds(104, 144, 294, 85);
        panel.add(subtitleLabel);

        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Agency FB", Font.BOLD, 30));
        playButton.setBackground(new Color(30, 144, 255));
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);
        playButton.setBounds(225, 359, 100, 50);

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playButton.setBackground(Color.BLACK);
                playButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                playButton.setBackground(new Color(30, 144, 255));
                playButton.setForeground(Color.WHITE);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToTeamAInterface();
            }
        });

        panel.add(playButton);

        JLabel imageLabel1 = new JLabel();
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/com/Project/Human.png"));
        imageLabel1.setIcon(imageIcon1);
        imageLabel1.setBounds(-31, 276, 258, 468);
        panel.add(imageLabel1);

        JLabel imageLabel2 = new JLabel();
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/com/Project/Question Mark.png"));
        Image img = imageIcon2.getImage();
        Image resizedImg = img.getScaledInstance(160, 110, Image.SCALE_SMOOTH);
        imageLabel2.setIcon(new ImageIcon(resizedImg));
        imageLabel2.setBounds(46, 227, 131, 138);
        panel.add(imageLabel2);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void switchToTeamAInterface() {
        JPanel setupPanel = new JPanel();
        setupPanel.setLayout(null);
        setupPanel.setBackground(Color.WHITE);

        JLabel teamLabel = new JLabel("Team A");
        teamLabel.setFont(customFont.deriveFont(40f));
        teamLabel.setForeground(new Color(30, 144, 255));
        teamLabel.setBounds(127, 34, 157, 84);
        setupPanel.add(teamLabel);

        JTextField player1Field = new JTextField("Player 1");
        player1Field.setForeground(Color.WHITE);
        player1Field.setBounds(20, 150, 100, 47);
        player1Field.setHorizontalAlignment(JTextField.CENTER);
        player1Field.setFont(new Font("Gadugi", Font.BOLD, 14));
        player1Field.setBackground(Color.BLACK);
        setupPanel.add(player1Field);

        JTextField player2Field = new JTextField("Player 2");
        player2Field.setForeground(Color.WHITE);
        player2Field.setBounds(141, 150, 100, 47);
        player2Field.setHorizontalAlignment(JTextField.CENTER);
        player2Field.setFont(new Font("Gadugi", Font.BOLD, 14));
        player2Field.setBackground(Color.BLACK);
        setupPanel.add(player2Field);

        JTextField player3Field = new JTextField("Player 3");
        player3Field.setForeground(Color.WHITE);
        player3Field.setBounds(262, 150, 100, 47);
        player3Field.setHorizontalAlignment(JTextField.CENTER);
        player3Field.setFont(new Font("Gadugi", Font.BOLD, 14));
        player3Field.setBackground(Color.BLACK);
        setupPanel.add(player3Field);

        JLabel playerAImageLabel1 = new JLabel();
        ImageIcon playerImage1 = new ImageIcon(getClass().getResource("/com/Project/Player 1.png"));
        Image img1 = playerImage1.getImage();
        Image resizedImg1 = img1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        playerAImageLabel1.setIcon(new ImageIcon(resizedImg1));

        playerAImageLabel1.setBounds(-36, 172, 157, 200); 
        setupPanel.add(playerAImageLabel1);
        
        JLabel playerAImageLabel2 = new JLabel();
        ImageIcon playerImage2 = new ImageIcon(getClass().getResource("/com/Project/Player 2.png"));
        Image img2 = playerImage2.getImage();
        Image resizedImg2 = img2.getScaledInstance(155, 155, Image.SCALE_SMOOTH);
        playerAImageLabel2.setIcon(new ImageIcon(resizedImg2));
        playerAImageLabel2.setBounds(114, 224, 200, 135); 
        setupPanel.add(playerAImageLabel2);

        JLabel playerAImageLabel3 = new JLabel();
        ImageIcon playerImage3 = new ImageIcon(getClass().getResource("/com/Project/Player 3.png"));
        Image img3 = playerImage3.getImage();
        Image resizedImg3 = img3.getScaledInstance(155, 155, Image.SCALE_SMOOTH);
        playerAImageLabel3.setIcon(new ImageIcon(resizedImg3));
        playerAImageLabel3.setBounds(238, 208, 168, 164);
        setupPanel.add(playerAImageLabel3);
        
        JButton backButtonA = new JButton("Back");
        backButtonA.setFont(customFont.deriveFont(15f));
        backButtonA.setBackground(new Color(30, 144, 255));
        backButtonA.setForeground(Color.WHITE);
        backButtonA.setFocusPainted(false);
        backButtonA.setBounds(20, 393, 125, 47);
        backButtonA.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                initializeMainScreen();
            }
        });

        setupPanel.add(backButtonA);

        JButton nextButton = new JButton("Next");
        nextButton.setFont(customFont.deriveFont(15f));
        nextButton.setBackground(new Color(30, 144, 255));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setBounds(237, 393, 125, 47);
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                players[0] = new Player(player1Field.getText());
                players[1] = new Player(player2Field.getText());
                players[2] = new Player(player3Field.getText());

                switchToTeamBInterface(); 
            }
        });

        setupPanel.add(nextButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(setupPanel);
        frame.validate();
    }

    private void switchToTeamBInterface() {
        JPanel setupPanel = new JPanel();
        setupPanel.setLayout(null);
        setupPanel.setBackground(Color.WHITE);

        JLabel teamLabel = new JLabel("Team B");
        teamLabel.setFont(customFont.deriveFont(40f));
        teamLabel.setForeground(new Color(30, 144, 255));
        teamLabel.setBounds(127, 34, 157, 84);
        setupPanel.add(teamLabel);

        JTextField player1Field = new JTextField("Player 1");
        player1Field.setForeground(Color.WHITE);
        player1Field.setBounds(20, 150, 100, 47);
        player1Field.setHorizontalAlignment(JTextField.CENTER);
        player1Field.setFont(new Font("Gadugi", Font.BOLD, 14));
        player1Field.setBackground(Color.BLACK);
        setupPanel.add(player1Field);

        JTextField player2Field = new JTextField("Player 2");
        player2Field.setForeground(Color.WHITE);
        player2Field.setBounds(141, 150, 100, 47);
        player2Field.setHorizontalAlignment(JTextField.CENTER);
        player2Field.setFont(new Font("Gadugi", Font.BOLD, 14));
        player2Field.setBackground(Color.BLACK);
        setupPanel.add(player2Field);

        JTextField player3Field = new JTextField("Player 3");
        player3Field.setForeground(Color.WHITE);
        player3Field.setBounds(262, 150, 100, 47);
        player3Field.setHorizontalAlignment(JTextField.CENTER);
        player3Field.setFont(new Font("Gadugi", Font.BOLD, 14));
        player3Field.setBackground(Color.BLACK);
        setupPanel.add(player3Field);

        JLabel playerBImageLabel1 = new JLabel();
        ImageIcon playerImage1 = new ImageIcon(getClass().getResource("/com/Project/Player 4.png"));
        Image img1 = playerImage1.getImage();
        Image resizedImg1 = img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        playerBImageLabel1.setIcon(new ImageIcon(resizedImg1));

        playerBImageLabel1.setBounds(-12, 208, 156, 164); 
        setupPanel.add(playerBImageLabel1);
        
        JLabel playerBImageLabel2 = new JLabel();
        ImageIcon playerImage2 = new ImageIcon(getClass().getResource("/com/Project/Player 5.png"));
        Image img2 = playerImage2.getImage();
        Image resizedImg2 = img2.getScaledInstance(155, 155, Image.SCALE_SMOOTH);
        playerBImageLabel2.setIcon(new ImageIcon(resizedImg2));
        playerBImageLabel2.setBounds(113, 225, 200, 135); 
        setupPanel.add(playerBImageLabel2);

        JLabel playerBImageLabel3 = new JLabel();
        ImageIcon playerImage3 = new ImageIcon(getClass().getResource("/com/Project/Player 6.png"));
        Image img3 = playerImage3.getImage();
        Image resizedImg3 = img3.getScaledInstance(155, 155, Image.SCALE_SMOOTH);
        playerBImageLabel3.setIcon(new ImageIcon(resizedImg3));
        playerBImageLabel3.setBounds(237, 208, 168, 164);
        setupPanel.add(playerBImageLabel3);
        
        JButton backButtonB = new JButton("Back");
        backButtonB.setFont(customFont.deriveFont(15f));
        backButtonB.setBackground(new Color(30, 144, 255));
        backButtonB.setForeground(Color.WHITE);
        backButtonB.setFocusPainted(false);
        backButtonB.setBounds(20, 393, 125, 47);
        backButtonB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                switchToTeamAInterface();
            }
        });

        setupPanel.add(backButtonB);

        JButton nextButton = new JButton("Next");
        nextButton.setFont(customFont.deriveFont(15f));
        nextButton.setBackground(new Color(30, 144, 255));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setBounds(237, 393, 125, 47);
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                players[3] = new Player(player1Field.getText());
                players[4] = new Player(player2Field.getText());
                players[5] = new Player(player3Field.getText());

                displayTeamDetails(); 
            }
        });

        setupPanel.add(nextButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(setupPanel);
        frame.validate();
    }

    private void displayTeamDetails() {
        JPanel loadingPanel = new JPanel();
        loadingPanel.setLayout(null);
        loadingPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Players List");
        titleLabel.setFont(customFont.deriveFont(30f));
        titleLabel.setForeground(new Color(30, 144, 255));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(37, 11, 300, 40);
        loadingPanel.add(titleLabel);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBackground(new Color(0, 0, 0));
        progressBar.setForeground(new Color(30, 144, 255));
        progressBar.setBounds(37, 270, 300, 30);
        progressBar.setIndeterminate(true);

        loadingPanel.add(progressBar);

        JLabel teamALabel = new JLabel("Team A");
        teamALabel.setBounds(37, 72, 68, 40);
        teamALabel.setFont(customFont.deriveFont(20f));
        loadingPanel.add(teamALabel);

        JLabel playerA1Label = new JLabel(players[0].getName());
        playerA1Label.setBounds(37, 130, 150, 30);
        playerA1Label.setForeground(new Color(30, 144, 255));
        playerA1Label.setFont(customFont.deriveFont(17f));
        loadingPanel.add(playerA1Label);

        JLabel playerA2Label = new JLabel(players[1].getName());
        playerA2Label.setBounds(37, 160, 150, 30);
        playerA2Label.setFont(customFont.deriveFont(17f));
        loadingPanel.add(playerA2Label);

        JLabel playerA3Label = new JLabel(players[2].getName());
        playerA3Label.setBounds(37, 190, 150, 30);
        playerA3Label.setForeground(new Color(30, 144, 255));
        playerA3Label.setFont(customFont.deriveFont(17f));
        loadingPanel.add(playerA3Label);

        JLabel teamBLabel = new JLabel("Team B");
        teamBLabel.setBounds(263, 72, 68, 40);
        teamBLabel.setFont(customFont.deriveFont(20f));
        loadingPanel.add(teamBLabel);

        JLabel playerB1Label = new JLabel(players[3].getName());
        playerB1Label.setForeground(new Color(30, 144, 255));
        playerB1Label.setBounds(263, 130, 150, 30);
        playerB1Label.setFont(customFont.deriveFont(17f));
        loadingPanel.add(playerB1Label);

        JLabel playerB2Label = new JLabel(players[4].getName());
        playerB2Label.setBounds(263, 160, 150, 30);
        playerB2Label.setFont(customFont.deriveFont(17f));
        loadingPanel.add(playerB2Label);

        JLabel playerB3Label = new JLabel(players[5].getName());
        playerB3Label.setBounds(263, 190, 150, 30);
        playerB3Label.setForeground(new Color(30, 144, 255));
        playerB3Label.setFont(customFont.deriveFont(17f));
        loadingPanel.add(playerB3Label);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(loadingPanel);
        frame.validate();
        
        Timer timer = new Timer(5000, new ActionListener() 
        { 
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                switchToGameInterface(); 
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void switchToGameInterface() {
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(Color.WHITE);

        JLabel gameTitle = new JLabel("Welcome to Family Feud!");
        gameTitle.setFont(customFont.deriveFont(30f));
        gameTitle.setForeground(new Color(30, 144, 255));
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gameTitle.setBounds(50, 50, 300, 50);
        gamePanel.add(gameTitle);

        JLabel instructions = new JLabel("<html>The game starts now!<br>Get ready to answer.</html>");
        instructions.setFont(new Font("Gadugi", Font.BOLD, 20));
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setBounds(50, 150, 300, 100);
        gamePanel.add(instructions);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(gamePanel);
        frame.validate();
    }

    public static void main(String[] args) 
    {
        new FamilyFeud();
    }
}

package com.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class FamilyFeud 
{
    private JFrame frame;
    private JPanel panel;
    private Font customFont;

    public FamilyFeud() 
    {
        loadCustomFont(); 
        initialize();
    }

    private void loadCustomFont() 
    {
        try 
        {
            customFont = Font.createFont(
                Font.TRUETYPE_FONT,
                getClass().getResourceAsStream("/com/Project/MightySouly-lxggD.ttf")
            ).deriveFont(100f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } 
        catch (FontFormatException | IOException | NullPointerException e) 
        {
            System.out.println("Error loading font: " + e.getMessage());
            customFont = new Font("Comic Sans MS", Font.BOLD, 50);  
        }
    }

    private void initialize() 
    {
        frame = new JFrame("Family Feud");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        panel = new JPanel();
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

        playButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                playButton.setBackground(Color.BLACK);
                playButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                playButton.setBackground(new Color(30, 144, 255)); 
                playButton.setForeground(Color.WHITE); 
            }
        });

        playButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                switchToGameInterface();
            }
        });

        panel.add(playButton);

        JLabel imageLabel1 = new JLabel();
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/com/Project/Human.png"));  
        imageLabel1.setIcon(imageIcon1);
        imageLabel1.setBounds(-31, 276, 258, 468);  
        panel.add(imageLabel1);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
        JLabel imageLabel2 = new JLabel();
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/com/Project/Question Mark.png"));  

        Image img = imageIcon2.getImage(); 
        Image resizedImg = img.getScaledInstance(160, 110, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(resizedImg); 

        imageLabel2.setIcon(resizedIcon);
        imageLabel2.setBounds(46, 227, 131, 138);  
        panel.add(imageLabel2);
    }
    
    private void displayTeamDetails(Team teamA) 
    {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(2, 1));
        detailsPanel.setBackground(Color.WHITE);

        JTextArea teamADetails = new JTextArea();
        teamADetails.setText("Team A:\n");
        for (Player player : teamA.getPlayers()) {
            teamADetails.append(player.getName() + "\n");
        }
        detailsPanel.add(new JScrollPane(teamADetails));

//        JTextArea teamBDetails = new JTextArea();
//        teamBDetails.setText("Team B:\n");
//        for (Player player : teamB.getPlayers()) {
//            teamBDetails.append(player.getName() + "\n");
//        }
//        detailsPanel.add(new JScrollPane(teamBDetails));

        frame.getContentPane().add(detailsPanel);
        frame.validate();
    }

    private void switchToGameInterface() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel setupPanel = new JPanel();
        setupPanel.setLayout(null);
        setupPanel.setBackground(Color.WHITE); 

        JLabel teamALabel = new JLabel("Team A");
        teamALabel.setFont(customFont.deriveFont(40f)); 
        teamALabel.setForeground(new Color(30, 144, 255));  
        teamALabel.setBounds(127, 34, 157, 84);
        setupPanel.add(teamALabel);

        JTextField playerA1 = new JTextField("Player 1");
        playerA1.setForeground(new Color(255, 255, 255));
        playerA1.setBounds(20, 150, 100, 47);
        playerA1.setHorizontalAlignment(JTextField.CENTER); 
        playerA1.setFont(new Font("Gadugi", Font.BOLD, 14)); 
        playerA1.setBackground(new Color(0, 0, 0)); 
        setupPanel.add(playerA1);

        JTextField playerA2 = new JTextField("Player 2");
        playerA2.setForeground(new Color(255, 255, 255));
        playerA2.setBounds(141, 150, 100, 47);
        playerA2.setHorizontalAlignment(JTextField.CENTER); 
        playerA2.setFont(new Font("Gadugi", Font.BOLD, 14)); 
        playerA2.setBackground(new Color(0, 0, 0)); 
        setupPanel.add(playerA2);

        JTextField playerA3 = new JTextField("Player 3");
        playerA3.setForeground(new Color(255, 255, 255));
        playerA3.setBounds(262, 150, 100, 47);
        playerA3.setHorizontalAlignment(JTextField.CENTER); 
        playerA3.setFont(new Font("Gadugi", Font.BOLD, 14));
        playerA3.setBackground(new Color(0, 0, 0)); 
        setupPanel.add(playerA3);

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

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setFont(customFont.deriveFont(10f)); 
        startGameButton.setBackground(new Color(30, 144, 255));  
        startGameButton.setForeground(Color.WHITE);
        startGameButton.setFocusPainted(false);
        startGameButton.setBounds(127, 393, 125, 47);
        startGameButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Team teamA = new Team("Team A");
                teamA.addPlayer(new Player(playerA1.getText()));
                teamA.addPlayer(new Player(playerA2.getText()));
                teamA.addPlayer(new Player(playerA3.getText()));

                displayTeamDetails(teamA);
            }
        });

        setupPanel.add(startGameButton);

        frame.getContentPane().add(setupPanel);
        frame.validate();
    }

    public static void main(String[] args) 
    {
        FamilyFeud game = new FamilyFeud();
        
        game.switchToGameInterface();
    }

}

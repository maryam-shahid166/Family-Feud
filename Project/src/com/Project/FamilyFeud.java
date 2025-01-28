package com.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FamilyFeud 
{
	 private List<Question> questions = new ArrayList<>();
	    private int maxRounds = 5;
	    private int currentQuestionIndex = 0;
	    private JFrame frame;
	    private Font customFont;
	    private Player[] players = new Player[6];
	    
    public FamilyFeud() 
    {
        loadCustomFont();
        initializeMainScreen();
        initializeQuestions();
    }
    
    private void initializeQuestions() 
    {
    	questions.add(new Question("Name something you might find in a kitchen.",
                Arrays.asList(
                    new Answer("Refrigerator", 40),
                    new Answer("Stove", 25),
                    new Answer("Sink", 15),
                    new Answer("Microwave", 10),
                    new Answer("Knife", 5),
                    new Answer("Plate", 5)
                )));
            questions.add(new Question("Name a reason someone might call in sick to work.",
                Arrays.asList(
                    new Answer("Flu", 35),
                    new Answer("Cold", 30),
                    new Answer("Headache", 20),
                    new Answer("Food Poisoning", 10),
                    new Answer("Migraine", 5)
                )));
            questions.add(new Question("Name a fruit that is yellow.",
                Arrays.asList(
                    new Answer("Banana", 50),
                    new Answer("Lemon", 25),
                    new Answer("Pineapple", 15),
                    new Answer("Mango", 7),
                    new Answer("Yellow Apple", 3)
                )));
            questions.add(new Question("Name something people are afraid of.",
                Arrays.asList(
                    new Answer("Spiders", 40),
                    new Answer("Heights", 30),
                    new Answer("Darkness", 15),
                    new Answer("Death", 10),
                    new Answer("Public Speaking", 5)
                )));
            questions.add(new Question("Name a type of vehicle.",
                Arrays.asList(
                    new Answer("Car", 45),
                    new Answer("Truck", 25),
                    new Answer("Motorcycle", 15),
                    new Answer("Bicycle", 10),
                    new Answer("Bus", 5)
                )));
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
            	showRoundScreen();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private int currentRound = 1;
    private Team currentTeam;
    private Team teamA = new Team("Team A");
    private Team teamB = new Team("Team B");
    private String currentQuestion;
    private int strikes;
    private boolean stealPhase;

    private void showRoundScreen() {
        JPanel roundPanel = new JPanel();
        roundPanel.setLayout(null);
        roundPanel.setBackground(Color.WHITE);

        JLabel roundLabel = new JLabel("Round " + currentRound);
        roundLabel.setFont(customFont.deriveFont(40f));
        roundLabel.setForeground(new Color(30, 144, 255));
        roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        roundLabel.setBounds(50, 100, 300, 100);
        roundPanel.add(roundLabel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(roundPanel);
        frame.validate();

        Timer roundTimer = new Timer(5000, e -> {
            generateNewQuestion();
            startTeamTurn(currentTeam != null ? currentTeam : teamA);
        });
        roundTimer.setRepeats(false);
        roundTimer.start();
    }

    private void startTeamTurn(Team team) {
        currentTeam = team;
        strikes = 0;
        stealPhase = false;
        createTeamInterface(team);
    }

    private void createTeamInterface(Team team) {
        JPanel teamPanel = new JPanel();
        teamPanel.setLayout(null);
        teamPanel.setBackground(Color.WHITE);

        // Team Label
        JLabel teamLabel = new JLabel(team.getTeamName() + "'s Turn");
        teamLabel.setFont(customFont.deriveFont(30f));
        teamLabel.setForeground(new Color(30, 144, 255));
        teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
        teamLabel.setBounds(50, 20, 300, 50);
        teamPanel.add(teamLabel);

        // Question Label
        JLabel questionLabel = new JLabel("<html><center>" + currentQuestion + "</center></html>");
        questionLabel.setFont(customFont.deriveFont(25f));
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(20, 100, 360, 100);
        teamPanel.add(questionLabel);

        // Input field
        JTextField answerField = new JTextField();
        answerField.setFont(new Font("Gadugi", Font.BOLD, 20));
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setBounds(50, 220, 300, 50);
        teamPanel.add(answerField);

        // Timer Label
        JLabel timerLabel = new JLabel("Time Left: 10");
        timerLabel.setFont(customFont.deriveFont(20f));
        timerLabel.setForeground(new Color(30, 144, 255));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setBounds(150, 300, 100, 30);
        teamPanel.add(timerLabel);

        // Strikes Label
        JLabel strikesLabel = new JLabel("Strikes: " + strikes);
        strikesLabel.setFont(customFont.deriveFont(20f));
        strikesLabel.setForeground(Color.RED);
        strikesLabel.setBounds(320, 20, 100, 30);
        teamPanel.add(strikesLabel);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(customFont.deriveFont(20f));
        submitButton.setBackground(new Color(30, 144, 255));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 350, 100, 40);
        
        Timer timer = new Timer(1000, new ActionListener() {
            int timeLeft = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time Left: " + timeLeft);
                if (timeLeft <= 0) {
                    ((Timer) e.getSource()).stop();
                    handleAnswer(null, team);
                }
            }
        });

        submitButton.addActionListener(e -> {
            String answer = answerField.getText().trim();
            if (!answer.isEmpty()) {
                timer.stop();
                handleAnswer(answer, team);
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter an answer!");
            }
        });

        teamPanel.add(submitButton);
        timer.start();

        frame.getContentPane().removeAll();
        frame.getContentPane().add(teamPanel);
        frame.validate();
    }

    private void handleAnswer(String answer, Team team) {
        boolean correct = false;
        int points = 0;
        if (answer != null) {
            String cleanAnswer = answer.toLowerCase().trim();
            for (Answer a : questions.get(currentQuestionIndex).answers) {
                if (a.text.toLowerCase().equals(cleanAnswer)) {
                    correct = true;
                    points = a.points;
                    break;
                }
            }
        }

        if (correct) {
            team.addScore(points);
            JOptionPane.showMessageDialog(frame, "Correct! " + team.getTeamName() + " gains " + 
                points + " points!");
            currentQuestionIndex++;
            
            if (currentRound >= maxRounds) {
                showGameOver();
            } else {
                currentRound++;
                showRoundScreen();
            }
        } else {
            strikes++;
            if (strikes < 3) {
                JOptionPane.showMessageDialog(frame, "Strike " + strikes + "! Try again!");
                createTeamInterface(team);
            } else {
                if (!stealPhase) {
                    stealPhase = true;
                    Team otherTeam = (team == teamA) ? teamB : teamA;
                    JOptionPane.showMessageDialog(frame, "3 Strikes! " + otherTeam.getTeamName() + " can steal!");
                    createTeamInterface(otherTeam);
                } else {
                    JOptionPane.showMessageDialog(frame, "Steal failed! No points awarded.");
                    currentQuestionIndex++;
                    if (currentRound >= maxRounds) {
                        showGameOver();
                    } else {
                        currentRound++;
                        showRoundScreen();
                    }
                }
            }
        }
    }
    
    private void generateNewQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0; // Reset or handle end of questions
        }
        currentQuestion = questions.get(currentQuestionIndex).text;
    }

    private boolean isCorrectAnswer(String answer) {
        String cleanAnswer = answer.toLowerCase().trim();
        return questions.get(currentQuestionIndex).answers.contains(cleanAnswer);
    }
    
    private void showGameOver() {
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setLayout(null);
        gameOverPanel.setBackground(Color.WHITE);

        // Determine the winner and select appropriate meme
        String imagePath = "/com/Project/Announce.png";
        String winningTeam = teamA.getTeamScore() > teamB.getTeamScore() ? "Team A!" : "Team B!";
        
        // Winning Team Label
        JLabel winnerLabel = new JLabel(winningTeam);
        winnerLabel.setFont(customFont.deriveFont(30f));
        winnerLabel.setForeground(new Color(30, 144, 255));
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winnerLabel.setBounds(163, 31, 300, 40);
        gameOverPanel.add(winnerLabel);

        // Load and display meme image
        ImageIcon memeIcon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledMeme = memeIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        JLabel memeLabel = new JLabel(new ImageIcon(scaledMeme));
        memeLabel.setBounds(50, 50, 300, 200);
        gameOverPanel.add(memeLabel);

        // Display final scores
        JLabel scoreLabel = new JLabel("<html><center>Team A: " + teamA.getTeamScore() 
            + "<br>Team B: " + teamB.getTeamScore() + "</center></html>");
        scoreLabel.setFont(customFont.deriveFont(25f));
        scoreLabel.setForeground(new Color(30, 144, 255));
        scoreLabel.setBounds(50, 260, 300, 100);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameOverPanel.add(scoreLabel);

        // Play Again Button
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setFont(customFont.deriveFont(20f));
        playAgainButton.setBackground(new Color(30, 144, 255));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.setFocusPainted(false);
        playAgainButton.setBounds(50, 370, 150, 40);
        playAgainButton.addActionListener(e -> {
            // Reset game state
            teamA = new Team("Team A");
            teamB = new Team("Team B");
            currentRound = 1;
            currentQuestionIndex = 0;
            switchToTeamAInterface();
        });
        gameOverPanel.add(playAgainButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(customFont.deriveFont(20f));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.setBounds(220, 370, 150, 40);
        exitButton.addActionListener(e -> System.exit(0));
        gameOverPanel.add(exitButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(gameOverPanel);
        frame.validate();
    }


    public static void main(String[] args) 
    {
        new FamilyFeud();
    }
}

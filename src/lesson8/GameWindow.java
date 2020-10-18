package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 600;
    static final int WINDOW_Y = 150;
    static final int WINDOW_WIDTH = 605;
    static final int WINDOW_HEIGHT = 655;

    private SettingWindow settingWindow;
    private GameField gameField;

    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        settingWindow = new SettingWindow(this);

        gameField = new GameField(this);
        add(gameField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStartGame = new JButton("Start new game");
        panel.add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSize, int winStreak) {
        gameField.startNewGame(gameMode, fieldSize, winStreak);
    }

    public void gameResult (String s){
        JDialog result = new JDialog();
        int windowX = WINDOW_X+200;
        int windowY = WINDOW_Y+200;
        int width = 200;
        int height = 100;

        result.setTitle("Game finished");
        result.setBounds(windowX,windowY,width,height);
        result.add(new JLabel(s+" wins"),BorderLayout.CENTER);
        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        result.add(buttonExit,BorderLayout.SOUTH);
        result.setVisible(true);
    }

}

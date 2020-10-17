package lesson8;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    static final int WINDOW_X = GameWindow.WINDOW_X + 50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y + 50;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    static final int WINDOW_HEIGHT = 550;

    static final int H_VS_AI_MODE = 0;
    static final int H_VS_H_MODE = 1;

    final int MIN_FIELD_SIZE = 3;
    final int MAX_FIELD_SIZE = 10;


    private GameWindow gameWindow;
    private JRadioButton radioButtonHvsAI;
    private JRadioButton radioButtonHvsH;
    private ButtonGroup bgGameMode;

    private JSlider sliderFieldSize;
    private JSlider sliderWinStreak;

    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe Settings");

        setLayout(new GridLayout(8, 1));
        add(new JLabel("Choose game mode:"));

        radioButtonHvsAI = new JRadioButton("Human VS Computer", true);
        radioButtonHvsH = new JRadioButton("Human VS Human");
        bgGameMode = new ButtonGroup();
        bgGameMode.add(radioButtonHvsAI);
        bgGameMode.add(radioButtonHvsH);
        radioButtonHvsH.setEnabled(false); //TODO режим недоступен, доделать
        add(radioButtonHvsAI);
        add(radioButtonHvsH);

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);
        sliderWinStreak = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinStreak.setMajorTickSpacing(1);
        sliderWinStreak.setPaintLabels(true);
        sliderWinStreak.setPaintTicks(true);
        sliderFieldSize.addChangeListener(e -> {
            sliderWinStreak.setMaximum(sliderFieldSize.getValue());
        });

        add(new JLabel("Choose field size:"));
        add(sliderFieldSize);

        add(new JLabel("Choose winning streak:"));
        add(sliderWinStreak);

        JButton buttonStart = new JButton("Start the game");
        add(buttonStart);

        buttonStart.addActionListener(e -> {
            int gameMode;
            if (radioButtonHvsAI.isSelected()){
                gameMode = H_VS_AI_MODE;
            } else {
                gameMode = H_VS_H_MODE;
            }
            int fieldSize = sliderFieldSize.getValue();
            int winStreak = sliderWinStreak.getValue();

            Logic.size = fieldSize;
            Logic.dotsToWin = winStreak;
            Logic.finishedGame = false;
            Logic.createMap();

            gameWindow.startNewGame(gameMode, fieldSize, winStreak);

            setVisible(false);
        });

        setVisible(false);
    }
}

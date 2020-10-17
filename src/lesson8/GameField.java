package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {
    private GameWindow gameWindow;
    private int gameMode;
    private int fieldSize;
    private int winStreak;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public GameField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.finishedGame) {
                    Logic.humanTurn(cellX, cellY);
                }
                repaint();
            }
        });

        setBackground(Color.CYAN);
    }

    public void startNewGame(int gameMode, int fieldSize, int winStreak) {
        this.gameMode = gameMode;
        this.fieldSize = fieldSize;
        this.winStreak = winStreak;
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        //TODO объединить в один цикл
        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellHeight;
            g.drawLine(x, 0, x, panelHeight);
        }
    }

    void drawX(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawLine(x * cellWidth, y * cellHeight, (x + 1) * cellWidth, (y + 1) * cellHeight);
    }
    void drawO(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
    }
}

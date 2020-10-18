package lesson8;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int size;
    static int dotsToWin;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;
    static boolean finishedGame;
    static String winner;

    static Random random = new Random();

    public static void go() {
        finishedGame = true;
        if (checkWin(DOT_X)) {
            winner = "You";
            return;
        }
        if (isFool()) {
            winner = "Nobody";
            return;
        }

        compTurn();
        if (checkWin(DOT_O)) {
            winner = "Computer";
            return;
        }
        if (isFool()) {
            winner = "Nobody";
            return;
        }
        finishedGame = false;
    }

    static void createMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }


    static void humanTurn(int x, int y) {
        if(isCellCorrect(y, x)){
            map[y][x] = DOT_X;
            go();
        }

    }

    static void compTurn() {
        int x, y;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == DOT_EMPTY){
                    map[i][j] = DOT_O;
                    if (compCheckMove(i, j, DOT_O)) {
                        return;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_X;
                    if (compCheckMove(i, j, DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        do {
            y = random.nextInt(size);
            x = random.nextInt(size);
        } while (!isCellCorrect(y, x));
        map[y][x] = DOT_O;

    }

    static boolean isCellCorrect(int y, int x) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }


    static boolean isFool() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkLine(i, j, 0, 1, c)) {
                    return true;
                }
                if (checkLine(i, j, 1, 0, c)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1, c)) {
                    return true;
                }
                if (checkLine(i, j, -1, 1, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkLine(int y, int x, int dy, int dx, char c) {
        if (y + dy * dotsToWin > size || y + dy * dotsToWin < 0 || x + dx * dotsToWin > size) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[y][x] != c) {
                return false;
            }
            y += dy;
            x += dx;
        }
        return true;
    }

    static boolean compCheckMove(int i, int j, char c) {
        if (checkLine(i, j, 0, 1, c)) {
            return true;
        }
        if (checkLine(i, j, 1, 0, c)) {
            return true;
        }
        if (checkLine(i, j, 1, 1, c)) {
            return true;
        }
        if (checkLine(i, j, -1, 1, c)) {
            return true;
        }
        return false;
    }

}

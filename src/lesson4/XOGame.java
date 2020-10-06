package lesson4;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static char[][] map;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        createMap();
        printMap();

        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                printMap();
                System.out.println("Вы победили!");
                break;
            }
            if (isFool()) {
                System.out.println("Ничья!");
                break;
            }

            compTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер выиграл войну и помещает вас в Матрицу");
                break;
            }
            if (isFool()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    static void createMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellCorrect(y, x));

        map[y][x] = DOT_X;
    }

    static void compTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellCorrect(y, x));
        map[y][x] = DOT_O;

    }

    static boolean isCellCorrect(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }


    static boolean isFool() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char c) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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
        if (y + dy * DOTS_TO_WIN > SIZE || y + dy * DOTS_TO_WIN < 0 || x + dx * DOTS_TO_WIN > SIZE) {
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN; i++) {
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

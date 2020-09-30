package lesson3;

import java.util.Random;
import java.util.Scanner;

public class thirdhw {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static StringBuffer output = new StringBuffer();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Угадайка!");
        do {
            System.out.println("Выбери игру - напиши words для игры в слова,\nили numbers для игры в числа." +
                    " Чтобы выйти, набери exit");
            String wish = scanner.next();
            if (wish.equals("words")) {
                guessWord();
            } else if (wish.equals("numbers")) {
                guessNumber();
            } else {
                System.out.println("Пока-пока! Приходи ещё!");
                scanner.close();
                break;
            }
        } while (true);
    }

    public static void guessNumber() {
        int counts = 3;
        int answer = random.nextInt(10);
        System.out.println("Добро пожаловать в игру Угадай число!\nВведи число. И помни, у тебя три попытки!");
        for (int i = 0; i < counts; i++) {
            int userAnswer = scanner.nextInt();
            if (answer == userAnswer) {
                System.out.println("Победа!");
                break;
            } else if (i == 2) {
                System.out.println("Извини, но ты проиграл :(");
            } else if (answer < userAnswer) {
                System.out.println("Твое число слишком большое!\nПопробуй ещё раз");
            } else {
                System.out.println("Твое число слишком маленькое!\nПопробуй ещё раз");
            }
        }
    }

    public static int randomWord(int a) {
        a = random.nextInt(a);
        return a;
    }

    public static void compareWords(String word, String userAnswer) {
        int min = Math.min(word.length(), userAnswer.length());
        for (int i = 0; i < min; i++) {
            if (word.charAt(i) == userAnswer.charAt(i)) {
                output.insert(i, word.charAt(i));
            } else {
                output.insert(i, "#");
            }
        }
        System.out.println(output + "#######");
    }

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int n = randomWord(words.length);
        String word = words[n];
        do {
            System.out.println("Добро пожаловать в игру Угадай слово!\nВведите слово (используйте только маленькие английский буквы)");
            String userAnswer = scanner.next();
            if (word.equals(userAnswer)) {
                System.out.println("Поздравляю! Вы выиграли!");
                break;
            } else {
                System.out.println("Не угадали, попробуйте ещё раз\nэти буквы были угаданы:");
                compareWords(word, userAnswer);
            }

        } while (true);
    }

}

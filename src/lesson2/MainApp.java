package lesson2;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        int[] array = new int[10];
        array = randomFillArray(array, 2);
        System.out.println("Первый массив = " + Arrays.toString(array));
        replaceNumbers(array);
        int[] arrayTwo = new int[8];
        fillArray(arrayTwo, 3);
        int[] arrayThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        thirdTask(arrayThree);
        int[][] arrayFour = new int[6][6];
        fillDiagonal(arrayFour);
        int[] arrayFive = new int[10];
        arrayFive = randomFillArray(arrayFive, 50);
        System.out.println("Пятый массив = " + Arrays.toString(arrayFive));
        System.out.println("Минимум в нём: " + minInArr(arrayFive));
        System.out.println("Максимум в нём: " + maxInArr(arrayFive));
        int[] arraySix = new int[10];
        arraySix = randomFillArray(arraySix, 21);
        System.out.println("Шестой массив: " + Arrays.toString(arraySix));
        boolean a = balance(arraySix);
        System.out.println(a);
        int[] arraySeven = new int [10];
        arraySeven = randomFillArray(arraySeven,21);
        System.out.println("Седьмой массив: "+Arrays.toString(arraySeven));
        moveElements(arraySeven,6);
        moveElements(arraySeven,-2);

    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int[] randomFillArray(int arr[], int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void replaceNumbers(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Замена в первом массиве = " + Arrays.toString(arr));
    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
    public static void fillArray(int arr[], int step) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * step;
        }
        System.out.println("Второй массив = " + Arrays.toString(arr));
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
    public static void thirdTask(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Третий массив = " + Arrays.toString(arr));
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    public static void fillDiagonal(int arr[][]) {
        System.out.println("Массив с заполненными диагоналями");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    // 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    public static int minInArr(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxInArr(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
    // вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean balance(int arr[]) {
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            int sumRight = 0;
            for (int j = arr.length - 1; j > i; j--) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                System.out.printf("Сумма левой и правой стороны равны между %d и %d элементами\n", i + 1, i + 2);
                return true;
            }
        }
        return false;
    }

    // 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично.
    public static void moveElements(int arr[], int n) {
        int m = Math.abs(n);
        while (m > 0) {
            if (n > 0) {
                int reserve = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = reserve;
                m--;
            } else {
                int reserve = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = reserve;
                m--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

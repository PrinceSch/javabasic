package lesson1;

public class Main {
    public static void main(String[] args) {
        byte bill = 65;
        short shelly = 3245;
        int inna = 214748;
        long luise = 922336203575477L;
        float fergus = 32.54f;
        double doctor = -125.745;
        char clara = '\u0457';
        boolean river = false;
        String rose = "bad wolf";

        System.out.println(thirdTask(32.54f, 1.16f, 42.4f, 71.2f));
        river = fourthTask(7, 10);
        fifthTask(15);
        boolean glados = sixthTask(-14);
        seventhTask("Doctor");
        eighthTask(2020);
    }

    public static float thirdTask(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean fourthTask(int a, int b) {
        if (10 <= (a + b) && (a + b) >= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void fifthTask(int a) {
        if (a < 0) {
            System.out.println("число отрицательное");
        } else {
            System.out.println("число положительное");
        }
    }

    public static boolean sixthTask(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void seventhTask(String s) {
        System.out.println("Привет, " + s);
    }

    public static void eighthTask(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("год високосный");
        } else {
            System.out.println("год не високосный");
        }
    }

}
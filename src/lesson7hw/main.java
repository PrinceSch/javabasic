package lesson7hw;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Plate plate = new Plate(50);

        Cat cats[] = { new Cat("Кот"), new Cat("Лев", 150), new Cat("Котенок",5),
                new Cat("Тигр",50), new Cat("Кошка")
        };

        for (Cat cat: cats
             ) {
            cat.eat(plate);
        }

        for (Cat cat: cats
        ) {
            cat.bellyfulness();
        }
        plate.getFood();
        plate.increaseFood(40);
        plate.getFood();

    }

}

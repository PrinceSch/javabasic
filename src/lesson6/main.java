package lesson6;

import lesson6.animals.*;

public class main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Рыжик", "рыжий", 2);
        Cat cat2 = new Cat("Дымок", "полосатый серый", 6);
        Cat cat3 = new Cat("Ния", "черный", 6);
        Dog dog1 = new Dog("Хась", "черно-белый", 1);
        Dog dog2 = new Dog("Волкодав", "серый", 4);
        Dog dog3 = new Dog("Жужа", "золотистый", 7);
        Dog dog4 = new Dog("Фрея", "белый", 3);

        cat1.run(100);
        cat2.run(250);
        cat3.swim(4);
        dog1.run(300);
        dog2.run(700);
        dog3.swim(7);
        dog4.swim(15);

        System.out.println("Всего котов: " + cat1.count());
        System.out.println("Всего собак: " + dog1.count());
        System.out.println("Всего животных: " + (cat1.count() + dog1.count()) );


    }

}

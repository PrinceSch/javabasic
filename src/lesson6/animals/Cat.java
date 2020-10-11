package lesson6.animals;

public class Cat extends Animal {

    static int catCount;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        catCount++;
    }

    @Override
    public void run(int a) {
        if (a < 200) {
            System.out.printf("%s пробежал %d метров\n", name, a);
        } else {
            System.out.println(name + " устал и не смог пробежать это расстояние");
        }
    }

    @Override
    public void swim(int a) {
        System.out.println(name + " не умеет плавать :(");
    }

    @Override
    public int count() {
        return catCount;
    }
}

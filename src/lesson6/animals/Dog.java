package lesson6.animals;

public class Dog extends Animal {

    static int dogCount;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        dogCount++;
    }

    @Override
    public void run(int a) {
        if (a < 500) {
            System.out.printf("%s пробежал %d метров\n", name, a);
        } else {
            System.out.println(name + " устал и не смог пробежать это расстояние");
        }
    }

    @Override
    public void swim(int a) {
        if (a < 10) {
            System.out.printf("%s проплыл %d метров\n", name, a);
        } else {
            System.out.println(name + " устал и не смог проплыть это расстояние");
        }
    }

    @Override
    public int count() {
        return dogCount;
    }
}

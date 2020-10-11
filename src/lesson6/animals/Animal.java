package lesson6.animals;

abstract class Animal {

    protected String name;
    protected String color;
    protected int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public abstract void run(int a);

    public abstract void swim(int a);

    public abstract int count();

}

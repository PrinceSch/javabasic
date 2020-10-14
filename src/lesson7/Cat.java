package lesson7;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        System.out.println("Cat " + name + " eat...");
        plate.decreaseFood(10);
    }

    public void fear(AngryDog dog) {
        System.out.println("Cat " + name + " fear dog " + dog.getName());
    }

    public void fear() {
        System.out.println("Cat " + name + " fear all dogs and all shadow...");
    }
}

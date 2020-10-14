package lesson7;

public class AngryDog {
    private String name;

    public String getName() {
        return name;
    }

    public AngryDog(String name) {
        this.name = name;
    }

    public void scare(Cat cat) {
        System.out.println("Dog " + name + " gav gav at "+  cat.getName());
        cat.fear(this);
    }

}

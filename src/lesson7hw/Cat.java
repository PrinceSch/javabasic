package lesson7hw;

public class Cat {

    private String name;
    private boolean bellyful = false;
    private int appetite = 10;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public boolean isBellyful() {
        return bellyful;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            System.out.println(name + " покушал");
            bellyful = true;
        } else {
            System.out.println(name + " не покушал");
        }
    }

    public void bellyfulness(){
        if (bellyful){
            System.out.println(name + " сыт");
        }
    }

}

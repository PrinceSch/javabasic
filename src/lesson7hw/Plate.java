package lesson7hw;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void getFood() {
        System.out.println("В тарелке осталось " + food + " еды");
    }

    public boolean decreaseFood(int amount) {
        if (amount < 0 || food - amount < 0) {
            return false;
        }
        food -= amount;
        return true;
    }

    public void increaseFood(int a) {
        food += a;
    }

}

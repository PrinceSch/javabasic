package lesson7;

public class Box {
    private String color;
    private int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (size != box.size) return false;
        return color != null ? color.equals(box.color) : box.color == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }

    //    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Box)) {
//            return false;
//        }
//
//        Box another = (Box) obj;
//
//        if (!this.color.equals(another.color)) {
//            return false;
//        }
//        return this.size == another.size;
//    }
//
//    @Override
//    public int hashCode() {
//        return 31 * this.color.hashCode() + this.size;
//    }

    @Override
    public String toString() {
        return "Box{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}

package lesson7;

public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box("red", 7);
//        Box box2 = new Box("red", 7);
//
//        if (box1.equals(box2)) {
//            System.out.println("equals");
//        } else {
//            System.out.println("no equals");
//        }
//
//        System.out.println(box1.hashCode());
//        System.out.println(box2.hashCode());

//        StringBuilder sb = new StringBuilder("a");
//
////        for (int i = 0; i < 1000000; i++) {
////            sb.append("1");
////        }
//
//        sb.append(134).append("ertert").append('r');
////        .append(System.lineSeparator());
//        sb.insert(3, "qwerty");
//        sb.delete(4, 14);
////        sb.replace(2,6, "*");
////        sb.reverse();
//        System.out.println(sb);
//        sb.setLength(sb.length() - 3);
//        System.out.println(sb);
//
//        String s1 = sb.toString();

//        String s1 = "java";
//        String s2 = "java";
//        System.out.println(s1 == s2);
//        String s3 = new String("java");
//        System.out.println(s1 == s3);
//        System.out.println(s1.equals(s3));

//        Integer x = 1999;
//        Integer y = 1999;
//        System.out.println(x.equals(y));


        Cat cat = new Cat("Barsik");
        Plate plate = new Plate(100);

        cat.eat(plate);
        cat.eat(plate);

        System.out.println(plate);


        AngryDog dog = new AngryDog("Tuzik");
        dog.scare(cat);

    }
}

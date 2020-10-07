package lesson5;

public class Employer {

    private String FIO;
    private String job;
    private String mail;
    private String phone;
    private int salary;
    private int age;

    public Employer(String FIO, String job, String mail, String phone, int salary, int age) {
        this.FIO = FIO;
        this.job = job;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Name: " + FIO);
        System.out.println("Job: " + job);
        System.out.println("E-mail: " + mail);
        System.out.println("Phone number: " + phone);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }

    public int getAge() {
        return age;
    }
}

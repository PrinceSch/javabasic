package lesson5;

public class main {

    public static void main(String[] args) {

        Employer[] employers = new Employer[5];
        employers[0] = new Employer("Васильева Софья Ярославовна", "Директор", "vhalagutax@yopmail.com",
                "89515359874", 50000, 45);
        employers[1] = new Employer("Васильев Илья Артёмович", "Замдиректора", "cussolississ@yopmail.com",
                "89515471285", 50000, 46);
        employers[2] = new Employer("Кузнецова Ульяна Антоновна", "Менеджер", "awazujuj@yopmail.com",
                "89233657412", 40000, 32);
        employers[3] = new Employer("Климов Вячеслав Александрович", "Секретарь", "qemmiwari@yopmail.com",
                "89653214562", 35000, 26);
        employers[4] = new Employer("Овчинников Арсений Максимович", "Курьер", "jamaseddum@yopmail.com",
                "89651423654", 25000, 22);

        for (int i = 0; i < employers.length; i++) {
            if (employers[i].getAge() > 40) {
                employers[i].info();
            }
            System.out.println();
        }
    }

}

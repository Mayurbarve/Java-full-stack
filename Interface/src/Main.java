public class Main {
    public static void main(String[] args) {
        Laptop lap = new Laptop();
        Desktop desk = new Desktop();

        //Need of Desktop
        new Devloper().devApp(desk);

        //Need of laptop
        new Devloper().devApp(lap);
    }
}
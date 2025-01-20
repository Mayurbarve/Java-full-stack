import Banks.BOI;
import Banks.HDFC;
import Banks.PNB;
import Banks.SBI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ATM");
        Scanner in = new Scanner(System.in);

        System.out.println("|| Select Bank ||");
        System.out.print("1. HDFC ");
        System.out.print("2. SBI ");
        System.out.print("3. BOI ");
        System.out.println("4. PNB");

        System.out.print("Enter Choice: ");
        int ch = in.nextInt();

        switch (ch) {
            case 1:
                new HDFC().performOperation();
                break;
            case 2:
                new SBI().performOperation();
                break;
            case 3:
                new BOI().performOperation();
                break;
            case 4:
                new PNB().performOperation();
                break;
            default:
                System.out.println("Invalid Choice");
        }

        in.close();
    }
}

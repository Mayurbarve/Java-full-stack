import Banks.BOI;
import Banks.HDFC;
import Banks.PNB;
import Banks.SBI;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Atm");
        Scanner in = new Scanner(System.in);

        System.out.println("|| Select bank ||");
        System.out.print("1.HDFC ");
        System.out.print("2.SBI ");
        System.out.print("3.BOI ");
        System.out.println("4PNB");

        System.out.print("Enter Choice: ");
        int ch = in.nextInt();


        switch (ch){
            case 1:
                HDFC hdfc = new HDFC();
                hdfc.performOperation();
                break;
            case 2:
                SBI sbi = new SBI();
                sbi.performOperation();
                break;
            case 3:
                BOI boi = new BOI();
                boi.performOperation();
                break;
            case 4:
                PNB pnb = new PNB();
                pnb.performOperation();
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }

        in.close();
    }

}
package Operations;

import java.util.Scanner;

public class WithdrawAmount {
    public void withdrawAmount(){
        int savingAmount = 5000;
        Scanner in = new Scanner(System.in);
        int dummyPin = 7387;
        boolean authentication = false;

        System.out.print("Enter Your Pin: ");
        int pin = in.nextInt();

        if(pin == dummyPin){
            authentication = true;
        }
        else {
            System.out.println("Invalid Pin");
        }


        if(authentication){
            System.out.print("Enter amount: ");
            int enterAmount = in.nextInt();
            if(enterAmount < savingAmount){
                savingAmount -= enterAmount;
                System.out.println("Amount Withdraw Successfully");
                System.out.println("Available Balance: "+ savingAmount);
            }
            else {
                System.out.println("Exclude Amount");
            }


        }
    }
}

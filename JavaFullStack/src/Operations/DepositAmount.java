package Operations;

import java.util.Scanner;

public class DepositAmount {
    public void ShowAmount(int amount, long accountNo, boolean show){
        int savingAmount = 5000;
        long AccountNumber = 1234;

        if(show){
            System.out.println("Account Number: "+ AccountNumber);
            System.out.println("Available Balance: " + savingAmount);
        }else {
            savingAmount = amount;
            AccountNumber = accountNo;

            System.out.println("Account Number: "+ AccountNumber);
            System.out.println("Available Balance: " + savingAmount);

        }
    }

    public void depositAmount(){
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
            System.out.print("Enter Your Account Number: ");
            long accountNumber = in.nextInt();
            System.out.print("Enter Amount: ");
            int amount = in.nextInt();
            ShowAmount(amount, accountNumber, false);
            System.out.println("Amount Deposit Successfully");
        }
    }
}

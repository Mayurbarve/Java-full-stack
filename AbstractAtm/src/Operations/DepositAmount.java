package Operations;

import java.util.Scanner;

public class DepositAmount extends OperationBase {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Your Pin: ");
        int pin = in.nextInt();

        if (!authenticate(pin)) {
            System.out.println("Invalid Pin");
            return;
        }

        System.out.print("Enter Account Number: ");
        long accountNumber = in.nextLong();

        System.out.print("Enter Amount to Deposit: ");
        int amount = in.nextInt();

        System.out.println("Amount Deposited Successfully");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Updated Balance: " + (Balance + amount));
    }
}

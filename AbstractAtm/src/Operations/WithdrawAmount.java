package Operations;

import java.util.Scanner;

public class WithdrawAmount extends OperationBase {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Your Pin: ");
        int pin = in.nextInt();

        if (!authenticate(pin)) {
            System.out.println("Invalid Pin");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        int enterAmount = in.nextInt();
        if (enterAmount <= Balance) {
            Balance -= enterAmount;
            System.out.println("Amount Withdrawn Successfully");
            System.out.println("Available Balance: " + Balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

package Banks;

import Operations.BalenseQuery;
import Operations.DepositAmount;
import Operations.PinChange;
import Operations.WithdrawAmount;

import java.util.Scanner;

public class BOI implements Bank {
    @Override
    public void performOperation() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Balance Query");
        System.out.println("2. Pin Change");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Deposit Amount");

        System.out.print("Enter Choice: ");
        int ch = in.nextInt();

        switch (ch) {
            case 1:
                new BalenseQuery().execute();
                break;
            case 2:
                new PinChange().execute();
                break;
            case 3:
                new WithdrawAmount().execute();
                break;
            case 4:
                new DepositAmount().execute();
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}

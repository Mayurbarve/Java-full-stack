package Banks;

import Operations.BalenseQuery;
import Operations.DepositAmount;
import Operations.PinChange;
import Operations.WithdrawAmount;

import java.util.Scanner;

public class BOI {
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
                BalenseQuery balance = new BalenseQuery();
                balance.balenseQuery();
                break;
            case 2:
                PinChange pinChange = new PinChange();
                pinChange.pinChange();
                break;
            case 3:
                WithdrawAmount withdraw = new WithdrawAmount();
                withdraw.withdrawAmount();
                break;
            case 4:
                DepositAmount deposit = new DepositAmount();
                deposit.depositAmount();
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}

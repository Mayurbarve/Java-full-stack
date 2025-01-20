package Operations;

import java.util.Scanner;

public class BalenseQuery extends OperationBase {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Your Pin: ");
        int pin = in.nextInt();

        if (!authenticate(pin)) {
            System.out.println("Invalid Pin");
            return;
        }

        if(authenticate(pin)){
            System.out.println("Available Balance: " + Balance);
        }


    }
}

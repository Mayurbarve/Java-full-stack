package Operations;

import java.util.Scanner;

public class PinChange extends OperationBase {
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
            System.out.print("Enter your new Pin: ");
            int enterPin = in.nextInt();
            System.out.print("Reenter your pin: ");
            int RenterPin = in.nextInt();
            if(enterPin == RenterPin){
                dummyPin = enterPin;
                System.out.println("Pin Change Successfully");
                System.out.println("New Pin: "+ dummyPin);
            }

        }

    }
}
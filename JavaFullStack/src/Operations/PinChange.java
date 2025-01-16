package Operations;

import java.util.Scanner;

public class PinChange {
    public void pinChange(){
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

        int newPin = 0;

        if(authentication){
            System.out.print("Enter your new Pin: ");
            int enterPin = in.nextInt();
            System.out.print("Reenter your pin: ");
            int RenterPin = in.nextInt();
            if(enterPin == RenterPin){
                newPin = enterPin;
                System.out.println("Pin Change Successfully");
                System.out.println("New Pin: "+ newPin);
            }


        }

    }
}

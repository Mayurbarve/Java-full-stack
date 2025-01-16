package Operations;

import java.util.Scanner;

public class BalenseQuery {
    public void balenseQuery(){
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
            DepositAmount showAmount = new DepositAmount();
            showAmount.ShowAmount(0, 1, true);
        }

    }
}

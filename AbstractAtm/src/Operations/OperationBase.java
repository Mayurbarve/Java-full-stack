package Operations;

public abstract class OperationBase {
    protected int dummyPin = 7387;
    protected int Balance = 5000;

    // Common method for PIN authentication
    public boolean authenticate(int pin) {
        return pin == dummyPin;
    }

    // Abstract method for operation
    public abstract void execute();
}

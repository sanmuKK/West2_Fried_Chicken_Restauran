package assign2;

public class OverdraftBalanceException extends RuntimeException {
    public OverdraftBalanceException(double gap) {
        super();
        System.out.println("The balance is insufficient, lacking " + gap + " yuan");
    }
}

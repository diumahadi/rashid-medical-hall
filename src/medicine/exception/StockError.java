package medicine.exception;

public class StockError extends RuntimeException {

    private final String msg;

    public StockError(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
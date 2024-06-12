package Case_Study.models;

public class Contract {
    private String contractId;
    private String bookingId;
    private String customerId;
    private double depositAmount;
    private double totalAmount;

    public Contract(String contractId, String bookingId, String customerId, double depositAmount, double totalAmount) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
    }

    public String getContractId() {
        return contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return contractId + "," + bookingId + "," + customerId + "," + depositAmount + "," + totalAmount;
    }
}

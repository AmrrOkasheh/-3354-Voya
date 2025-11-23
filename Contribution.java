public class Contribution {
    private String userID;
    private double amount;

    public Contribution(String userID, double amount) {
        this.userID = userID;
        this.amount = amount;
    }

    public String getUserID() {
        return userID;
    }

    public double getAmount() {
        return amount;
    }
}

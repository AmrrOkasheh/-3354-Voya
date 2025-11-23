import java.util.Date;
import java.util.List;

public class Expense {
    private int expenseID;
    private double amount;
    private List<Contribution> contributions;

    public Expense(int expenseID, double amount, List<Contribution> contributions, Date date) {
        this.expenseID = expenseID;
        this.amount = amount;
        this.contributions = contributions;
    }

    public double getAmount() {
        return amount;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }
}

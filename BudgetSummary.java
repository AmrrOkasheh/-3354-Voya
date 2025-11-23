import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class BudgetSummary {

    double totalSpent;
    Map<String, Double> perUserContribution;

    public BudgetSummary(double totalSpent, Map<String, Double> perUserContribution)
    {
        this.totalSpent = totalSpent;
        this.perUserContribution = perUserContribution;

    }
    
    public double getTotalSpent() {
        return totalSpent;
    }
    public Map<String, Double> getPerUserContribution() {
        return perUserContribution;
    }

    public static BudgetSummary calculateTotals(List<Expense> expenses)
    {
        double total = 0.0;
        Map<String, Double> contributionsMap = new HashMap<>();

        // if we dont have any expenses in the budgetSummary default to 0 value for total spent
        if(expenses == null || expenses.isEmpty())
        {
            return new BudgetSummary(0, contributionsMap);
        }

        // if we have contributions then we have to loop through the expenses

        for (int i = 0; i < expenses.size(); i++)
        {
            Expense e = expenses.get(i);
            total += e.getAmount();

            List<Contribution> contribs = e.getContributions();
            for( int j = 0; j < contribs.size(); j++)
            {
                Contribution c = contribs.get(j);

                contributionsMap.merge(c.getUserID(), c.getAmount(), Double::sum);

            }
        }

    return new BudgetSummary(total, contributionsMap);

    }

}

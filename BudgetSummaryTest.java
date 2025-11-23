import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetSummaryTest {

    @Test
    @DisplayName("BudgetSummary calculates the totals everyone spent and everyone's contribution")
    void calculateTotals()
    {
        Contribution c1 = new Contribution("Amrr", 100);
        Contribution c2 = new Contribution("Albert", 200);
        Contribution c3 = new Contribution("Sanyukta", 300);
        Contribution c4 = new Contribution("Suhani", 400);
        Contribution c5 = new Contribution("Joyce", 500);
        Contribution c6 = new Contribution("Justin", 600);
        Contribution c7 = new Contribution("Anish", 700);

        Expense food = new Expense( 1, 800.0,   List.of(c1, c2), new Date());
        Expense Ubers = new Expense(2, 200.0,   List.of(c3, c4), new Date());
        Expense hotel = new Expense(3, 1000.0,  List.of(c5, c6, c7), new Date());

        BudgetSummary summary = BudgetSummary.calculateTotals(List.of(food, Ubers, hotel));
        assertEquals(2000.0, summary.getTotalSpent());
        assertEquals(7, summary.getPerUserContribution().size());


        assertEquals(100.0, summary.getPerUserContribution().get("Amrr"));
        assertEquals(200.0, summary.getPerUserContribution().get("Albert"));
        assertEquals(300.0, summary.getPerUserContribution().get("Sanyukta"));
        assertEquals(400.0, summary.getPerUserContribution().get("Suhani"));
        assertEquals(500.0, summary.getPerUserContribution().get("Joyce"));
        assertEquals(600.0, summary.getPerUserContribution().get("Justin"));
        assertEquals(700.0, summary.getPerUserContribution().get("Anish"));

    }
}
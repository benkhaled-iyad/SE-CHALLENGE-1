//Maachou Mohammed Imad Eddine 
//Show total function 
public class ExpenseTracker {
    public static double getTotalExpenses(double[] expenses, int month, int day) {
        double totalExpenses = 0.0;

        for (double expense : expenses) {
            // Get the month and day of the expense using a Calendar instance
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(expense.getTimestamp())); // Assuming expenses have timestamps
            int expenseMonth = calendar.get(Calendar.MONTH);
            int expenseDay = calendar.get(Calendar.DAY_OF_MONTH);

            // Check if the expense occurred in the specified month and day
            if (expenseMonth == month && expenseDay == day) {
                totalExpenses += expense.getAmount();
            }
        }

        return totalExpenses;
    }
}

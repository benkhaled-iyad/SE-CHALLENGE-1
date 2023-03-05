// Maachou Mohammed Imad Eddine 
// G6 



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExpenseTracker extends JFrame implements ActionListener {

    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel expenseLabel;
    private JTextField expenseField;
    private JButton addButton;
    private JButton calculateButton;
    private JLabel totalLabel;
    private JTextField totalField;

    private double totalExpenses;

    public ExpenseTracker() {
        setTitle("Expense Tracker");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        dateLabel = new JLabel("Enter date (MM/DD/YYYY): ");
        dateField = new JTextField(10);
        expenseLabel = new JLabel("Enter expense amount: ");
        expenseField = new JTextField(10);
        addButton = new JButton("Add");
        calculateButton = new JButton("Calculate");
        totalLabel = new JLabel("Total expenses: ");
        totalField = new JTextField(10);
        totalField.setEditable(false);

        addButton.addActionListener(this);
        calculateButton.addActionListener(this);

        add(dateLabel);
        add(dateField);
        add(expenseLabel);
        add(expenseField);
        add(addButton);
        add(calculateButton);
        add(totalLabel);
        add(totalField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String date = dateField.getText();
                double expense = Double.parseDouble(expenseField.getText());

                // Only add to total expenses if the date is within the desired time period
                if (date.equals("03/05/2023")) { // replace with desired date
                    totalExpenses += expense;
                }

                // Clear text fields
                dateField.setText("");
                expenseField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == calculateButton) {
            totalField.setText(String.format("%.2f", totalExpenses));
        }
    }

    public static void main(String[] args) {
        new ExpenseTracker();
    }
}

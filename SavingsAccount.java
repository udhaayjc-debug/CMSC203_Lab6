/*
 * Class: CMSC203
 * Instructor: Huseyin Aygun
 * 
 * Description: Lab 6 SavingsAccount subclass with monthly interest and copy constructor.
 * Due: 11/15/2026
 * 
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * 
 *  Student Name: Udhaay Jayachandran
 */

/** Represents a savings account with monthly interest and sub-account numbers. */
public class SavingsAccount extends BankAccount {

    // Annual interest rate is 2.5%.
    private double rate = 0.025;
    // Each additional savings account gets the next suffix.
    private int savingsNumber = 0;
    // Savings accounts have their own displayed number with a suffix.
    private String accountNumber;

    /**
     * Creates the first savings account for an owner.
     * @param name name of the account owner
     * @param amount starting balance
     */
    public SavingsAccount(String name, double amount) {
        super(name, amount);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /**
     * Creates another savings account for the same owner.
     * @param oldAccount savings account to copy the owner and base number from
     * @param amount starting balance of the new savings account
     */
    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount); // Reuse the owner's base account number.
        savingsNumber = oldAccount.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /** Adds one month's interest to the account balance. */
    public void postInterest() {
        // Divide the annual rate by 12 to find one month of interest.
        double monthlyInterest = getBalance() * (rate / 12);
        deposit(monthlyInterest);
    }

    /**
     * Returns the savings account number with its suffix.
     * @return displayed savings account number
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}

/*
 * Class: CMSC203
 * Instructor: Huseyin Aygun
 * 
 * Description: Lab 6 CheckingAccount subclass with a check-clearing fee.
 * Due: 11/15/2026
 * 
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * 
 * Student Name: Udhaay Jayachandran
 */

/** Represents a checking account that charges a fee when money is withdrawn. */
public class CheckingAccount extends BankAccount {

    // Every successful checking withdrawal includes a 15-cent fee.
    private static final double FEE = 0.15;

    /**
     * Creates a checking account and appends the checking suffix to its number.
     * @param name name of the account owner
     * @param amount starting balance
     */
    public CheckingAccount(String name, double amount) {
        super(name, amount); // Set up the owner, balance, and base account number.
        setAccountNumber(getAccountNumber() + "-10");
    }

    /**
     * Withdraws the requested amount plus the check-clearing fee.
     * @param amount amount requested for withdrawal
     * @return true if enough funds exist, otherwise false
     */
    @Override
    public boolean withdraw(double amount) {
        // Let BankAccount check the balance and complete the withdrawal.
        return super.withdraw(amount + FEE);
    }
}


public class SavingsAccount
{
    public SavingsAccount()
    {

    }
    public SavingsAccount(double x)
    {
        this.savingsBalance = x;
    }
    private static double annualInterestRate;
    private double savingsBalance;

    public void calculateMonthlyInterest()
    {
        this.savingsBalance += savingsBalance*annualInterestRate/12;
    }

    public static void modifyInterestRate(double newInterest)
    {
        annualInterestRate = newInterest;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }

}

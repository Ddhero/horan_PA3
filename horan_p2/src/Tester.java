public class Tester extends SavingsAccount
{

    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(.04);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Interest Rate: 4%\n");
        System.out.println("\tSaver1 Balance: $" + Math.round(saver1.getSavingsBalance()*100.0)/100.0);
        System.out.println("\tSaver2 Balance: $" + Math.round(saver2.getSavingsBalance()*100.0)/100.0);
        
        SavingsAccount.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("\nInterest Rate: 5%\n");
        System.out.println("\tSaver1 Balance: $" + Math.round(saver1.getSavingsBalance()*100.0)/100.0);
        System.out.println("\tSaver2 Balance: $" + Math.round(saver2.getSavingsBalance()*100.0)/100.0);
    }
}

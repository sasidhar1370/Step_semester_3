class PiggyBank{
    private double balance;
    private final String piggybank_id;
    public PiggyBank(String piggybank_id){
        this.balance = 0;
        this.piggybank_id = piggybank_id;
    }
    void deposit(double amount){
        if (amount > 0){
            balance += amount;
        } else {
            System.out.println("Negative amount can't be deposited");
        }
    }
    void withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
        } else {
            System.out.println("Rejected, savings stayed " + balance);
        }
    }
    void display(){
        System.out.println("Savings = " + balance);
    }
}
class ThePiggyBank{
    public static void main(String [] args){
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.display();
        pb.withdraw(30);
        pb.display();
        pb.withdraw(500);
    }
}
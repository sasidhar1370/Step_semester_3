import java.util.Scanner;
class MessWallet{
    private double balance;
    public MessWallet(double openingbalance){
        if (openingbalance > 0){
            this.balance = openingbalance;
        } else {
            System.out.println("Warning: Opening Balance can't be Negative");
            this.balance = 0.0;
        }
    }
    public void topUp(double amount){
        if (amount <= 0){
            System.out.println("Negative Amount can't be added");
        } else {
            this.balance += amount;
        }
    }
    public void deduct(double amount){
        if (amount >= this.balance){
            System.out.println("Insufficient Funds ");
        } else {
            this.balance -= amount;
        }
    }
    public double getBalance(){
        return this.balance;
    }
}
class HostelMess{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Opening Balance: ");
        double n = sc.nextDouble();
        MessWallet obj = new MessWallet(n);
        System.out.print("Enter Top-Up Amount: ");
        double top = sc.nextDouble();
        obj.topUp(top);
        System.out.print("Enter Amount To be Deducted: ");
        double deduct = sc.nextDouble();
        obj.deduct(deduct);
        System.out.println("Final balance: " + obj.getBalance());
        sc.close();
    }
}
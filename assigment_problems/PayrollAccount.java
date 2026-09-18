class PayrollAccount {
    // Private fields for encapsulation
    private double basicSalary;
    private double bonus;

    // Public constructor with opening basic salary validation
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative basic salary provided. Starting at 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    // Adds bonus if amount is greater than 0
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be greater than 0");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Reduces basicSalary by percentage if within 0 to 100 range
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: Percentage must be between 0 and 100");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Read-only getter returning basicSalary + bonus
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

class PayRoll {
    public static void main(String[] args) {
        // Instantiate account with 50000 basic salary
        PayrollAccount account = new PayrollAccount(50000);

        // Perform operations matching the PDF sample
        account.creditBonus(5000);
        account.deductTax(10);

        // Display final read-only net salary
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
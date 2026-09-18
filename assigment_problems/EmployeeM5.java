class EmployeeM5 {
    String empName;
    double salary;

    // Static fields shared across all class instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeM5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment static counter on each instantiation
    }

    // Static method accessing static data only
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

class EmployeeandCompaney {
    public static void main(String[] args) {
        // Create three separate EmployeeM5 instances
        EmployeeM5 emp1 = new EmployeeM5("Divya", 65000);
        EmployeeM5 emp2 = new EmployeeM5("Arjun", 50000);
        EmployeeM5 emp3 = new EmployeeM5("Rohan", 55000);

        // Call static method using the Class name directly
        EmployeeM5.printCompanyInfo();
    }
}
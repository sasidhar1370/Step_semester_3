class Student{
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount;
    public Student (String name, int attendance){
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }
    public static void printCollegeInfo(){
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
class StudentandCollege{
    public static void main(String [] args){
        Student stu1 = new Student("Rohith", 95);
        Student stu2 = new Student("Sai", 97);
        Student.printCollegeInfo();
    }
}
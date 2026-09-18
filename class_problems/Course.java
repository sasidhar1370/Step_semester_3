class Course{
    String code;
    String title;
    int credits;
    int labCredits;
    public Course (String code, String title, int credits, int labCredits){
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }
    public Course (String code, String title, int credits){
        this.code = code;
        this.title = title;
        this.credits = credits;
    }
    public int totalCredits(){
        return this.credits + this.labCredits;
    }
}
class CourseCredit{
    public static void main(String [] args){
        Course obj1 = new Course("21CSC201J", "Data Structures", 4);
        Course obj2 = new Course("21CSC205L", "DSA Lab", 3, 1);
        System.out.println(obj1.code + " total credits: " + obj1.totalCredits());
        System.out.println(obj2.code  + " total credits: " + obj2.totalCredits());
    }
}
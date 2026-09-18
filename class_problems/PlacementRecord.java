class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;
    public PlacementRecord(String studentName, String company, double packageLpa){
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }
    void printRecord(){
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}
class Main{
    public static void main(String []args){
        PlacementRecord[] record = new PlacementRecord[3];
        record[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        record[1] = new PlacementRecord("Anitha", "Zoho", 4.5);
        record[2] = new PlacementRecord("Karthik", "Infosys", 4.0);
        for (int i = 0; i < 3; i++){
            record[i].printRecord();
        }
    }
}
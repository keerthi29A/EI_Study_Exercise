public class AccountActivityReportGenerator  extends  AbstractReportGenerator{
    @Override
    public void selectRecords(){
        System.out.println("Selecting Account Activity for that day");
    }
    @Override
    public void generateReport(){
        System.out.println("Generate Account Activity report for that day");
    }
}

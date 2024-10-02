public class UserReportGenerator extends AbstractReportGenerator {
    @Override
    public void selectRecords() {
        System.out.println("Selecting new user records..");
    }
    @Override
    public void generateReport() {
        System.out.println("Generating newly joined user records..");
    }
}

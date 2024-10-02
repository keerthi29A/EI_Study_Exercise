public abstract class AbstractReportGenerator {
    public void makeDBConnection(){
        System.out.println("Connecting to database...");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public abstract void generateReport();
    public abstract void selectRecords();
    public void closeDBConnection(){
        System.out.println("Closing connection...");
        System.out.println("......report generation completed........");
    }
    public final void run(){
        makeDBConnection();
        selectRecords();

        generateReport();
        closeDBConnection();
    }
}

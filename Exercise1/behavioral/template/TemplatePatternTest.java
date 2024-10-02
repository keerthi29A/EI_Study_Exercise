public class TemplatePatternTest {
    public static void main(String[] args) {
        AbstractReportGenerator usersReportGenerator = new UserReportGenerator();
        usersReportGenerator.run();

        AbstractReportGenerator accountActivityReportGenerator = new AccountActivityReportGenerator();
        accountActivityReportGenerator.run();

    }
}

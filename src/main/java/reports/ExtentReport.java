package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    private ExtentReport(){

    }
    private static ExtentReports reports;

    public static void initReports(){
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        spark.config().setDocumentTitle("RestAssuredAutomationProject");
        spark.config().setReportName("Pet Store API");
        reports.attachReporter(spark);
        reports.setSystemInfo("Application", "Pet Store API");
    }

    public static void tearDownReports(){
        reports.flush();
    }

    public static void createTest(String name){
        ExtentTest test = reports.createTest(name);
        ExtentManager.setTest(test);
    }

    public static void addAuthor(String[] authors){
        for(String author : authors){
            ExtentManager.getTest().assignAuthor(author);
        }
    }

    public static void addCategoty(String[] categories){
        for(String category : categories){
            ExtentManager.getTest().assignCategory(category);
        }
    }
}

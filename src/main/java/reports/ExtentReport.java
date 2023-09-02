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
        reports.attachReporter(spark);
    }

    public static void tearDownReports(){
        reports.flush();
    }

    public static void createTest(String name){
        ExtentTest test = reports.createTest(name);
        ExtentManager.setTest(test);
    }
}

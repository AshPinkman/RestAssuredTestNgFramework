package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){

    }

    private static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();

    static ExtentTest getTest(){
        return extest.get();
    }

    static void setTest(ExtentTest test){
        extest.set(test);
    }

}

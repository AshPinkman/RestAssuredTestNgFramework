package reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

    private ExtentLogger(){

    }

    public static void pass(String message){
        ExtentManager.getTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void skip(String message){
        ExtentManager.getTest().skip(message);
    }

    public static void logResponse(String message){
        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }

}

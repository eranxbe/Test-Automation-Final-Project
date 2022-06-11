package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {

    public void onStart(ITestContext arg0) {
        System.out.println("---------- EXECUTION STARTED ----------");
    }

    public void onFinish(ITestContext arg0) {
        System.out.println("---------- EXECUTION FINISHED ----------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("--------- STARTING TEST: " + test.getName() + " ----------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("--------- TEST " + test.getName() +  " PASSED ----------");
        if (!platform.equalsIgnoreCase("api") && !platform.equalsIgnoreCase("mobile")) {
            //Stop recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            //Delete recording
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            System.out.println((file.delete()) ? "Successfully deleted recording" : "Failed to delete recording");
        }

    }


    public void onTestFailure(ITestResult test) {
        System.out.println("##### TEST " + test.getName() + " FAILED #####");
        if (!platform.equalsIgnoreCase("api") && !platform.equalsIgnoreCase("mobile")) {
            //Stop recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            saveScreenshot();
        }

    }
    public void onTestSkipped(ITestResult test) {
        System.out.println("--------- SKIPPING TEST: " + test.getName() + " ----------");

    }

        public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        //TODO implement this
    }


    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

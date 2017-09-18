package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static core.GridDriver.driver;

public class TestListener implements ITestListener{

    public TestListener() {
        super();
    }

    @Attachment(value = "Attach screenshot ", type = "image/png")
    public void makeScreenshot() {
        driver = new Augmenter().augment(driver);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("test-output\\" + ".png").getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}


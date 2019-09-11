package PageOperations;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static TestAndroidOrIOS.AppiumMobileAndroid.appiumDriver;
import static TestAndroidOrIOS.AppiumMobileAndroid.stringValue;


public class PageOperation {
    protected static WebDriverWait wait;
    private static WebDriver webDriver;
    private static int waitTime = 10;
    private static WebElement selectValue;
    private static String methodScore = "random";
    private static String text;
    private static String nameElementOnPage;
    private static String element;

    protected static ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {

                WebElement element = driver.findElement(by);
                SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy_HH_mm_ss");
                String date = sdf.format(new Date());
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid blue'", element);
                // Get element informations for log
                String el_text = element.toString();
                String elment_Info = el_text.substring(el_text.indexOf('-') + 1);
                Reporter.log("<br> </b><details><summary><b>" + elment_Info.substring(0, elment_Info.length() - 1)
                        + "</summary> </b><br>");

                // Create screenshot PNG
                File file = new File("");
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(scrFile, new File(file.getAbsolutePath() + "\\screenshots\\" + date + ".png"));
                    // Show image in report
                    Reporter.log(" <img src=..\\screenshots\\" + date + ".png" + " style=\"width:30%;\""
                            + "onclick=\"this.style.width='100%'\" " + "ondblclick=\"this.style.width='30%'\""
                            + " /> <br> </details></b>");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return element.isDisplayed() ? element : null;
            }
        };
    }


    public static WebElement byId(String id, String text) {
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Reporter.log(" <br><b>" + text + " </b>");
        stringValue = appiumDriver.findElement(By.id(id));
        return stringValue;
    }

    public static WebElement byName(String name, String text) {
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Reporter.log(" <br><b>" + text + " </b>");
        stringValue = appiumDriver.findElement(By.name(name));
        return stringValue;
    }

    public static WebElement byXpath(String xpath, String text) {
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Reporter.log(" <br><b>" + text + " </b>");
        stringValue = appiumDriver.findElement(By.xpath(xpath));
        return stringValue;
    }

}

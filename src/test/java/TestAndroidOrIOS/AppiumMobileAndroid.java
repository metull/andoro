package TestAndroidOrIOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static SetterAndGetter.SettersAndGetters.*;


public class AppiumMobileAndroid {

    public static AppiumDriver appiumDriver;

    {
        try {
            appiumDriver = getAppiumDriver("Android", new URL("http://127.0.0.1:4723/wd/hub"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static String emulatorUDID = "192.168.223.105:5555";  //"475297e2";
    private static String platformVersion = "7.0";
    public static WebElement stringValue;
    private static WebDriverWait wait;


    @BeforeClass
    public static void setUpSettings() {
        setuDID(emulatorUDID);
        setPlatfiormVerison(platformVersion);
    }


    private AppiumDriver getAppiumDriver(String platform, URL serverUrl) {
//        return platform.equals("iOS") ? getIOSDriver(serverUrl) : getAndroidDriver(serverUrl);
        return getAndroidDriver(serverUrl);
    }

    private AppiumDriver getIOSDriver(URL serverUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
//
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
//        capabilities.setCapability(MobileCapabilityType.UDID, "F97C79FE-5F55-4CE3-BA88-9351B7A9421F");
//
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
//
//        capabilities.setCapability("showXcodeLog", "true");
//        capabilities.setCapability("autoAcceptAlerts", "true");

        return new IOSDriver(serverUrl, capabilities);
    }

    private AppiumDriver getAndroidDriver(URL serverUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S8 Build");
        capabilities.setCapability(MobileCapabilityType.UDID, getuDID());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getPlatfiormVerison());
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        /**
         * Версия браузера на телефоне 75.0.3770.143
         * Версия браузера на эмуляторе 71.0.3578.99-357809912_minAPI24(x86)
         */
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\User\\Web Appium\\chromedriver.exe");

//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
//        capabilities.setCapability("appPackege", "com.android.chrome");
//            capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");

//            capabilities.setCapability("showXcodeLog", "true");
//            capabilities.setCapability("autoAcceptAlerts", "true");
//            capabilities.setCapability("showChromedriverLog", "true");
//            capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\User\\Web Appium\\chrome-75-0-3770-143.apk");

        return new AndroidDriver(serverUrl, capabilities);
    }


}

package CheckProfile.TestOfflineProfile;

import com.jcraft.jsch.agentproxy.Connector;
import cucumber.api.java.mn.Гэхдээ;
import io.qameta.allure.Attachment;
import junit.framework.Assert;
import okhttp3.*;
import org.apache.maven.plugins.annotations.Component;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.verify.Verify;
import test.verify.VerifyTest;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;

import static CheckProfile.GeneralData.AllParameters.EndPoints.*;
import static com.jayway.restassured.RestAssured.expect;

public class Test1 {

    @Attachment(value = "Отправляемое тело запроса.", type = "application/json")
    public String getJsonRequest(String request) {
        return request;
    }

    @Attachment(value = "Полученый ответ от сервера", type = "application/json")
    public String getResponse(String response) {
        return response;
    }

    /**
     * @Test public void getOrder() {
     * response =
     * expect()
     * .statusCode(200)
     * .given()
     * .contentType("text/xml, charset=UTF=8")
     * .header("Accept-Language", "ru")
     * .header(cachControl, "no-cache")
     * .header("authorization", authorization)
     * .header("Accept-Encoding", "deflate;q=0.5,gzip;q=0.5,identity")
     * .log().all()
     * .body("<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
     * "   <soapenv:Header/>" +
     * "   <soapenv:Body>" +
     * "      <getOrder soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
     * "         <data xsi:type=\"ord:getOrderRequest\" xmlns:ord=\"http://test.direct-credit.ru/soap/orders\">" +
     * "               <partner_id xsi:type=\"xsd:int\">1316853</partner_id>" +
     * "            <order_id xsi:type=\"xsd:string\">ORD7989532588</order_id>" +
     * "         </data>" +
     * "      </getOrder>" +
     * "   </soapenv:Body>" +
     * "</soapenv:Envelope>")
     * .log().ifValidationFails()
     * .post("http://test.direct-credit.ru/soap/service/mvideo/index.php");
     * responseBody = response.getBody().asString();
     * System.out.println("Ответ сервера ");
     * System.out.println(responseBody);
     * }
     */
    public static void main(String[] args)
    {
        // simple page (without many resources so that the output is
        // easy to understand
        String url = "http://www.york.ac.uk/teaching/cws/wws/webpage1.html";

        DownloadPage(url);
    }

    private static void DownloadPage(String url)
    {
        ChromeDriver driver = null;

        try
        {
            ChromeOptions options = new ChromeOptions();
            // add whatever extensions you need
            // for example I needed one of adding proxy, and one for blocking
            // images
            // options.addExtensions(new File(file, "proxy.zip"));
            // options.addExtensions(new File("extensions",
            // "Block-image_v1.1.crx"));

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, options);

            // set performance logger
            // this sends Network.enable to chromedriver
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

            driver = new ChromeDriver(cap);

            // navigate to the page
            System.out.println("Navigate to " + url);
            driver.navigate().to(url);

            // and capture the last recorded url (it may be a redirect, or the
            // original url)
            String currentURL = driver.getCurrentUrl();

            // then ask for all the performance logs from this request
            // one of them will contain the Network.responseReceived method
            // and we shall find the "last recorded url" response
            LogEntries logs = driver.manage().logs().get("performance");

            int status = -1;

            System.out.println("\nList of log entries:\n");

            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
            {
                LogEntry entry = it.next();

                try
                {
                    JSONObject json = new JSONObject(entry.getMessage());

                    System.out.println(json.toString());

                    JSONObject message = json.getJSONObject("message");
                    String method = message.getString("method");

                    if (method != null
                            && "Network.responseReceived".equals(method))
                    {
                        JSONObject params = message.getJSONObject("params");

                        JSONObject response = params.getJSONObject("response");
                        String messageUrl = response.getString("url");

                        if (currentURL.equals(messageUrl))
                        {
                            status = response.getInt("status");

                            System.out.println(
                                    "---------- bingo !!!!!!!!!!!!!! returned response for "
                                            + messageUrl + ": " + status);

                            System.out.println(
                                    "---------- bingo !!!!!!!!!!!!!! headers: "
                                            + response.get("headers"));
                        }
                    }
                } catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("\nstatus code: " + status);
        } finally
        {
            if (driver != null)
            {
                driver.quit();
            }
        }
    }

}

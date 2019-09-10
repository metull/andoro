package CheckProfile.GeneralData;

import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static CheckProfile.GeneralData.Data.randomPhone;
import static CheckProfile.GeneralData.SetterAndGetter.*;
import static CheckProfile.GeneralData.SqlRequest.getValueOfTable;


public class AllParameters {

    public static class EndPoints {

        public static String number = randomPhone(10);
        public static String numberOffline = randomPhone(10);
        public static JsonObject jsonObject;
        public static LocalDate localDateTime;
        public static String valueTrue = "true";
        public static String valueFalse = "false";
        public static String phpSessId = "PHPSESSID=";
        public static String responseBody;
        public static String txt = "text.txt";
        public static String result;
        public static String date;
        public static String send;
        public static String getPhpSessId = "PHPSESSID=hibkgq6oommu9k411849nn0nb7;";
        public static String zero = ".0000";
        public static String get;
        public static String getValueOfTable;
        public static Response response;
        public static String message;
        public static String step1 = "step1/save&token=";
        public static String step2 = "step2/save&token=";
        public static String step3 = "step3/save&token=";
        public static String other = "other/save&json=Y&order_id=";
        public static String social = "social/print-agreement&json=Y&order_id=";
        public static String additional = "additional/save&json=Y&order_id=";
        public static String profile = "profile/save&json=Y&order_id=";
        public static String englishAlphabet = "english";
        public static String russiaAlphabet = "ффывва";
        public static String jsonOrderID = "&json=Y&order_id=";
        public static String BasePath = "https://lk-test.direct-credit.ru/api/widget.php?action=";
        public static String smsCheck = "sms/check&token=";
        public static String BasePathOffline = "https://lk-test.direct-credit.ru/order_new/?action=";
        public static String assessment = "assessment/save&json=Y&order_id=";
        public static String createNewOrder = "http://test.direct-credit.ru/soap/service/ozon/index.php";
        public static String createOfflineOrder = "https://lk-test.direct-credit.ru/order_new/?action=cart/save&json=Y";
        public static String getSmsCodeLink = "https://lk-test.direct-credit.ru/api/widget.php?phone_mobile=(996)%20960-2297&no_check_count=false&ad_subscribe=true&sms_mode=first&form=%5Bobject%20Object%5D&action=sms/send&token=&json=Y&order_id=";
        public static String type = "text/xml";
        public static String cachControl = "Cache-Control";
        public static String JSON = "application/json";
        public static String authorization = "Basic bTIzMXYzNDNpNTkxZDc4M2U3NG83NzM6cWw3eTIxbjZrZmhsejlzczYxbTJmZnFqcmM1";
        public static String username = "dc_bitrix";
        public static String password = "a90~q~u%@PXwA6M#";
        public static final String url = "jdbc:mysql://localhost:6033/dc_bitrix?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

        public static String getCustomerProfileIOfSQLRequest() throws SQLException, IOException {
            String customerProfileID = getValueOfTable("select " + getCustomerProfileIdBD() + " from " + table_dc_order + " where " + getOrderNumber() + " = \"numberOrder" + getNumberOrderOfFile() + "\";");
            return customerProfileID;
        }

        public static String getTokenOfFile() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("token.txt")));
            String token = bufferedReader.readLine();
            return token;
        }

        public static String getIdOrderOfFile() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("idOrder.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getOrderIdOfflineOfFile() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("orderIdOffline.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getPhpSessId() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("PHPSESSID.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile1() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder1.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile2() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder2.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile3() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder3.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile4() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder4.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile5() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder5.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOfflineOrderOfFile6() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOfflineOrder6.txt")));
            String id = bufferedReader.readLine();
            return id;
        }

        public static String getNumberOrderOfFile() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("numberOrder.txt")));
            String number = bufferedReader.readLine();
            return number;
        }

        public static String getNowDate() {
            Date today = new Date();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
            date = DATE_FORMAT.format(today);
            return date;
        }

        public static String formateDateYyyMmDd() {
            Date needDate = new Date();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");
            date = DATE_FORMAT.format(needDate);
            return date;
        }

        public static String getDate100YearsLast() {
            localDateTime = LocalDate.now().minusYears(100);
            date = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

        public static String getDate100YearAnd1dayLast() {
            localDateTime = LocalDate.now().minusYears(100).minusDays(1);
            date = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

        public static String getDate18YearsLastAnd1Day() {
            localDateTime = LocalDate.now().minusYears(18).plusDays(1);
            date = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

        public static String getDate18YearsLast() {
            localDateTime = LocalDate.now().minusYears(18);
            date = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

        public static String getDateTomorrow() {
            localDateTime = LocalDate.now().plusDays(1);
            date = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

    }
}


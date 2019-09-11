package CheckProfile.GeneralData;

import java.io.IOException;

import static CheckProfile.GeneralData.AllParameters.EndPoints.*;
import static CheckProfile.GeneralData.Data.*;
import static CheckProfile.GeneralData.SetterAndGetter.*;

public class JsonBody {
    //            Положительные кейсы. Отправка запросов в нужной последовательности и верными параметрами.
    public static class sendTrueBody {


        public static String bodyCreatNewOdderWithoutProduct;

        static {
            try {
                bodyCreatNewOdder = "" +
                        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ord=\"http://dcsoap.direct-credit.ru/orders\">" +
                        "   <soapenv:Header/>" +
                        "   <soapenv:Body>" +
                        "      <ord:createOrder>" +
                        "         <ord:data>" +
                        "            <ord:partnerID>340466701</ord:partnerID>" +
                        "            <ord:order>numberOrder" + getNumberOrderOfFile() + "</ord:order>" +
                        "            <ord:codeTT>3</ord:codeTT>" +
                        "        </ord:data>" +
                        "     </ord:createOrder>" +
                        "   </soapenv:Body>" +
                        "</soapenv:Envelope>";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static String bodyCreatNewOdder;

        static {
            try {
                bodyCreatNewOdder = "" +
                        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ord=\"http://dcsoap.direct-credit.ru/orders\">" +
                        "   <soapenv:Header/>" +
                        "   <soapenv:Body>" +
                        "      <ord:createOrder>" +
                        "         <ord:data>" +
                        "            <ord:partnerID>11655</ord:partnerID>" +
                        "            <ord:order>numberOrder" + getNumberOrderOfFile() + "</ord:order>" +
                        "            <ord:codeTT>3</ord:codeTT>" +
                        " <ord:goods>" +
                        "               <ord:id>1234</ord:id>" +
                        "               <ord:name>Товар Для заказа в Озоне</ord:name>" +
                        "               <ord:price>35000.00</ord:price>" +
                        "               <ord:quantity>1</ord:quantity>" +
                        "               <ord:type>телефоны iphone</ord:type>" +
                        "            </ord:goods>" +
                        "        </ord:data>" +
                        "     </ord:createOrder>" +
                        "   </soapenv:Body>" +
                        "</soapenv:Envelope>";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String createNewOfflineOrder;

        static {
            try {
                createNewOfflineOrder = "{" +
                        "\"order\":{" +
                        "\"order_number\":\"" + getNumberOfflineOrderOfFile() + "1" + "\"," +
                        "\"outlet_store\":\"" + getOutlet_store() + "\"" +
                        "}," +
                        "\"goods\":[{" +
                        "\"name\":\"" + getProduct_name() + "\"," +
                        "\"type_of_goods_id\":\"4\"," +
                        "\"price\":\"" + getPrice() + "\"," +
                        "\"quantity\":\"1\"" +
                        "}]" +
                        "}";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String createOrderOfflineWithoutOrderName = "{" +
                "\"order\":{" +
                "\"order_number\":\"\"," +
                "\"outlet_store\":\"" + getOutlet_store() + "\"" +
                "}," +
                "\"goods\":[{" +
                "\"name\":\"" + getProduct_name() + "\"," +
                "\"type_of_goods_id\":\"4\"," +
                "\"price\":\"" + getPrice() + "\"," +
                "\"quantity\":\"1\"" +
                "}]" +
                "}";

        public static String createOrderOfflineWithoutOutletStore;

        static {
            try {
                createOrderOfflineWithoutOutletStore = "{" +
                        "\"order\":{" +
                        "\"order_number\":\"" + getNumberOfflineOrderOfFile() + "2" + "\"," +
                        "\"outlet_store\":\"\"" +
                        "}," +
                        "\"goods\":[{" +
                        "\"name\":\"" + getProduct_name() + "\"," +
                        "\"type_of_goods_id\":\"4\"," +
                        "\"price\":\"" + getPrice() + "\"," +
                        "\"quantity\":\"1\"" +
                        "}]" +
                        "}";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String createOrderOfflineWithoutNameProduct;

        static {
            try {
                createOrderOfflineWithoutNameProduct = "{" +
                        "\"order\":{" +
                        "\"order_number\":\"" + getNumberOfflineOrderOfFile() + "3" + "\"," +
                        "\"outlet_store\":\"" + getOutlet_store() + "\"" +
                        "}," +
                        "\"goods\":[{" +
                        "\"name\":\"\"," +
                        "\"type_of_goods_id\":\"4\"," +
                        "\"price\":\"" + getPrice() + "\"," +
                        "\"quantity\":\"1\"" +
                        "}]" +
                        "}";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String createOrderOfflineWithoutTypeProduct;

        static {
            try {
                createOrderOfflineWithoutTypeProduct = "{" +
                        "\"order\":{" +
                        "\"order_number\":\"" + getNumberOfflineOrderOfFile() + "4" + "\"," +
                        "\"outlet_store\":\"" + getOutlet_store() + "\"" +
                        "}," +
                        "\"goods\":[{" +
                        "\"name\":\"" + getProduct_name() + "\"," +
                        "\"type_of_goods_id\":\"\"," +
                        "\"price\":\"" + getPrice() + "\"," +
                        "\"quantity\":\"1\"" +
                        "}]" +
                        "}";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String createOrderOfflineWithoutCosts;

        static {
            try {
                createOrderOfflineWithoutCosts = "{" +
                        "\"order\":{" +
                        "\"order_number\":\"" + getNumberOfflineOrderOfFile() + "5" + "\"," +
                        "\"outlet_store\":\"" + getOutlet_store() + "\"" +
                        "}," +
                        "\"goods\":[{" +
                        "\"name\":\"" + getProduct_name() + "\"," +
                        "\"type_of_goods_id\":\"4\"," +
                        "\"price\":\"\"," +
                        "\"quantity\":\"1\"" +
                        "}]" +
                        "}";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String bodySms = "" +
                "{" +
                "\"phone_mobile\":\"(996) 960-2297\"," +
                "\"sms_code\":\"111111\"," +
                "\"ad_subscribe\":true" +
                "}";

        public static String sendProfileOffline = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendStepProfileOfflineWithoutSex = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendStepProfileOfflineWithoutSocialStatus = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendStepProfileOfflineWithoutBirthday = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflinelhPLvIuA = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"lhPLvIuA\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendOfflineGetDate100YearsLast = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getDate100YearsLast() + "\"" +
                "}" +
                "}";

        public static String sendOfflineGetDate100YearAnd1dayLast = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getDate100YearAnd1dayLast() + "\"" +
                "}" +
                "}";

        public static String sendOfflineGetDate18YearsLastAnd1Day = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getDate18YearsLastAnd1Day() + "\"" +
                "}" +
                "}";

        public static String sendOfflineGetDate18YearsLast = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getDate18YearsLast() + "\"" +
                "}" +
                "}";

        public static String sendOfflineGetDateTomorrow = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"birthday\":\"" + getDateTomorrow() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOffline0vxo1sNN = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"0vxo1sNN\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflinemtsip2 = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"mtsip2\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflineokcnc8te = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"okcnc8te\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflinemtsowner = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"mtsowner\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflinebX2QDLZE = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"bX2QDLZE\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflineJ6VBpaeU = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"J6VBpaeU\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOffline1r8IYIt8 = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"1r8IYIt8\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflineDrBuzeAn = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"DrBuzeAn\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String sendSocialStausOfflinerQrxbFSC = "" +
                "{" +
                "\"person\":{" +
                "\"sex\":\"" + getSex() + "\"," +
                "\"social_status\":\"rQrxbFSC\"," +
                "\"birthday\":\"" + getBirthday() + "\"" +
                "}" +
                "}";

        public static String getSmsCode = "" +
                "{" +
                "\"phone_mobile\":\"(996) 960-2297\"," +
                "\"sms_mode\":1" +
                "}";

        public static String sendSmsCode = "" +
                "{" +
                "\"phone_mobile\":\"(996) 960-2297\"," +
                "\"sms_code\":\"111111\"" +
                "}";

        public static String sendPersonalData = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataHyphenatedSurname = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "-" + getLast_name() + "-" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithSimbolsInlastName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + manyRandomSimbols(3) + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithSimbolsInFirstName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + manyRandomSimbols(3) + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithSimbolsInSecondName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + manyRandomSimbols(3) + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataHyphenatedFirstName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "-" + getFirst_name() + "-" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataHyphenatedSecondName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getFirst_name() + "-" + getFirst_name() + "-" + getFirst_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutLastName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithEnglishSimbolsInLastName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + randomEnglString(5) + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithEnglishSimbolsInFirstName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + randomEnglString(5) + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutFirstName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutSecondName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithEnglishSimbolsInSecondName = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + randomEnglString(5) + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutSerialAndNumberPassport = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWith0SerialAndNumberPassport = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"0000 000000\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataSerialAndNumberPassportOfflineThroughSpace = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"2423 34 433\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutDateIssue = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutEmail = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";


        public static String sendStepPersonalDataWithEmailRussianSimbols = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"dsfsdafвыаваф@agadsgasr.ru\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutPhone = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithoutMonthlyIncome = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendStepPersonalDataWithMonthlyIncomeIN8Simbols = "" +
                "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"," +
                "\"monthly_income\":12345678" +
                "}," +
                "\"phones\":{" +
                "\"email\":\"" + getEmail() + "\"," +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String sendAdditionalData = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendSubdivisionCodeOffline000001 = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"000-001\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendSubdivisionCodeOffline000455 = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"000-455\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendSubdivisionCodeOfflineRandom1 = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + randomPhone(3) + "-" + randomPhone(3) + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendSubdivisionCodeOfflineRandom2 = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + randomPhone(3) + "-" + randomPhone(3) + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWith200Simbols = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(200) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWith2Simbols = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(2) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWithSpacesAndHyphen = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(5) + " " + randomString(5) + "-" + randomString(5) + " " + randomString(5) + "- " + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWith201Simbols = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(201) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWithHyphen = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + "-" + randomString(44) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWithEnglishSimbols = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(31) + randomEnglString(5) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendBirthplaceOfflineWithEnglishSimbols = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(31) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + randomEnglString(5) + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendBirthplaceOfflineWithHyphen = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(31) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "-" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendIssuedPassportOfflineWith1Simbols = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + randomString(1) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendSocialData = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWitCostPlus1 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"130001\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithMotherLastNameWithEnglishSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + randomEnglString(5) + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";


        public static String sendStepSocialDataWithLastNameContactThroughHyphen = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "-" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithFirstNameContactThroughHyphen = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "-" + getLast_name_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithSecondNameContactThroughHyphen = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "-" + getLast_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithLastNameContactWithEnglishSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + randomEnglString(5) + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithFirstNameContactWithEnglishSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + randomEnglString(5) + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithSecondNameContactWithEnglishSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + randomEnglString(5) + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithSecondNameContactWithSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + manyRandomSimbols(5) + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithFirstNameContactWithSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + manyRandomSimbols(5) + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithLastNameContactWithSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + manyRandomSimbols(5) + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithCompanyNameWithEnglishSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + randomEnglString(5) + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepSocialDataWithCompanyNameWithSimbols = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + manyRandomSimbols(15) + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOfflineiMX4K9nC = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"iMX4K9nC\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOffline864JGulJ = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"864JGulJ\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOfflinejcolhX0Z = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"jcolhX0Z\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOfflinejjqjrJTK = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"jjqjrJTK\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOfflinetFQILYCv = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"tFQILYCv\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOffline57Paul47 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"57Paul47\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOffline8IDMA3HA = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"8IDMA3HA\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendEducationOfflinenI429G0N = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"nI429G0N\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOffline9JL0CJaJ = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"9JL0CJaJ\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineYbZ9AkwY = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"YbZ9AkwY\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";


        public static String sendBusinessTypeOfflineGYwOPZHc = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"GYwOPZHc\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinezfKLutAC = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"zfKLutAC\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinespZgk3vs = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"spZgk3vs\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineTLnIGYrA = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"TLnIGYrA\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineMZHlWynW = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"MZHlWynW\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineT3eM0HYh = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"T3eM0HYh\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineMRDuHN8B = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"MRDuHN8B\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineRI4dVLx7 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"RI4dVLx7\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineqUvTRUyI = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"qUvTRUyI\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineSXSvcWC0 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"SXSvcWC0\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinebUvScCuH = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"bUvScCuH\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineg8sPMDIf = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"g8sPMDIf\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineYwy3KLwt = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"Ywy3KLwt\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineQdOlqnJy = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"QdOlqnJy\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineGBE8nNMU = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"GBE8nNMU\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOffline7hOyZaSi = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"7hOyZaSi\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineV9SXT6aF = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"V9SXT6aF\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineSdvuwza2 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"Sdvuwza2\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOffliner9v180sZ = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"r9v180sZ\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinegusuzCJ6 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"gusuzCJ6\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinexomrEYGH = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"xomrEYGH\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinewqLuaWF5 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"wqLuaWF5\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineURpGBtDS = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"URpGBtDS\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinekiZh51bJ = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"kiZh51bJ\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOffline3CQJza5Y = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"3CQJza5Y\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinePmApfVXO = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"PmApfVXO\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineXrsTOwWt = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"XrsTOwWt\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineCFgxtHBa = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"CFgxtHBa\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineyi2BL42u = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"yi2BL42u\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinezp9P7jO8 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"zp9P7jO8\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflineLFKbshBl = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"LFKbshBl\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinemtschymistry = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"mtschymistry\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinemtsenergy = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"mtsenergy\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinemtsconstrmaterials = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"mtsconstrmaterials\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinemtslogistics2 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"mtslogistics2\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinemtsseo = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"mtsseo\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeOfflinemtsaudit = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"mtsaudit\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeOfflinerZ0E4mZP = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"rZ0E4mZP\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeOfflinecEGMbybk = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"cEGMbybk\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeOfflinenbzIyADA = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"nbzIyADA\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeOfflinemjwE1TnM = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"mjwE1TnM\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeOfflineau38D9bk = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"au38D9bk\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOffline7q9E0NKr = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"7q9E0NKr\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflineLnxmURg4 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"LnxmURg4\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinelR4v6uLT = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"lR4v6uLT\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinevDPgw1Q6 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"vDPgw1Q6\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflineC7ZMgbyc = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"C7ZMgbyc\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflineOVOxPkpx = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"OVOxPkpx\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinerDzqPVJr = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"rDzqPVJr\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinexKraP9DQ = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"xKraP9DQ\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOffline0LilZJnc = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"0LilZJnc\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflineekYxqj5U = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"ekYxqj5U\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOffline81dEVcZS = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"81dEVcZS\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinesDTKdM7Z = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"sDTKdM7Z\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinemtsgrandchild = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"mtsgrandchild\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOfflinemtsgrandchild2 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"mtsgrandchild2\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinenR9SpJQI = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"nR9SpJQI\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinelMuGGgHq = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"lMuGGgHq\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOffline2VHwUFwG = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"2VHwUFwG\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinecg45v345fdgc = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"cg45v345fdgc\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinec45cg845hhh = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"c45cg845hhh\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinecfg42g57b67 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"cfg42g57b67\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinen545cvb7u567 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"n545cvb7u567\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinen8i57kv4f5fr = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"n8i57kv4f5fr\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinecu28cr203u93 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"cu28cr203u93\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinexm3e1019fd21 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"xm3e1019fd21\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflined289dh1h21 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"d289dh1h21\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinecn19cby9132 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"cn19cby9132\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOfflinec18761cb19e9 = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"c18761cb19e9\"" +
                "}" +
                "}";

        public static String sendCustomerEstimateOffline3cn139cb12hmi = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"3cn139cb12hmi\"" +
                "}" +
                "}";

        public static String sendMaritalStatusOfflineADoBCpAh = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"ADoBCpAh\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatusOfflineXCuGVp6h = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"XCuGVp6h\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatusOfflinepfQr7U3s = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"pfQr7U3s\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatusOffline0LqzSuFm = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"0LqzSuFm\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"," +
                "\"relation_degree\":\"" + getRelation_degree() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318217\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendStepOther = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherWithLastNameContactThroughHyphen = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "-" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherWithFirstNameContactThroughHyphen = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "-" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherWithSecondNameContactThroughHyphen = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "-" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherWithLastNameContactWithEnglishSimbols = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + randomEnglString(5) + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherWithFirstNameContactWithEnglishSimbols = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + randomEnglString(5) + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherSecondFirstNameContactWithEnglishSimbols = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + randomEnglString(5) + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherUtilitiesMonthlyPayments = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"130000\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherUtilitiesMonthlyPaymentsPlus1 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"130003\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherUtilitiesMonthlyPayments10 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"1234567890\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendStepOtherFamilyMonthlyIncome = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":129000," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendEmployeesOffline1LwmhdES = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"1LwmhdES\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendEmployeesOfflinea2C9ZNqu = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"a2C9ZNqu\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendEmployeesOfflineBK5XTLyG = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"BK5XTLyG\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendEmployeesOfflinemts500 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"" + getCountry_of_birth() + "\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"mts500\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineNjBlOWM5 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"NjBlOWM5\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineYzMzZDI5 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"YzMzZDI5\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineOTQwOTM4 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"OTQwOTM4\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflinezYjEyYmU = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"zYjEyYmU\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineYjlmODU0 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"YjlmODU0\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineNTk0ODk3 = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"NTk0ODk3\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineMzFkYWUy = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"MzFkYWUy\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineZGMyYmMw = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"ZGMyYmMw\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineMDYxMGIy = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"MDYxMGIy\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineMTZiNTIw = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"MTZiNTIw\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflineYyOWVlYz = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"YyOWVlYz\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendCountryOfBirthOfflinemts_sssr = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"mts_sssr\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"" + getJoint_residence() + "\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendJointResidencexlmofxwaForVostochkaBank = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"mts_sssr\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"xlmofxwa\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendJointResidencenaZd4QZ1ForVostochkaBank = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"mts_sssr\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"naZd4QZ1\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendJointResidenceczlHm2AvForVostochkaBank = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"mts_sssr\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"czlHm2Av\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendJointResidenceVHRDxjmCForVostochkaBank = "" +
                "{" +
                "\"passport\":{" +
                "\"country_of_birth\":\"mts_sssr\"," +
                "\"is_passport_change\":false," +
                "\"change_last_name\":false" +
                "}," +
                "\"family\":{" +
                "\"family_monthly_income\":" + getFamily_monthly_income() + "," +
                "\"utilities_monthly_payments\":\"" + getUtilities_monthly_payments() + "\"," +
                "\"loans_monthly_payments\":" + getLoans_monthly_payments() + "," +
                "\"compulsory_monthly_payments\":" + getCompulsory_monthly_payments() + "," +
                "\"dependents\":\"" + getDependents() + "\"," +
                "\"joint_residence\":\"VHRDxjmC\"," +
                "\"auto_exist\":false," +
                "\"is_real_estate\":false" +
                "}," +
                "\"work\":{" +
                "\"employees\":\"" + getEmployees() + "\"," +
                "\"leader_name\":\"" + getLeader_name() + "\"," +
                "\"emp_inn\":\"\"," +
                "\"max_monthly_payment\":" + getMax_monthly_payment() + "," +
                "\"last_name_contact_add\":\"" + getLast_name_contact_add() + "\"," +
                "\"name_contact_add\":\"" + getName_contact_add() + "\"," +
                "\"second_name_contact_add\":\"" + getSecond_name_contact_add() + "\"," +
                "\"phone_contact_add\":\"" + getPhone_contact_add() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatusOffline5KvUof3u = "" +
                "{" +
                "\"family\":{" +
                "\"education\":\"" + getEducation() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"spouse_birthday\":\"" + getBirthday() + "\"," +
                "\"spouse_last_name\":\"" + getSpouse_last_name() + "\"," +
                "\"spouse_first_name\":\"" + getSpouse_first_name() + "\"," +
                "\"spouse_second_name\":\"" + getSpouse_second_name() + "\"," +
                "\"spouse_work_position\":\"" + getSpouse_work_position() + "\"," +
                "\"spouse_company_name\":\"" + getSpouse_company_name() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}," +
                "\"work\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":\"60\"," +
                "\"phone_work\":\"(498) 465-13-25\"," +
                "\"address_work\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322318701\"," +
                "\"type\":\"work\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}" +
                "}," +
                "\"costgroup\":{" +
                "\"costs\":\"" + getCosts() + "\"," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"," +
                "\"customer_estimate\":\"" + getCustomer_estimate() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHomeZo8buZRw = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"Zo8buZRw\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHome73neHtC3 = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"73neHtC3\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHome2f2ATRAL = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"2f2ATRAL\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHomeikgSPiQC = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"ikgSPiQC\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHomeuv4It78N = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"uv4It78N\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHomeu6Ks36W0 = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"u6Ks36W0\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHomeSnQ0Vb2X = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"SnQ0Vb2X\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        public static String sendPropertyTypeHomeYCOipzlk = "" +
                "{" +
                "\"passport\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"" +
                "}," +
                "\"address\":{" +
                "\"address_reg\":{" +
                "\"value\":\"г Москва, ул Кибальчича, д. 1, кв. 1\"," +
                "\"city_type\":null," +
                "\"locality_type\":null," +
                "\"street_type\":\"234\"," +
                "\"zip_code\":\"129164\"," +
                "\"region\":\"г Москва\"," +
                "\"district\":null," +
                "\"city\":null," +
                "\"locality\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"house\":\"1\"," +
                "\"flat\":\"1\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"id\":\"322316277\"," +
                "\"type\":\"reg\"," +
                "\"profile_id\":\"386475213\"," +
                "\"CITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"CITY_TYPE_PROPERTY_259\":null," +
                "\"CITY_TYPE_PROPERTY_260\":null," +
                "\"CITY_TYPE_PROPERTY_261\":null," +
                "\"LOCALITY_TYPE_IBLOCK_ELEMENT_ID\":null," +
                "\"LOCALITY_TYPE_PROPERTY_256\":null," +
                "\"LOCALITY_TYPE_PROPERTY_257\":null," +
                "\"LOCALITY_TYPE_PROPERTY_258\":null," +
                "\"STREET_TYPE_IBLOCK_ELEMENT_ID\":\"234\"," +
                "\"STREET_TYPE_PROPERTY_265\":\"ул\"," +
                "\"STREET_TYPE_PROPERTY_266\":\"Улица\"," +
                "\"STREET_TYPE_PROPERTY_267\":\"1\"," +
                "\"STREET_TYPE_PROPERTY_568\":\"STREET\"," +
                "\"STREET_TYPE_PROPERTY_685\":null," +
                "\"STREET_TYPE_PROPERTY_686\":null" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"property_type_home\":\"YCOipzlk\"," +
                "\"is_not_eq_reg\":\"\"" +
                "}" +
                "}";

        /**
         * Новый запрос (вместе с 69)
         * public static String sendCalculator = "" +
         * "{" +
         * "\"loan_term\":25," +
         * "\"down_payment\":12," +
         * "\"loans\":[{" +
         * "\"id\":\"49148037\"," +
         * "\"bankId\":\"59113\"," +
         * "\"services\":[{" +
         * "\"code\":\"tin_sms_service\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"sms\":true," +
         * "\"insurances\":[{" +
         * "\"code\":\"medical_newOTPofl\"," +
         * "\"isEnable\":true" +
         * "}," +
         * "{" +
         * "\"code\":\"worknewoflMV\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"special\":false" +
         * "}," +
         * "{" +
         * "\"id\":\"369497209\"," +
         * "\"bankId\":\"8170\"," +
         * "\"services\":[{" +
         * "\"code\":\"rsb_sms_service\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"sms\":true," +
         * "\"insurances\":[{" +
         * "\"code\":\"medical_newOTPofl\"," +
         * "\"isEnable\":true" +
         * "}," +
         * "{" +
         * "\"code\":\"worknewoflMV\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"special\":false}," +
         * "{" +
         * "\"id\":\"366519293\"," +
         * "\"bankId\":\"3742\"," +
         * "\"services\":[{" +
         * "\"code\":\"exp_sms_service\"," +
         * "\"isEnable\":true}]," +
         * "\"sms\":true," +
         * "\"insurances\":[{" +
         * "\"code\":\"medical_newOTPofl\"," +
         * "\"isEnable\":true}," +
         * "{" +
         * "\"code\":\"worknewoflMV\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"special\":false" +
         * "}," +
         * "{" +
         * "\"id\":\"383366783\"," +
         * "\"bankId\":\"3319182\"," +
         * "\"services\":[{" +
         * "\"code\":\"mts_sms_service\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"sms\":true," +
         * "\"insurances\":[{" +
         * "\"code\":\"medical_newOTPofl\"," +
         * "\"isEnable\":true" +
         * "}," +
         * "{" +
         * "\"code\":\"worknewoflMV\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"special\":false" +
         * "}," +
         * "{" +
         * "\"id\":\"23129357\"," +
         * "\"bankId\":\"1\"," +
         * "\"services\":[{" +
         * "\"code\":\"ren_sms_comfort\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"sms\":true," +
         * "\"insurances\":[{" +
         * "\"code\":\"medical_newOTPofl\"," +
         * "\"isEnable\":true}," +
         * "{" +
         * "\"code\":\"worknewoflMV\"," +
         * "\"isEnable\":true" +
         * "}]," +
         * "\"special\":false" +
         * "}]," +
         * "\"promo\":null," +
         * "\"insurance_notbank\":[]" +
         * "}";
         */
//        Старый запрос (до 69)


        public static String sendCalculator = "" +
                "{" +
                "\"loan_term\":3," +
                "\"down_payment\":0," +
                "\"loans\":[" +
                "{" +
                "\"id\":\"61859\"," +
                "\"bankId\":\"59113\"," +
                "\"services\":[" +
                "\"tin_sms_service\"" +
                "]," +
                "\"sms\":\"tin_sms_service\"," +
                "\"insurances\":[" +
                "\"medical_newOTPofl\"," +
                "\"worknewoflMV\"" +
                "]," +
                "\"special\":false" +
                "}," +
                "{" +
                "\"id\":\"6509967\"," +
                "\"bankId\":\"8170\"," +
                "\"services\":[" +
                "\"rsb_sms_service\"" +
                "]," +
                "\"sms\":\"rsb_sms_service\"," +
                "\"insurances\":[" +
                "\"medical_newOTPofl\"," +
                "\"worknewoflMV\"" +
                "]," +
                "\"special\":false" +
                "}" +
                "]," +
                "\"promo\":null," +
                "\"insurance_notbank\":[]" +
                "}";


        public static String bodyAuth = "{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"phone\":{" +
                "\"phone_mobile\":\"(996) 960-2297\"" +
                "}" +
                "}";

        public static String bodyCals = "{" +
                "\"loan_term\":10," +
                "\"down_payment\":10," +
                "\"loans\":[" +
                //Альфа банк
                "{" +
                "\"id\":\"116683705\"," +
                "\"bankId\":\"51824\"," +
                "\"services\":[" +
                "\"alfa_sms_service\"]," +
                "\"sms\":\"alfa_sms_service\"," +
                "\"insurances\":[false,false]," +
                "\"special\":false," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //РФБ банк
                "{" +
                "\"id\":\"204239713\"," +
                "\"bankId\":\"12236\"," +
                "\"services\":[\"rfb_sms_service_korpcentre\"]," +
                "\"sms\":\"rfb_sms_service_korpcentre\"," +
                "\"insurances\":[false,false]," +
                "\"special\":false,\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //Почта банк
                "{" +
                "\"id\":\"14846185\"," +
                "\"bankId\":\"376\"," +
                "\"services\":[]," +
                "\"sms\":false," +
                "\"insurances\":[false,false]," +
                "\"special\":false," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //Купи Не Копи
                "{" +
                "\"id\":\"384107763\"," +
                "\"bankId\":\"384091399\"," +
                "\"services\":[]," +
                "\"sms\":false," +
                "\"insurances\":[false,false]," +
                "\"special\":false," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //Тинькофф
                "{" +
                "\"id\":\"61859\"," +
                "\"bankId\":\"59113\"," +
                "\"services\":[\"tin_sms_service\"]," +
                "\"sms\":\"tin_sms_service\"," +
                "\"insurances\":[false,false]," +
                "\"special\":false," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //ОТП
                "{" +
                "\"id\":\"1806\"," +
                "\"bankId\":\"7\"," +
                "\"services\":[\"otp_sms_service\"]," +
                "\"sms\":\"otp_sms_service\"," +
                "\"insurances\":[false," +
                "\"work_mv_hkb_sms\"]," +
                "\"special\":false," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //Ренессанс
                "{" +
                "\"id\":\"83301633\"," +
                "\"bankId\":\"1\"," +
                "\"services\":[\"ren_sms_comfort\"]," +
                "\"sms\":\"ren_sms_comfort\"," +
                "\"insurances\":[false,false]," +
                "\"special\":false," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":false" +
                "}," +
                //ХКБ
                "{" +
                "\"id\":\"83529001\"," +
                "\"bankId\":\"8457\"," +
                "\"services\":[\"home_sms_service\"]," +
                "\"sms\":\"home_sms_service\"," +
                "\"insurances\":[false,\"work_mv_hkb_sms\"]," +
                "\"special\":{\"loan_term\":12," +
                "\"down_payment\":null" +
                "}," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":true" +
                "}," +
                //Рево
                "{" +
                "\"id\":\"336403881\"," +
                "\"bankId\":\"81039346\"," +
                "\"services\":[\"revo_sms_service\"]," +
                "\"sms\":\"revo_sms_service\"," +
                "\"insurances\":[false,false]," +
                "\"special\":{\"loan_term\":12," +
                "\"down_payment\":null" +
                "}," +
                "\"isPromo\":false," +
                "\"isAllowSmsSign\":true" +
                "}" +
                "]" +
                "}";

        public static String fullBodyFromFirstStepProfile = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendSerialAndNumberPassportThroughSpace = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"2454 564 64\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String fullBodyFromNextStepProfile = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String fullBodyFromEndingStepProfile = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatusrQrxbFSC = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"rQrxbFSC\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendSocialStatusDrBuzeAn = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"DrBuzeAn\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatus1r8IYIt8 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"1r8IYIt8\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendSocialStatus0vxo1sNN = "{" +
                "\"social\":{" +
                "\"property_type_home\":\"SnQ0Vb2X\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"0vxo1sNN\"," +
                "\"costs\":12000," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":3," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_home\":\"(498) 465-12-31\"}," +
                "\"contact\":{" +
                "\"relation_degree\":\"mtsgrandchild\"," +
                "\"last_name_contact\":\"Галинин\"," +
                "\"name_contact\":\"Иван\"," +
                "\"second_name_contact\":\"Петрович\"," +
                "\"phone_contact\":\"(984) 615-6514\"" +
                "}" +
                "}";

        public static String sendSocialStatusJ6VBpaeU = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"J6VBpaeU\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatusKwt5ypR2 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"Kwt5ypR2\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatusokcnc8te = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"okcnc8te\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatusbX2QDLZE = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"bX2QDLZE\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatuslhPLvIuA = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"lhPLvIuA\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";
        public static String sendSocialStatusmtsip2 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"mtsip2\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendSocialStatusmtsowner = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"mtsowner\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendEducationiMX4K9nC = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"iMX4K9nC\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducation864JGulJ = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"864JGulJ\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducationjcolhX0Z = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"jcolhX0Z\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducationjjqjrJTK = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"jjqjrJTK\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducationtFQILYCv = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"tFQILYCv\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducation57Paul47 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"57Paul47\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducationAJZRN1S4 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"AJZRN1S4\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducation8IDMA3HA = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"8IDMA3HA\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String sendEducationnI429G0N = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"nI429G0N\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessType9JL0CJaJ = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"9JL0CJaJ\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeYbZ9AkwY = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"YbZ9AkwY\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeGYwOPZHc = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"GYwOPZHc\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypezfKLutAC = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"zfKLutAC\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypewqLuaWF5 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"wqLuaWF5\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTyperJ53DhFk = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"rJ53DhFk\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeTLnIGYrA = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"TLnIGYrA\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeMZHlWynW = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"MZHlWynW\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeT3eM0HYh = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"T3eM0HYh\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeMRDuHN8B = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"MRDuHN8B\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeRI4dVLx7 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"RI4dVLx7\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeqUvTRUyI = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"qUvTRUyI\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeSXSvcWC0 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"SXSvcWC0\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypebUvScCuH = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"bUvScCuH\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeg8sPMDIf = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"g8sPMDIf\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeYwy3KLwt = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"Ywy3KLwt\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeQdOlqnJy = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"QdOlqnJy\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeGBE8nNMU = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"GBE8nNMU\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessType7hOyZaSi = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"7hOyZaSi\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeV9SXT6aF = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"V9SXT6aF\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeSdvuwza2 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"Sdvuwza2\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTyper9v180sZ = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"r9v180sZ\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypegusuzCJ6 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"gusuzCJ6\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypexomrEYGH = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"xomrEYGH\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypespZgk3vs = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"spZgk3vs\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeURpGBtDS = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"URpGBtDS\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypekiZh51bJ = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"kiZh51bJ\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessType3CQJza5Y = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"3CQJza5Y\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypePmApfVXO = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"PmApfVXO\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeXrsTOwWt = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"XrsTOwWt\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeCFgxtHBa = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"CFgxtHBa\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeyi2BL42u = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"yi2BL42u\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypezp9P7jO8 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"zp9P7jO8\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypeLFKbshBl = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"LFKbshBl\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypemtschymistry = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"mtschymistry\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypemtsenergy = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"mtsenergy\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypemtsconstrmaterials = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"mtsconstrmaterials\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypemtslogistics2 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"mtslogistics2\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypemtsseo = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"mtsseo\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendBusinessTypemtsaudit = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"mtsaudit\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeOBwD06es = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"OBwD06es\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeZo8buZRw = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"Zo8buZRw\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyType73neHtC3 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"73neHtC3\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyType2f2ATRAL = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"2f2ATRAL\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeikgSPiQC = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"ikgSPiQC\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeuv4It78N = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"uv4It78N\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeu6Ks36W0 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"u6Ks36W0\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeSnQ0Vb2X = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"SnQ0Vb2X\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPropertyTypeYCOipzlk = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"YCOipzlk\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPositionTyperZ0E4mZP = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"rZ0E4mZP\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeLdclPMjJ = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"LdclPMjJ\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypecEGMbybk = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"cEGMbybk\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypenbzIyADA = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"nbzIyADA\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypemjwE1TnM = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"mjwE1TnM\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendPositionTypeau38D9bk = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"au38D9bk\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatus5KvUof3u = "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"5KvUof3u\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"spouse\":{" +
                "\"spouse_startdate\":\"01.02.2010\"," +
                "\"spouse_last_name\":\"Федорова\"," +
                "\"spouse_first_name\":\"Ирина\"," +
                "\"spouse_second_name\":\"Степановна\"," +
                "\"phone_contact\":\"(987) 498-7684\"," +
                "\"spouse_birthday\":\"01.02.1975\"" +
                "}" +
                "}";

        public static String sendMaritalStatusltS0HkZ6 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"ltS0HkZ6\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatusADoBCpAh = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"ADoBCpAh\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatusXCuGVp6h = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"XCuGVp6h\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatuspfQr7U3s = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"pfQr7U3s\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendMaritalStatus0LqzSuFm = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"0LqzSuFm\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRealEstateGZMHLndD = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"GZMHLndD\"," +
                "\"marital_status\":\"0LqzSuFm\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRealEstateOMeoKbkl = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"OMeoKbkl\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRealEstatergLt8p2r = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"rgLt8p2r\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRealEstate3NTeSzKj = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"3NTeSzKj\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRealEstateIHmTXb7L = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"IHmTXb7L\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRealEstateroommts = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"roommts\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegree7q9E0NKr = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"7q9E0NKr\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeY1mQPKVz = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"Y1mQPKVz\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeLnxmURg4 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"LnxmURg4\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreelR4v6uLT = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"lR4v6uLT\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreevDPgw1Q6 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"vDPgw1Q6\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeC7ZMgbyc = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"C7ZMgbyc\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeOVOxPkpx = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"OVOxPkpx\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreerDzqPVJr = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"rDzqPVJr\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreexKraP9DQ = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"xKraP9DQ\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegree0LilZJnc = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"0LilZJnc\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreeekYxqj5U = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"ekYxqj5U\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegree81dEVcZS = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"81dEVcZS\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreesDTKdM7Z = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"sDTKdM7Z\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreemtsgrandchild = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"mtsgrandchild\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendRelationDegreemtsgrandchild2 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"" + getReal_estate() + "\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"mtsgrandchild2\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String sendFullProfileWithTwoConact = "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":12520," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"ООО Русь Матушка\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\",\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":5," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"(999) 879-73-54\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"Y1mQPKVz\"," +
                "\"last_name_contact\":\"Васильев\"," +
                "\"name_contact\":\"Иван\"," +
                "\"second_name_contact\":\"Олегович\"," +
                "\"phone_contact\":\"(989) 865-5354\"" +
                "}," +
                "\"second_contact\":{" +
                "\"relation_degree_add\":\"mtsgrandchild2\"," +
                "\"last_name_contact_add\":\"Галинина\"," +
                "\"name_contact_add\":\"Ирина\"," +
                "\"second_name_contact_add\":\"Антоновна\"," +
                "\"phone_contact_add\":\"(925) 486-2548\"" +
                "}" +
                "}";
    }

    //            Отправка анкеты без заполнения полей
    public static class sendWithoutField {

        //        Первый шаг анкеты  -------------------------------------------

        public static String withoutLastName = "{" +
                "\"fio\":{" +
                "\"last_name\":\"\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutFirstName = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutSecondName = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutEmail = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutMonthlyIncome = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutSex = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutBirthday = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutDataIssue = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"\"" +
                "}" +
                "}";

        //        Второй шаг анкеты  -------------------------------------------

        public static String withoutSerialAndNumberPassport = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String withoutSubdivisionCode = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendSubdivisionCode000455 = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"000-455\"," +
                "\"issued_passport\":\"ОТДЕЛОМ ОФОРМЛЕНИЯ ВИЗ, РАЗРЕШЕНИЙ, ПРИГЛАШЕНИЙ И РЕГИСТРАЦИИ ИГ УФМС РОССИИ ПО САМАРСКОЙ ОБЛ.\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendSubdivisionCode000001 = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"000-001\"," +
                "\"issued_passport\":\"ФМС РОССИИ\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendSubdivisionCodeRandom1 = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + randomPhone(3) + "-" + randomPhone(3) + "" + "\"," +
                "\"issued_passport\":\"ФМС РОССИИ\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";


        public static String sendSubdivisionCodeRandom2 = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + randomPhone(3) + "-" + randomPhone(3) + "" + "\"," +
                "\"issued_passport\":\"ФМС РОССИИ\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendSubdivisionCodeWith5Simbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"40003\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendSubdivisionCodeWithSimbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"40003" + manyRandomSimbols(1) + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";
        public static String sendSubdivisionCodeWith7Simbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"4000323\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendIssuedPassportWith300Simbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + sendManyRandomSimbols(300) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendIssuedPassportWithManySimbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + sendManyRandomSimbols(400) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendIssuedPassportWithSimbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + sendManyRandomSimbols(300) + manyRandomSimbols(3) + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String withoutIssuedPassport = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String withoutBirthplace = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";


        public static String sendBirthplaceWithManySimbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + sendManyRandomSimbols(179) + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendBirthplaceWithSimbols = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + sendManyRandomSimbols(176) + manyRandomSimbols(3) + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String withoutAddressReg = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"date_reg\":\"" + getDate_reg() + "\"," +
                "\"is_eq_reg\":\"1\"}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String withoutDataReg = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"is_eq_reg\":\"1\"" +
                "}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendDataRegTomorrow = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"" + getDateTomorrow() + "\"," +
                "\"is_eq_reg\":\"1\"" +
                "}," +
                "\"isDirtyPassportIssue\":false" +
                "}";

        public static String sendDataRegBeforeBirthday = "{" +
                "\"address\":{" +
                "\"subdivision_code\":\"" + getSubdivision_code() + "\"," +
                "\"issued_passport\":\"" + getIssued_passport() + "\"," +
                "\"birthplace\":\"" + getBirthplace() + "\"," +
                "\"address_reg\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"date_reg\":\"31.01.1975\"," +
                "\"is_eq_reg\":\"1\"" +
                "}," +
                "\"isDirtyPassportIssue\":false" +
                "}";


        public static String withoutPropertyTypeHome = "" +
                "{" +
                "\"social\":{" +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMaritalStatus = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutChildren = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutSocialStatus = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMotherLastName = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMotherLastName1 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"1234\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMotherLastName2 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMotherLastName3 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"!№;%:?*())))((*?:%;№!№;%:?*()))\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMotherLastName4 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))!№;%:?*())))((*?:%;№!№;%:?*()))\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutMotherLastName5 = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"выавыавыа ав ававы\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutCompanyName = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutBusinessType = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String withoutPositionType = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutWorkInLastPlaceYears = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":\"\"," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutWorkInLastPlaceMonth = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":\"\"," +
                "\"work_in_last_place_months\":\"\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String withoutPhoneWork = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";


        public static String withoutRelationContact = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutLastNameContact = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutNameContact = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"" + getPhone_contact() + "\"" +
                "}" +
                "}";

        public static String withoutPhoneContact = "" +
                "{" +
                "\"social\":{" +
                "\"property_type_home\":\"" + getProperty_type_home() + "\"," +
                "\"real_estate\":\"\"," +
                "\"marital_status\":\"" + getMarital_status() + "\"," +
                "\"children\":\"" + getChildren() + "\"," +
                "\"education\":\"" + getEducation() + "\"," +
                "\"social_status\":\"" + getSocial_status() + "\"," +
                "\"costs\":" + getCosts() + "," +
                "\"mother_last_name\":\"" + getMother_last_name() + "\"" +
                "}," +
                "\"work_data\":{" +
                "\"company_name\":\"" + getCompany_name() + "\"," +
                "\"address_work\":{" +
                "\"isManualSaved\":false," +
                "\"region\":\"г Москва\"," +
                "\"region_kladr\":\"7700000000000\"," +
                "\"district\":null," +
                "\"district_kladr\":null," +
                "\"city\":\"\"," +
                "\"city_kladr\":\"7700000000000\"," +
                "\"city_type\":\"\"," +
                "\"locality\":null," +
                "\"locality_kladr\":null," +
                "\"locality_type\":null," +
                "\"street\":\"Кибальчича\"," +
                "\"street_kladr\":\"77000000000146300\"," +
                "\"street_type\":\"ул\"," +
                "\"house\":\"1\"," +
                "\"house_kladr\":\"7700000000014630001\"," +
                "\"flat\":\"1\"," +
                "\"zip_code\":\"129164\"," +
                "\"kladr\":\"7700000000014630001\"," +
                "\"value\":\"г Москва, ул Кибальчича, д 1, кв 1\"," +
                "\"unrestricted_value\":\"г Москва, Алексеевский р-н, ул Кибальчича, д 1, кв 1\"" +
                "}," +
                "\"business_type\":\"" + getBusiness_type() + "\"," +
                "\"position_type\":\"" + getPosition_type() + "\"," +
                "\"work_in_last_place\":{" +
                "\"work_in_last_place_years\":" + getWork_in_last_place_years() + "," +
                "\"work_in_last_place_months\":\"" + getWork_in_last_place_months() + "\"" +
                "}," +
                "\"phone_work\":\"" + getPhone_work() + "\"" +
                "}," +
                "\"contact\":{" +
                "\"relation_degree\":\"" + getRelation_degree() + "\"," +
                "\"last_name_contact\":\"" + getLast_name_contact() + "\"," +
                "\"name_contact\":\"" + getName_contact() + "\"," +
                "\"second_name_contact\":\"" + getSecond_name_contact() + "\"," +
                "\"phone_contact\":\"\"" +
                "}" +
                "}";
    }

    //            Отправка анкеты с неверными значениями в полях
    public static class sendWithBagValue {

//                Первый шаг анкеты

        public static String sendInvalidSmsCode1 = "" +
                "{" +
                "\"phone_mobile\":\"(996) 960-2297\"," +
                "\"sms_code\":\"111112\"," +
                "\"ad_subscribe\":true" +
                "}";

        public static String sendInvalidSmsCode2 = "" +
                "{" +
                "\"phone_mobile\":\"(996) 960-2297\"," +
                "\"sms_code\":\"11111\"," +
                "\"ad_subscribe\":true" +
                "}";

        public static String sendInvalidSmsCode3 = "" +
                "{" +
                "\"phone_mobile\":\"(996) 960-2297\"," +
                "\"sms_code\":\"1111" + sendManyRandomSimbols(1) + "\"," +
                "\"ad_subscribe\":true" +
                "}";

        public static String sendLastNameWithEnglishAlphabet = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "" + englishAlphabet + "1\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendFirstNameWithEnglishAlphabet = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "" + englishAlphabet + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendSecondNameWithEnglishAlphabet = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "" + englishAlphabet + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendEmailWithRussianAlphabet = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + russiaAlphabet + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendInvalidBirthday1 = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getNowDate() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendInvalidBirthday2 = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getDate100YearsLast() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendNormalDate = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendInvalidBirthday3 = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getDate100YearAnd1dayLast() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";
        public static String sendInvalidBirthday4 = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getDate18YearsLast() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendInvalidBirthday5 = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getDate18YearsLastAnd1Day() + "\"," +
                "\"monthly_income\":" + getMonthly_income() + "," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendMaxPlusMonthlyIncome = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":9999999991," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";

        public static String sendMinPlusMonthlyIncome = "{" +
                "\"fio\":{" +
                "\"last_name\":\"" + getLast_name() + "\"," +
                "\"first_name\":\"" + getFirst_name() + "\"," +
                "\"second_name\":\"" + getSecond_name() + "\"," +
                "\"sex\":\"" + getSex() + "\"," +
                "\"birthday\":\"" + getBirthday() + "\"," +
                "\"monthly_income\":999," +
                "\"email\":\"" + getEmail() + "\"" +
                "}," +
                "\"passport\":{" +
                "\"serial_number_passport\":\"" + getSerial_number_passport() + "\"," +
                "\"date_issue\":\"" + getDate_issue() + "\"" +
                "}" +
                "}";
    }
}


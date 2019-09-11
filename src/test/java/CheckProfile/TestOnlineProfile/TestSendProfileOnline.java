package CheckProfile.TestOnlineProfile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.qameta.allure.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.hamcrest.MatcherAssert;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import static CheckProfile.GeneralData.AllParameters.EndPoints.BasePath;
import static CheckProfile.GeneralData.AllParameters.EndPoints.JSON;
import static CheckProfile.GeneralData.AllParameters.EndPoints.authorization;
import static CheckProfile.GeneralData.AllParameters.EndPoints.cachControl;
import static CheckProfile.GeneralData.AllParameters.EndPoints.createNewOrder;
import static CheckProfile.GeneralData.AllParameters.EndPoints.getCustomerProfileIOfSQLRequest;
import static CheckProfile.GeneralData.AllParameters.EndPoints.getIdOrderOfFile;
import static CheckProfile.GeneralData.AllParameters.EndPoints.getNumberOrderOfFile;
import static CheckProfile.GeneralData.AllParameters.EndPoints.getSmsCodeLink;
import static CheckProfile.GeneralData.AllParameters.EndPoints.getTokenOfFile;
import static CheckProfile.GeneralData.AllParameters.EndPoints.getValueOfTable;
import static CheckProfile.GeneralData.AllParameters.EndPoints.jsonObject;
import static CheckProfile.GeneralData.AllParameters.EndPoints.jsonOrderID;
import static CheckProfile.GeneralData.AllParameters.EndPoints.message;
import static CheckProfile.GeneralData.AllParameters.EndPoints.number;
import static CheckProfile.GeneralData.AllParameters.EndPoints.phpSessId;
import static CheckProfile.GeneralData.AllParameters.EndPoints.response;
import static CheckProfile.GeneralData.AllParameters.EndPoints.responseBody;
import static CheckProfile.GeneralData.AllParameters.EndPoints.result;
import static CheckProfile.GeneralData.AllParameters.EndPoints.send;
import static CheckProfile.GeneralData.AllParameters.EndPoints.smsCheck;
import static CheckProfile.GeneralData.AllParameters.EndPoints.step1;
import static CheckProfile.GeneralData.AllParameters.EndPoints.step2;
import static CheckProfile.GeneralData.AllParameters.EndPoints.step3;
import static CheckProfile.GeneralData.AllParameters.EndPoints.type;
import static CheckProfile.GeneralData.AllParameters.EndPoints.valueFalse;
import static CheckProfile.GeneralData.AllParameters.EndPoints.valueTrue;
import static CheckProfile.GeneralData.AllParameters.EndPoints.zero;
import static CheckProfile.GeneralData.JsonBody.sendTrueBody.*;
import static CheckProfile.GeneralData.JsonBody.sendWithBagValue.*;
import static CheckProfile.GeneralData.JsonBody.sendWithoutField.*;
import static CheckProfile.GeneralData.SetterAndGetter.*;
import static CheckProfile.GeneralData.SqlRequest.getValueOfTable;
import static com.jayway.restassured.RestAssured.expect;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@Epic("Создаём заказ в Онлайне. Проверка отправляемых данных в Онлайн анкете и сохранение их в БД")
public class TestSendProfileOnline {

    @Attachment(value = "Отправляемое тело запроса.", type = "application/json")
    public static String getJsonRequest(String request) {
        return request;
    }

    @Attachment(value = "Полученый ответ от сервера", type = "application/json")
    public static String getResponse(String response) {
        return response;
    }

    @Test
    @Feature("Создаём заказ в Онлайне")
    @Story("Создание заказа")
    @Severity(value = SeverityLevel.BLOCKER)
    public void createNewOrder() throws SQLException, IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOrder.txt");
        fileWriterNumberOrder.write(number);
        fileWriterNumberOrder.close();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("authorization", authorization)
                        .header("content-type", type)
                        .header("cache-control", cachControl)
                        .contentType("text/xml; charset=UTF-8")
                        .body(bodyCreatNewOdder)
                        .when()
                        .post(createNewOrder);
        responseBody = response.getBody().asString();
        getJsonRequest(bodyCreatNewOdder);
        getResponse(responseBody);
        System.out.println(responseBody);
        FileWriter writer = new FileWriter("notes3.xml", false);
        String text = responseBody;
        writer.write(text);
        writer.close();

        String idOrder = getValueOfTable("select id from dc_order where order_number = " + "\"numberOrder" + getNumberOrderOfFile() + "\";");
        FileWriter fileWriterIDOrder = new FileWriter("idOrder.txt");
        fileWriterIDOrder.write(idOrder);
        fileWriterIDOrder.close();
    }

    @Test(dependsOnMethods = "createNewOrder")
    @Feature("Создаём заказ в Онлайне")
    @Story("Запрашиваем СМС-код")
    public void getSmsCode() throws IOException {
        send = getSmsCodeLink + getIdOrderOfFile();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(send)
                .build();
        okhttp3.Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Test(dependsOnMethods = "getSmsCode")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправляем проверочный СМС-код")
    public void sendSmsCode() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(bodySms)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(bodySms);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
        String token = jsonObject.get("sms_code").getAsString();
        FileWriter fileWriter = new FileWriter("token.txt");
        fileWriter.write(token);
        fileWriter.close();
    }

    @Test(dependsOnMethods = "getSmsCode")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправка неверного СМС-кода")
    public void sendInvalidSmsCode1() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidSmsCode1)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidSmsCode1);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        String token = jsonObject.get("message").getAsString();
        assertThat(token).isEqualTo("Неверный код.");
    }

    @Test(dependsOnMethods = "getSmsCode")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправка неверного СМС-кода Из 5 цифр")
    public void sendInvalidSmsCode2() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidSmsCode2)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        getJsonRequest(sendInvalidSmsCode2);
        getResponse(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        String token = jsonObject.get("message").getAsString();
        assertThat(token).isEqualTo("Неверный код.");
    }

    @Test(dependsOnMethods = "getSmsCode")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправка неверного СМС-кода С добавлением символов")
    public void sendInvalidSmsCode3() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidSmsCode3)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidSmsCode3);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        String token = jsonObject.get("message").getAsString();
        assertThat(token).isEqualTo("Неверный код.");
    }

    @Test(dependsOnMethods = "sendInvalidSmsCode3")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправка неверного СМС-кода Осталось 2 попытки")
    public void sendInvalidSmsCodeLast2Chance() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidSmsCode3)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidSmsCode3);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        String token = jsonObject.get("message").getAsString();
        assertThat(token).isEqualTo("Неверный код. У Вас осталось 2 попытки");
    }

    @Test(dependsOnMethods = "sendInvalidSmsCodeLast2Chance")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправка неверного СМС-кода Осталось 1 попытка")
    public void sendInvalidSmsCodeLast1Chance() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidSmsCode3)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidSmsCode3);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        String token = jsonObject.get("message").getAsString();
        assertThat(token).isEqualTo("Неверный код. У Вас осталась 1 попытка");
    }

    @Test(dependsOnMethods = "sendInvalidSmsCodeLast1Chance")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправка неверного СМС-кода Использованы все попытки проверки кода.")
    public void sendInvalidSmsCodeLastNoMoreAttempts() throws IOException {
        send = BasePath + smsCheck + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidSmsCode3)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidSmsCode3);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        System.out.println(responseBody);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        String token = jsonObject.get("message").getAsString();
        assertThat(token).isEqualTo("Использованы все попытки проверки кода. Продолжение оформления заказа невозможно.");

    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Создаём заказ в Онлайне")
    @Story("Получаем cookies - PHPSESSID")
    @Severity(value = SeverityLevel.BLOCKER)
    public void sendAuth() throws IOException {
        send = BasePath + "auth/save&token=" + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(bodyAuth)
                        .when()
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(bodyAuth);
        getResponse(responseBody);
        System.out.println(responseBody);
        assertThat(responseBody).isEqualTo("{\"score\":{\"data\":[],\"send_banks\":[],\"services\":[],\"send_services\":[]}}");
    }

    @Test(dependsOnMethods = "sendAuth")
    @Feature("Создаём заказ в Онлайне")
    @Story("Отправляем данные калькулятора")
    public void calculator() throws IOException {
        send = BasePath + "calc/save&token=" + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect().statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(bodyCals)
                        .when()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(bodyCals);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
        String getOrderId = jsonObject.get("order_id").getAsString();
        assertThat(getOrderId).isEqualTo("" + getIdOrderOfFile());
    }

    @Test(dependsOnMethods = "calculator")
    @Feature("Создаём заказ в Онлайне")
    @Story("Проверяем калькулятор, срок кредитования не должен быть == 0. Проверяем значения loanTermMin, loanTermMax, downPaymentMin, downPaymentMax")
    public void checkCalculator() throws IOException {
        send = "https://lk-test.direct-credit.ru/api/widget.php?action=calc/programs&json=Y&order_id=" + getIdOrderOfFile() + "&token=" + getTokenOfFile();
        Response response1 =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(bodyCals)
                        .when()
                        .get(send);
        responseBody = response1.getBody().asString();
        getJsonRequest(bodyCals);
        getResponse(responseBody);
        System.out.println(responseBody);
        JSONObject object = new JSONObject(responseBody);
        result = String.valueOf(object.getJSONObject("conditions").get("loanTermMin"));
        MatcherAssert.assertThat(result, is(not("null")));
        System.out.println(result);
        result = String.valueOf(object.getJSONObject("conditions").get("loanTermMax"));
        assertThat(result).isEqualTo("36");
        System.out.println(result);
        result = String.valueOf(object.getJSONObject("conditions").get("downPaymentMin"));
        assertThat(result).isEqualTo("0");
        System.out.println(result);
        result = String.valueOf(object.getJSONObject("conditions").get("downPaymentMax"));
        assertThat(result).isEqualTo("99");
        System.out.println(result);
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Фамилию")
    public void withoutLastName() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutLastName)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Фамилия : Поле не должно быть пустым");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Имя")
    public void withoutFirstName() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutFirstName)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutFirstName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Имя : Поле не должно быть пустым");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Отчество")
    public void withoutSecondName() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutSecondName)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSecondName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("2");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Дата рождения")
    public void withoutBirthday() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutBirthday)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutBirthday);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата рождения : This is not date, Дата выдачи : Одно из полей должно содержать данные.");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Email")
    public void withoutEmail() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutEmail)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutEmail);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Электронная почта : Поле не должно быть пустым");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Ежемесячный доход")
    public void withoutMonthlyIncome() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMonthlyIncome)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMonthlyIncome);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Ежемесячный доход : Поле не должно быть пустым, Значение должно быть больше 999");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Пол")
    public void withoutSex() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutSex)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSex);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Пол: : Поле не должно быть пустым");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Дата выдачи")
    public void withoutDataIssue() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutDataIssue)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutDataIssue);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата выдачи : Поле не должно быть пустым");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправка серии и номера паспорта через пробел")
    public void sendSerialAndNumberPassportThroughSpace() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSerialAndNumberPassportThroughSpace)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSerialAndNumberPassportThroughSpace);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Серия и номер паспорта : Формат поля неверный.");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Не заполняем Паспорт")
    public void withoutSerialAndNumberPassport() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutSerialAndNumberPassport)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSerialAndNumberPassport);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Серия и номер паспорта : Поле не должно быть пустым");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Добавляем английский алфавит в Фамилию")
    public void sendLastNameWithEnglishAlphabet() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendLastNameWithEnglishAlphabet)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendLastNameWithEnglishAlphabet);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Фамилия : Формат поля неверный.");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Добавляем английский алфавит в Имя")
    public void sendFirstNameWithEnglishAlphabet() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendFirstNameWithEnglishAlphabet)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendFirstNameWithEnglishAlphabet);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Имя : Формат поля неверный.");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator", description = "Добавляем английский алфавит в Отчество")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Добавляем английский алфавит в Отчество")
    public void sendSecondNameWithEnglishAlphabet() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSecondNameWithEnglishAlphabet)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSecondNameWithEnglishAlphabet);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Отчество : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Добавляем Русского алфавита в Email")
    public void sendEmailWithRussianAlphabet() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEmailWithRussianAlphabet)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEmailWithRussianAlphabet);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Электронная почта : Формат поля неверный.");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем Сегодняшнюю дату рождения")
    public void sendInvalidBirthday1() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidBirthday1)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidBirthday1);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата рождения : Дата не входит в диапазон, Дата выдачи : Одно из полей должно содержать данные.");
    }

    @Test(groups = "firstStepProfile", dependsOnGroups = "nexStepProfile")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем Дату рождения 100 лет назад")
    public void sendInvalidBirthday2() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidBirthday2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("navigated").getAsString();
        assertThat(message).isEqualTo("2");
        getJsonRequest(sendInvalidBirthday2);
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "sendInvalidBirthday2")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем верную дату рождения")
    public void sendNormalDate() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendNormalDate)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendNormalDate);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("navigated").getAsString();
        assertThat(message).isEqualTo("2");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем Дату рождения 100 лет и 1 день назад")
    public void sendInvalidBirthday3() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidBirthday3)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidBirthday3);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата рождения : Дата не входит в диапазон");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем Дату рождения 18 лет назад")
    public void sendInvalidBirthday4() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidBirthday4)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidBirthday4);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата выдачи : Одно из полей должно содержать данные.");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем Дату рождения Завтра исполнится 18 лет")
    public void sendInvalidBirthday5() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendInvalidBirthday5)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendInvalidBirthday5);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата рождения : Дата не входит в диапазон, Дата выдачи : Одно из полей должно содержать данные.");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем превышение ежемесячного дохода")
    @Description(value = "Должна выдаваться ошибка пример \"Превышение месячного дохода 9999999991\". Фронт не пропускает выше 999999999, а бек пропускает.")
    public void sendMaxPlusMonthlyIncome() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaxPlusMonthlyIncome)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaxPlusMonthlyIncome);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Превышение месячного дохода 9999999991");
    }

    @Test(groups = "firstStepProfile", dependsOnMethods = "calculator")
    @Feature("Отправляем пустые/Невалидные поля на Первом шаге анкеты")
    @Story("Отправляем сумму меньше ежемесячного дохода")
    public void sendMinMonthlyIncome() throws IOException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMinPlusMonthlyIncome)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMinPlusMonthlyIncome);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Ежемесячный доход : Значение должно быть больше 999");
    }

    @Test(dependsOnMethods = "calculator")
    @Feature("Отправка всех полей СК анкеты")
    @Story("Отправка по СК анкете. Переходим на 2 шаг анкеты.")
    public void sendStep1() throws IOException, SQLException {
        send = BasePath + step1 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(fullBodyFromFirstStepProfile)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(fullBodyFromFirstStepProfile);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("2");

        //Проверяем данные в таблице b_iblock_element_prop_s10
        System.out.println("Проверяем данные из анкеты");
        getValueOfTable = getValueOfTable("select " + getLastNameBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getLast_name()).isEqualTo(getValueOfTable);
        System.out.println(getLast_name());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getFirstNameBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getFirst_name()).isEqualTo(getValueOfTable);
        System.out.println(getFirst_name());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getSecondNameBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getSecond_name()).isEqualTo(getValueOfTable);
        System.out.println(getSecond_name());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getSexBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getSex()).isEqualTo(getValueOfTable);
        System.out.println(getSex());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getBirthdayBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("1975-02-01 00:00:00").isEqualTo(getValueOfTable);
        System.out.println("1975-02-01 00:00:00");
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getMonthlyIncomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getMonthly_income() + ".0000").isEqualTo(getValueOfTable);
        System.out.println(getMonthly_income() + ".0000");
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getEmailBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getEmail()).isEqualTo(getValueOfTable);
        System.out.println(getEmail());
        System.out.println(getValueOfTable);

        String serial = getValueOfTable("select " + getSerialPassportBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        String number = getValueOfTable("select " + getNumberPassportBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getSerial_number_passport()).isEqualTo(serial + " " + number);
        System.out.println(getSerial_number_passport());
        System.out.println(serial + " " + number);

        getValueOfTable = getValueOfTable("select " + getDateIssuedBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("2010-02-01 00:00:00").isEqualTo(getValueOfTable);
        System.out.println("2010-02-01 00:00:00");
        System.out.println(getValueOfTable);

        // Проверяем JSON-анкету для отправки. Таблица dc_customer_profile.

        System.out.println("Проверяем данные из БД");
        getValueOfTable = getValueOfTable("select last_name from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getLast_name());
        System.out.println(getValueOfTable);
        System.out.println(getLast_name());

        getValueOfTable = getValueOfTable("select first_name from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getFirst_name());
        System.out.println(getValueOfTable);
        System.out.println(getFirst_name());

        getValueOfTable = getValueOfTable("select second_name from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getSecond_name());
        System.out.println(getValueOfTable);
        System.out.println(getSecond_name());

        getValueOfTable = getValueOfTable("select sex from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getSex());
        System.out.println(getValueOfTable);
        System.out.println(getSex());

        getValueOfTable = getValueOfTable("select birthday from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat("1975-02-01").isEqualTo(getValueOfTable);
        System.out.println("1975-02-01");
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select monthly_income from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getMonthly_income()).isEqualTo(getValueOfTable);
        System.out.println(getValueOfTable);
        System.out.println(getMonthly_income());

        getValueOfTable = getValueOfTable("select email from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getEmail()).isEqualTo(getValueOfTable);
        System.out.println(getValueOfTable);
        System.out.println(getEmail());

        String serial_passport = getValueOfTable("select serial_passport from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        String number_passport = getValueOfTable("select number_passport from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getSerial_number_passport()).isEqualTo(serial_passport + " " + number_passport);
        System.out.println(serial_passport + " " + number_passport);
        System.out.println(getSerial_number_passport());

        getValueOfTable = getValueOfTable("select date_issue from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat("2010-02-01").isEqualTo(getValueOfTable);
        System.out.println(getValueOfTable);
        System.out.println("2010-02-01");

    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Не заполняем Код подразделения")
    public void withoutSubdivisionCode() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutSubdivisionCode)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSubdivisionCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Код подразделения : Поле не должно быть пустым");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем Валидные поля на Втором шаге анкеты")
    @Story("Отправляем Код подразделения 000-455")
    public void sendSubdivisionCode000455() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCode000455)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSubdivisionCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("navigated").getAsString();
        assertThat(message).isEqualTo("3");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем Валидные поля на Втором шаге анкеты")
    @Story("Отправляем Код подразделения 000-001")
    public void sendSubdivisionCode000001() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCode000001)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSubdivisionCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("navigated").getAsString();
        assertThat(message).isEqualTo("3");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем Валидные поля на Втором шаге анкеты")
    @Story("Отправляем рандомный Код подразделения")
    public void sendSubdivisionCodeRandom1() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCodeRandom1)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSubdivisionCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("navigated").getAsString();
        assertThat(message).isEqualTo("3");
    }


    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем Валидные поля на Втором шаге анкеты")
    @Story("Отправляем рандомный Код подразделения")
    public void sendSubdivisionCodeRandom2() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCodeRandom2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSubdivisionCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("navigated").getAsString();
        assertThat(message).isEqualTo("3");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем код подразделения из 5 цифр")
    public void sendSubdivisionCodeWith5Simbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCodeWith5Simbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeWith5Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Код подразделения : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем код подразделения С символами")
    public void sendSubdivisionCodeWithSimbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCodeWithSimbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Код подразделения : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем код подразделения из 7 цифр")
    public void sendSubdivisionCodeWith7Simbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSubdivisionCodeWith7Simbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeWith7Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Код подразделения : Формат поля неверный.");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Не заполняем Кем выдан")
    public void withoutIssuedPassport() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutIssuedPassport)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutIssuedPassport);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Кем выдан : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем 300 символов в Кем выдан")
    public void sendIssuedPassportWith300Simbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendIssuedPassportWith300Simbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportWith300Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Кем выдан : Колличество символов не должно превышать 201");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем в Кем выдан 400 символов")
    public void sendIssuedPassportWithManySimbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendIssuedPassportWithManySimbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportWithManySimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Кем выдан : Колличество символов не должно превышать 201");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем в Кем выдан Символы")
    public void sendIssuedPassportWithSimbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendIssuedPassportWithSimbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Кем выдан : Формат поля неверный.");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Не заполняем Место рождения")
    public void withoutBirthplace() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutBirthplace)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutBirthplace);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Место рождения : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем 179 символов в Место рождения")
    @Description(value = "Должно выводиться минимальное кол-во из всех банков, а выводются все банки")
    public void sendBirthplaceWithManySimbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBirthplaceWithManySimbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBirthplaceWithManySimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Место рождения : Колличество символов не должно превышать 121");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем символовы в Место рождения")
    public void sendBirthplaceWithSimbols() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBirthplaceWithSimbols)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBirthplaceWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Место рождения : Формат поля неверный.,");
    }

    @Test(dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Не отправляем адресс регистрации")
    @Description(value = "Не заполняем Адрес регистрации, но пропускает на 3 шаг")
    public void withoutAddressReg() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutAddressReg)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutAddressReg);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Не заполнен адрес регистрации");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Дата регистрации")
    public void withoutDataReg() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutDataReg)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutDataReg);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата регистрации : Поле не должно быть пустым");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем завтрашнюю дату в Дата регистрации")
    public void sendDataRegTomorrow() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendDataRegTomorrow)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendDataRegTomorrow);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата регистрации : Дата не входит в диапазон");
    }

    @Test(groups = "nexStepProfile", dependsOnMethods = "sendStep1")
    @Feature("Отправляем пустые/Невалидные поля на Втором шаге анкеты")
    @Story("Отправляем дату регистрации до даты рождения")
    public void sendDataRegBeforeBirthday() throws IOException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendDataRegBeforeBirthday)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendDataRegBeforeBirthday);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        message = jsonObject.get("message").getAsString();
        assertThat(message).isEqualTo("Дата регистрации : Дата не входит в диапазон");
    }

    @Test(dependsOnMethods = "sendInvalidBirthday2")
    @Feature("Отправка всех полей К анкеты")
    @Story("Отправляем валидный Json. Переходим на 3 шаг анкеты.")
    public void sendStep2() throws IOException, SQLException {
        send = BasePath + step2 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(fullBodyFromNextStepProfile)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(fullBodyFromNextStepProfile);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("3");

        //Проверяем данные в таблице b_iblock_element_prop_s10

        getValueOfTable = getValueOfTable("select " + getSubdivisionCodeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getSubdivision_code()).isEqualTo(getValueOfTable);
        System.out.println(getSubdivision_code());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getIssuedPassportBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getIssued_passport()).isEqualTo(getValueOfTable);
        System.out.println(getIssued_passport());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getBirthplaceBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getBirthplace()).isEqualTo(getValueOfTable);
        System.out.println(getBirthplace());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getDateRegBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("2010-02-01 00:00:00").isEqualTo(getValueOfTable);
        System.out.println("2010-02-01 00:00:00");
        System.out.println(getValueOfTable);

        // Проверяем JSON-анкету для отправки. Таблица dc_customer_profile.

        getValueOfTable = getValueOfTable("select subdivision_code from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getSubdivision_code());
        System.out.println(getValueOfTable);
        System.out.println(getSubdivision_code());

        getValueOfTable = getValueOfTable("select issued_passport from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getIssued_passport());
        System.out.println(getValueOfTable);
        System.out.println(getIssued_passport());

        getValueOfTable = getValueOfTable("select birthplace from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getBirthplace());
        System.out.println(getValueOfTable);
        System.out.println(getBirthplace());

        getValueOfTable = getValueOfTable("select date_reg from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo("2010-02-01");
        System.out.println(getValueOfTable);
        System.out.println("2010-02-01");

    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Название организации")
    public void withoutCompanyName() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutCompanyName)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutCompanyName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Название организации : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Тип недвижимости по месту проживания")
    public void withoutPropertyTypeHome() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutPropertyTypeHome)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutPropertyTypeHome);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Тип недвижимости по месту проживания : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Семейное положение")
    public void withoutMaritalStatus() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMaritalStatus)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMaritalStatus);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Семейное положение : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем количество детей")
    public void withoutChildren() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutChildren)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutChildren);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Социальный статус")
    public void withoutSocialStatus() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutSocialStatus)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutSocialStatus);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Социальный статус : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Девичья фамилия матери")
    public void withoutMotherLastName() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMotherLastName)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMotherLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Девичья фамилия матери : Поле не должно быть пустым");
    }


    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Отправляем кодовое слово(mother_last_name) из цифр в количестве 4")
    public void sendMotherLastNameWithSimbols() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMotherLastName1)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMotherLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Кодовое слово : Формат поля неверный.");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Отправляем кодовое слово(mother_last_name) из цифр в количестве 1500")
    public void sendMotherLastNameOf1500Simbols() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMotherLastName2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMotherLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Кодовое слово : Количество символов не должно превышать 31");
    }


    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Отправляем кодовое слово(mother_last_name) из знаков !№;%:?*()")
    public void sendMotherLastNameOfSigns() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMotherLastName3)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMotherLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Кодовое слово : Количество символов не должно превышать 31");
    }


    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Отправляем кодовое слово(mother_last_name) из большого кол-ва знаков")
    public void sendMotherLastNameOfBigQuantitiesSigns() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMotherLastName4)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMotherLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Кодовое слово : Количество символов не должно превышать 31");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Отправляем кодовое слово(mother_last_name) через пробел")
    public void sendMotherLastNameThroughSpace() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutMotherLastName5)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutMotherLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Вид деятельности")
    public void withoutBusinessType() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutBusinessType)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutBusinessType);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Вид деятельности организации : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Тип Вашей должности")
    public void withoutPositionType() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutPositionType)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutPositionType);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Тип Вашей должности : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем кол-во Лет на прошлом месте работы")
    public void withoutWorkInLastPlaceYears() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutWorkInLastPlaceYears)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutWorkInLastPlaceYears);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Значение должно быть не больше чем 26 лет и 4 месяцев, Значение не должно быть " +
                "пустым, если поле Месяцев равно , Месяцев : Значение не должно быть пустым, если поле Лет равно ");

    }

    @Test(dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем количество месяцев на последнем месте работы")
    public void withoutWorkInLastPlaceMonth() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutWorkInLastPlaceMonth)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutWorkInLastPlaceMonth);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Лет : Значение должно быть не больше чем 26 лет и 4 месяцев, Значение не " +
                "должно быть пустым, если поле Месяцев равно , Месяцев : Значение не должно быть пустым, если поле Лет равно ");

    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Рабочий телефон")
    public void withoutPhoneWork() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutPhoneWork)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutPhoneWork);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Рабочий телефон : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправлять Кем приходится контактное лицо")
    public void withoutRelationContact() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutRelationContact)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutRelationContact);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Кем приходится контактное лицо : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Фамилия контактного лица")
    public void withoutLastNameContact() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutLastNameContact)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutLastNameContact);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Фамилия контактного лица : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Имя контактного лица")
    public void withoutNameContact() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutNameContact)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutNameContact);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Имя контактного лица : Поле не должно быть пустым");
    }

    @Test(groups = "finalSendProfile", dependsOnMethods = "sendStep2")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Не отправляем Телефон контактного лица")
    public void withoutPhoneContact() throws IOException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(withoutPhoneContact)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(withoutPhoneContact);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("message").getAsString();
        assertThat(navigated).isEqualTo("Телефон контактного лица : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "withoutSocialStatus")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем валидный Json.")
    public void sendStep3() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(fullBodyFromEndingStepProfile)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(fullBodyFromEndingStepProfile);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        //Проверяем данные в таблице b_iblock_element_prop_s10

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getProperty_type_home()).isEqualTo(getValueOfTable);
        System.out.println(getProperty_type_home());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getMarital_status()).isEqualTo(getValueOfTable);
        System.out.println(getMarital_status());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getChildrenBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getChildren() + zero).isEqualTo(getValueOfTable);
        System.out.println(getChildren() + zero);
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getEducation()).isEqualTo(getValueOfTable);
        System.out.println(getEducation());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getSocial_status()).isEqualTo(getValueOfTable);
        System.out.println(getSocial_status());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getCostsBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getCosts() + zero).isEqualTo(getValueOfTable);
        System.out.println(getCosts() + zero);
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getMotherLastNameBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getMother_last_name()).isEqualTo(getValueOfTable);
        System.out.println(getMother_last_name());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getCompanyNameBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getCompany_name()).isEqualTo(getValueOfTable);
        System.out.println(getCompany_name());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getBusiness_type()).isEqualTo(getValueOfTable);
        System.out.println(getBusiness_type());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getPosition_type()).isEqualTo(getValueOfTable);
        System.out.println(getPosition_type());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getPhoneWorkBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getPhone_work()).isEqualTo(getValueOfTable);
        System.out.println(getPhone_work());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getWorkInLastPlaceYearsBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("60.0000").isEqualTo(getValueOfTable);
        System.out.println("60.0000");
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getRelation_degree()).isEqualTo(getValueOfTable);
        System.out.println(getRelation_degree());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getLastNameContactBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getLast_name_contact()).isEqualTo(getValueOfTable);
        System.out.println(getLast_name_contact());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getNameContactBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getName_contact()).isEqualTo(getValueOfTable);
        System.out.println(getName_contact());
        System.out.println(getValueOfTable);

        getValueOfTable = getValueOfTable("select " + getPhoneContactBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat(getPhone_contact()).isEqualTo(getValueOfTable);
        System.out.println(getPhone_contact());
        System.out.println(getValueOfTable);

        // Проверяем JSON-анкету для отправки. Таблица dc_customer_profile.


        getValueOfTable = getValueOfTable("select property_type_home from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getProperty_type_home());
        System.out.println(getValueOfTable);
        System.out.println(getProperty_type_home());

        getValueOfTable = getValueOfTable("select marital_status from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getMarital_status());
        System.out.println(getValueOfTable);
        System.out.println(getMarital_status());

        getValueOfTable = getValueOfTable("select children from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getChildren());
        System.out.println(getValueOfTable);
        System.out.println(getChildren());

        getValueOfTable = getValueOfTable("select education from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getEducation());
        System.out.println(getValueOfTable);
        System.out.println(getEducation());

        getValueOfTable = getValueOfTable("select social_status from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getSocial_status());
        System.out.println(getValueOfTable);
        System.out.println(getSocial_status());

        getValueOfTable = getValueOfTable("select costs from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getCosts());
        System.out.println(getValueOfTable);
        System.out.println(getCosts());

        getValueOfTable = getValueOfTable("select mother_last_name from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getMother_last_name());
        System.out.println(getValueOfTable);
        System.out.println(getMother_last_name());

        getValueOfTable = getValueOfTable("select company_name from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getCompany_name());
        System.out.println(getValueOfTable);
        System.out.println(getCompany_name());

        getValueOfTable = getValueOfTable("select business_type from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getBusiness_type());
        System.out.println(getValueOfTable);
        System.out.println(getBusiness_type());

        getValueOfTable = getValueOfTable("select position_type from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getPosition_type());
        System.out.println(getValueOfTable);
        System.out.println(getPosition_type());

        getValueOfTable = getValueOfTable("select phone_work from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getPhone_work());
        System.out.println(getValueOfTable);
        System.out.println(getPhone_work());

        getValueOfTable = getValueOfTable("select work_in_last_place from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo("60");
        System.out.println(getValueOfTable);
        System.out.println("60");

        getValueOfTable = getValueOfTable("select relation_degree from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getRelation_degree());
        System.out.println(getValueOfTable);
        System.out.println(getRelation_degree());

        getValueOfTable = getValueOfTable("select last_name_contact from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getLast_name_contact());
        System.out.println(getValueOfTable);
        System.out.println(getLast_name_contact());

        getValueOfTable = getValueOfTable("select first_name_contact from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getName_contact());
        System.out.println(getValueOfTable);
        System.out.println(getName_contact());

        getValueOfTable = getValueOfTable("select phone_contact from " + getTable_dc_customer_profile() + " where order_id  = " + getIdOrderOfFile());
        assertThat(getValueOfTable).isEqualTo(getPhone_contact());
        System.out.println(getValueOfTable);
        System.out.println(getName_contact());

    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Разнорабочий")
    public void sendSocialStatusrQrxbFSC() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusrQrxbFSC)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusrQrxbFSC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("rQrxbFSC").isEqualTo(getValueOfTable);
        System.out.println("rQrxbFSC");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Не работаю")
    public void sendSocialStatusDrBuzeAn() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusDrBuzeAn)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusDrBuzeAn);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("DrBuzeAn").isEqualTo(getValueOfTable);
        System.out.println("DrBuzeAn");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Студент")
    public void sendSocialStatus1r8IYIt8() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatus1r8IYIt8)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatus1r8IYIt8);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("1r8IYIt8").isEqualTo(getValueOfTable);
        System.out.println("1r8IYIt8");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Пенсионер")
    public void sendSocialStatus0vxo1sNN() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatus0vxo1sNN)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatus0vxo1sNN);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("0vxo1sNN").isEqualTo(getValueOfTable);
        System.out.println("0vxo1sNN");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Домохозяйка")
    public void sendSocialStatusJ6VBpaeU() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusJ6VBpaeU)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusJ6VBpaeU);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("J6VBpaeU").isEqualTo(getValueOfTable);
        System.out.println("J6VBpaeU");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Коммерческий сотрудник")
    public void sendSocialStatusKwt5ypR2() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusKwt5ypR2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusKwt5ypR2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("Kwt5ypR2").isEqualTo(getValueOfTable);
        System.out.println("Kwt5ypR2");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Предприниматель")
    public void sendSocialStatusokcnc8te() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusokcnc8te)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusokcnc8te);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("okcnc8te").isEqualTo(getValueOfTable);
        System.out.println("okcnc8te");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Декретный отпуск")
    public void sendSocialStatusbX2QDLZE() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusbX2QDLZE)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusbX2QDLZE);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("bX2QDLZE").isEqualTo(getValueOfTable);
        System.out.println("bX2QDLZE");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Отправляем соц статус Государственный служащий")
    public void sendSocialStatuslhPLvIuA() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatuslhPLvIuA)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatuslhPLvIuA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("lhPLvIuA").isEqualTo(getValueOfTable);
        System.out.println("lhPLvIuA");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус ИП/Частная практика")
    public void sendSocialStatusmtsip2() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusmtsip2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusmtsip2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsip2").isEqualTo(getValueOfTable);
        System.out.println("mtsip2");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправляем соц статус Собственник/совладелец компании")
    public void sendSocialStatusmtsowner() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendSocialStatusmtsowner)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStatusmtsowner);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getSocialStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsowner").isEqualTo(getValueOfTable);
        System.out.println("mtsowner");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Нет")
    public void sendEducationiMX4K9nC() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducationiMX4K9nC)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationiMX4K9nC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("iMX4K9nC").isEqualTo(getValueOfTable);
        System.out.println("iMX4K9nC");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Начальное или незаконченное среднее")
    public void sendEducation864JGulJ() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducation864JGulJ)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducation864JGulJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("864JGulJ").isEqualTo(getValueOfTable);
        System.out.println("864JGulJ");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Среднее")
    public void sendEducationjcolhX0Z() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducationjcolhX0Z)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationjcolhX0Z);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("jcolhX0Z").isEqualTo(getValueOfTable);
        System.out.println("jcolhX0Z");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Среднетехническое")
    public void sendEducationjjqjrJTK() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducationjjqjrJTK)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationjjqjrJTK);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("jjqjrJTK").isEqualTo(getValueOfTable);
        System.out.println("jjqjrJTK");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Специальное техническое")
    public void sendEducationtFQILYCv() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducationtFQILYCv)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationtFQILYCv);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("tFQILYCv").isEqualTo(getValueOfTable);
        System.out.println("tFQILYCv");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Незаконченное высшее")
    public void sendEducation57Paul47() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducation57Paul47)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducation57Paul47);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("57Paul47").isEqualTo(getValueOfTable);
        System.out.println("57Paul47");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Высшее")
    public void sendEducationAJZRN1S4() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducationAJZRN1S4)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationAJZRN1S4);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("AJZRN1S4").isEqualTo(getValueOfTable);
        System.out.println("AJZRN1S4");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Второе высшее")
    public void sendEducation8IDMA3HA() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducation8IDMA3HA)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducation8IDMA3HA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("8IDMA3HA").isEqualTo(getValueOfTable);
        System.out.println("8IDMA3HA");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка образования Степень")
    public void sendEducationnI429G0N() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendEducationnI429G0N)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationnI429G0N);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getEducationBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("nI429G0N").isEqualTo(getValueOfTable);
        System.out.println("nI429G0N");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Бытовые услуги")
    public void sendBusinessType9JL0CJaJ() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessType9JL0CJaJ)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessType9JL0CJaJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("9JL0CJaJ").isEqualTo(getValueOfTable);
        System.out.println("9JL0CJaJ");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Вооруженные силы")
    public void sendBusinessTypeYbZ9AkwY() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeYbZ9AkwY)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeYbZ9AkwY);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("YbZ9AkwY").isEqualTo(getValueOfTable);
        System.out.println("YbZ9AkwY");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Гос.и муниципальные структуры")
    public void sendBusinessTypeGYwOPZHc() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeGYwOPZHc)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeGYwOPZHc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("GYwOPZHc").isEqualTo(getValueOfTable);
        System.out.println("GYwOPZHc");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Детективное, охранное предприятие")
    public void sendBusinessTypezfKLutAC() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypezfKLutAC)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypezfKLutAC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("zfKLutAC").isEqualTo(getValueOfTable);
        System.out.println("zfKLutAC");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации ЖКХ")
    public void sendBusinessTypewqLuaWF5() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypewqLuaWF5)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypewqLuaWF5);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("wqLuaWF5").isEqualTo(getValueOfTable);
        System.out.println("wqLuaWF5");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Здравоохранение")
    public void sendBusinessTyperJ53DhFk() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTyperJ53DhFk)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTyperJ53DhFk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("rJ53DhFk").isEqualTo(getValueOfTable);
        System.out.println("rJ53DhFk");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Издательская деятельность")
    public void sendBusinessTypeTLnIGYrA() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeTLnIGYrA)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeTLnIGYrA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("TLnIGYrA").isEqualTo(getValueOfTable);
        System.out.println("TLnIGYrA");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Информационные технологии")
    public void sendBusinessTypeMZHlWynW() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeMZHlWynW)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeMZHlWynW);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("MZHlWynW").isEqualTo(getValueOfTable);
        System.out.println("MZHlWynW");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Легкая промышленность")
    public void sendBusinessTypeT3eM0HYh() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeT3eM0HYh)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeT3eM0HYh);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("T3eM0HYh").isEqualTo(getValueOfTable);
        System.out.println("T3eM0HYh");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Лесное хозяйство")
    public void sendBusinessTypeMRDuHN8B() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeMRDuHN8B)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeMRDuHN8B);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("MRDuHN8B").isEqualTo(getValueOfTable);
        System.out.println("MRDuHN8B");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Машиностроение, металлургия")
    public void sendBusinessTypeRI4dVLx7() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeRI4dVLx7)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeRI4dVLx7);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("RI4dVLx7").isEqualTo(getValueOfTable);
        System.out.println("RI4dVLx7");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Образование и наука")
    public void sendBusinessTypeqUvTRUyI() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeqUvTRUyI)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeqUvTRUyI);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("qUvTRUyI").isEqualTo(getValueOfTable);
        System.out.println("qUvTRUyI");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Оптовая торговля")
    public void sendBusinessTypeSXSvcWC0() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeSXSvcWC0)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeSXSvcWC0);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("SXSvcWC0").isEqualTo(getValueOfTable);
        System.out.println("SXSvcWC0");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Пищевая промышленность")
    public void sendBusinessTypebUvScCuH() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypebUvScCuH)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypebUvScCuH);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("bUvScCuH").isEqualTo(getValueOfTable);
        System.out.println("bUvScCuH");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Полиграфическая промышленность")
    public void sendBusinessTypeg8sPMDIf() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeg8sPMDIf)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeg8sPMDIf);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("g8sPMDIf").isEqualTo(getValueOfTable);
        System.out.println("g8sPMDIf");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Посредническая деятельность")
    public void sendBusinessTypeYwy3KLwt() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeYwy3KLwt)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeYwy3KLwt);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("Ywy3KLwt").isEqualTo(getValueOfTable);
        System.out.println("Ywy3KLwt");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Правоохранительные органы")
    public void sendBusinessTypeQdOlqnJy() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeQdOlqnJy)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeQdOlqnJy);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("QdOlqnJy").isEqualTo(getValueOfTable);
        System.out.println("QdOlqnJy");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Реклама, PR агентства, СМИ")
    public void sendBusinessTypeGBE8nNMU() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeGBE8nNMU)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeGBE8nNMU);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("GBE8nNMU").isEqualTo(getValueOfTable);
        System.out.println("GBE8nNMU");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Рестораны, кафе")
    public void sendBusinessType7hOyZaSi() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessType7hOyZaSi)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessType7hOyZaSi);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("7hOyZaSi").isEqualTo(getValueOfTable);
        System.out.println("7hOyZaSi");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Розничная торговля")
    public void sendBusinessTypeV9SXT6aF() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeV9SXT6aF)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeV9SXT6aF);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("V9SXT6aF").isEqualTo(getValueOfTable);
        System.out.println("V9SXT6aF");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Салоны красоты, фитнес-центры")
    public void sendBusinessTypeSdvuwza2() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeSdvuwza2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeSdvuwza2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("Sdvuwza2").isEqualTo(getValueOfTable);
        System.out.println("Sdvuwza2");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Связь")
    public void sendBusinessTyper9v180sZ() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTyper9v180sZ)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeRI4dVLx7);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("r9v180sZ").isEqualTo(getValueOfTable);
        System.out.println("r9v180sZ");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Сельское хозяйство")
    public void sendBusinessTypegusuzCJ6() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypegusuzCJ6)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypegusuzCJ6);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("gusuzCJ6").isEqualTo(getValueOfTable);
        System.out.println("gusuzCJ6");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Строительство, строительные материалы")
    public void sendBusinessTypexomrEYGH() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypexomrEYGH)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypexomrEYGH);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("xomrEYGH").isEqualTo(getValueOfTable);
        System.out.println("xomrEYGH");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Транспорт")
    public void sendBusinessTypespZgk3vs() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypespZgk3vs)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypespZgk3vs);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("spZgk3vs").isEqualTo(getValueOfTable);
        System.out.println("spZgk3vs");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации ТЭК, горнодобывающая промышленность")
    public void sendBusinessTypeURpGBtDS() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeURpGBtDS)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeURpGBtDS);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("URpGBtDS").isEqualTo(getValueOfTable);
        System.out.println("URpGBtDS");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Увеселительный, шоу-бизнес, туризм")
    public void sendBusinessTypekiZh51bJ() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypekiZh51bJ)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypekiZh51bJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("kiZh51bJ").isEqualTo(getValueOfTable);
        System.out.println("kiZh51bJ");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Финансы, банковское дело")
    public void sendBusinessType3CQJza5Y() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessType3CQJza5Y)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessType3CQJza5Y);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("3CQJza5Y").isEqualTo(getValueOfTable);
        System.out.println("3CQJza5Y");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Юридические услуги")
    public void sendBusinessTypePmApfVXO() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypePmApfVXO)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypePmApfVXO);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("PmApfVXO").isEqualTo(getValueOfTable);
        System.out.println("PmApfVXO");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Другое")
    public void sendBusinessTypeXrsTOwWt() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeXrsTOwWt)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeXrsTOwWt);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("XrsTOwWt").isEqualTo(getValueOfTable);
        System.out.println("XrsTOwWt");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Игорный бизнес")
    public void sendBusinessTypeCFgxtHBa() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeCFgxtHBa)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeCFgxtHBa);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("CFgxtHBa").isEqualTo(getValueOfTable);
        System.out.println("CFgxtHBa");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Страхование")
    public void sendBusinessTypeyi2BL42u() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeyi2BL42u)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeyi2BL42u);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("yi2BL42u").isEqualTo(getValueOfTable);
        System.out.println("yi2BL42u");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Благотворительные и религиозные организации")
    public void sendBusinessTypezp9P7jO8() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypezp9P7jO8)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypezp9P7jO8);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("zp9P7jO8").isEqualTo(getValueOfTable);
        System.out.println("zp9P7jO8");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Подбор персонала")
    public void sendBusinessTypeLFKbshBl() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypeLFKbshBl)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeLFKbshBl);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("LFKbshBl").isEqualTo(getValueOfTable);
        System.out.println("LFKbshBl");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Химия, парфюмерия, фармацевтика")
    public void sendBusinessTypemtschymistry() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypemtschymistry)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypemtschymistry);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtschymistry").isEqualTo(getValueOfTable);
        System.out.println("mtschymistry");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Производство и распределение электроэнергии, газа, воды")
    public void sendBusinessTypemtsenergy() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypemtsenergy)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypemtsenergy);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsenergy").isEqualTo(getValueOfTable);
        System.out.println("mtsenergy");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Производство строительных материалов")
    public void sendBusinessTypemtsconstrmaterials() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypemtsconstrmaterials)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypemtsconstrmaterials);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsconstrmaterials").isEqualTo(getValueOfTable);
        System.out.println("mtsconstrmaterials");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Складское хранение и логистика")
    public void sendBusinessTypemtslogistics2() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypemtslogistics2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypemtslogistics2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtslogistics2").isEqualTo(getValueOfTable);
        System.out.println("mtslogistics2");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Операции с недвижимостью")
    public void sendBusinessTypemtsseo() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypemtsseo)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypemtsseo);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsseo").isEqualTo(getValueOfTable);
        System.out.println("mtsseo");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка вид деятельности организации Аудит, консталтинг")
    public void sendBusinessTypemtsaudit() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendBusinessTypemtsaudit)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypemtsaudit);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getBusinessTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsaudit").isEqualTo(getValueOfTable);
        System.out.println("mtsaudit");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Собственность")
    public void sendPropertyTypeOBwD06es() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeOBwD06es)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeOBwD06es);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("OBwD06es").isEqualTo(getValueOfTable);
        System.out.println("OBwD06es");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Аренда")
    public void sendPropertyTypeZo8buZRw() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeZo8buZRw)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeZo8buZRw);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("Zo8buZRw").isEqualTo(getValueOfTable);
        System.out.println("Zo8buZRw");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Проживаю у родственников")
    public void sendPropertyType73neHtC3() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyType73neHtC3)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyType73neHtC3);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("73neHtC3").isEqualTo(getValueOfTable);
        System.out.println("73neHtC3");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Предоставляется работодателем")
    public void sendPropertyType2f2ATRAL() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyType2f2ATRAL)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyType2f2ATRAL);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("2f2ATRAL").isEqualTo(getValueOfTable);
        System.out.println("2f2ATRAL");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Оплачено более 6 мес")
    public void sendPropertyTypeikgSPiQC() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeikgSPiQC)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeikgSPiQC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("ikgSPiQC").isEqualTo(getValueOfTable);
        System.out.println("ikgSPiQC");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Общежитие (Студент)")
    public void sendPropertyTypeuv4It78N() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeuv4It78N)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeuv4It78N);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("uv4It78N").isEqualTo(getValueOfTable);
        System.out.println("uv4It78N");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Собственность в залоге")
    public void sendPropertyTypeu6Ks36W0() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeu6Ks36W0)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeu6Ks36W0);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("u6Ks36W0").isEqualTo(getValueOfTable);
        System.out.println("u6Ks36W0");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Муниципальное жилье")
    public void sendPropertyTypeSnQ0Vb2X() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeSnQ0Vb2X)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeSnQ0Vb2X);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("SnQ0Vb2X").isEqualTo(getValueOfTable);
        System.out.println("SnQ0Vb2X");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Другое")
    public void sendPropertyTypeYCOipzlk() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPropertyTypeYCOipzlk)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeYCOipzlk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPropertyTypeHomeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("YCOipzlk").isEqualTo(getValueOfTable);
        System.out.println("YCOipzlk");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Младший специалист")
    public void sendPositionTyperZ0E4mZP() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPositionTyperZ0E4mZP)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTyperZ0E4mZP);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("rZ0E4mZP").isEqualTo(getValueOfTable);
        System.out.println("rZ0E4mZP");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Специалист")
    public void sendPositionTypeLdclPMjJ() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPositionTypeLdclPMjJ)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeLdclPMjJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("LdclPMjJ").isEqualTo(getValueOfTable);
        System.out.println("LdclPMjJ");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Старший специалист")
    public void sendPositionTypecEGMbybk() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPositionTypecEGMbybk)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypecEGMbybk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("cEGMbybk").isEqualTo(getValueOfTable);
        System.out.println("cEGMbybk");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Начинающий руководитель")
    public void sendPositionTypenbzIyADA() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPositionTypenbzIyADA)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypenbzIyADA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("nbzIyADA").isEqualTo(getValueOfTable);
        System.out.println("nbzIyADA");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Руководитель с опытом")
    public void sendPositionTypemjwE1TnM() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPositionTypemjwE1TnM)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypemjwE1TnM);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mjwE1TnM").isEqualTo(getValueOfTable);
        System.out.println("mjwE1TnM");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Тип недвижимости по месту проживания Руководитель высшего звена")
    public void sendPositionTypeau38D9bk() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendPositionTypeau38D9bk)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeau38D9bk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getPositionTypeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("au38D9bk").isEqualTo(getValueOfTable);
        System.out.println("au38D9bk");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Семейное положение Женат/замужем")
    public void sendMaritalStatus5KvUof3u() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaritalStatus5KvUof3u)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatus5KvUof3u);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("5KvUof3u").isEqualTo(getValueOfTable);
        System.out.println("5KvUof3u");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Семейное положение Холост/не замужем")
    public void sendMaritalStatusltS0HkZ6() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaritalStatusltS0HkZ6)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusltS0HkZ6);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("ltS0HkZ6").isEqualTo(getValueOfTable);
        System.out.println("ltS0HkZ6");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Семейное положение Разведен/разведена")
    public void sendMaritalStatusADoBCpAh() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaritalStatusADoBCpAh)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusADoBCpAh);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("ADoBCpAh").isEqualTo(getValueOfTable);
        System.out.println("ADoBCpAh");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Семейное положение Раздельное проживание")
    public void sendMaritalStatusXCuGVp6h() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaritalStatusXCuGVp6h)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusXCuGVp6h);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("XCuGVp6h").isEqualTo(getValueOfTable);
        System.out.println("XCuGVp6h");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Семейное положение Вдова/вдовец")
    public void sendMaritalStatuspfQr7U3s() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaritalStatuspfQr7U3s)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatuspfQr7U3s);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("pfQr7U3s").isEqualTo(getValueOfTable);
        System.out.println("pfQr7U3s");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Семейное положение Гражданский брак")
    public void sendMaritalStatus0LqzSuFm() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendMaritalStatus0LqzSuFm)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatus0LqzSuFm);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getMaritalStatusBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("0LqzSuFm").isEqualTo(getValueOfTable);
        System.out.println("0LqzSuFm");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка другая недвижимость Дача")
    public void sendRealEstateGZMHLndD() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRealEstateGZMHLndD)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRealEstateGZMHLndD);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRealEstateBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("GZMHLndD").isEqualTo(getValueOfTable);
        System.out.println("GZMHLndD");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка другая недвижимость Земельный участок")
    public void sendRealEstateOMeoKbkl() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRealEstateOMeoKbkl)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRealEstateOMeoKbkl);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRealEstateBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("OMeoKbkl").isEqualTo(getValueOfTable);
        System.out.println("OMeoKbkl");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка другая недвижимость Гараж")
    public void sendRealEstatergLt8p2r() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRealEstatergLt8p2r)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRealEstatergLt8p2r);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRealEstateBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("rgLt8p2r").isEqualTo(getValueOfTable);
        System.out.println("rgLt8p2r");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка другая недвижимость Квартира")
    public void sendRealEstate3NTeSzKj() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRealEstate3NTeSzKj)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRealEstate3NTeSzKj);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRealEstateBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("3NTeSzKj").isEqualTo(getValueOfTable);
        System.out.println("3NTeSzKj");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка другая недвижимость Другое")
    public void sendRealEstateIHmTXb7L() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRealEstateIHmTXb7L)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRealEstateIHmTXb7L);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRealEstateBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("IHmTXb7L").isEqualTo(getValueOfTable);
        System.out.println("IHmTXb7L");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка другая недвижимость Комната")
    public void sendRealEstateroommts() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRealEstateroommts)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRealEstateroommts);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRealEstateBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("roommts").isEqualTo(getValueOfTable);
        System.out.println("roommts");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Бабушка")
    public void sendRelationDegree7q9E0NKr() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegree7q9E0NKr)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegree7q9E0NKr);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("7q9E0NKr").isEqualTo(getValueOfTable);
        System.out.println("7q9E0NKr");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Брат")
    public void sendRelationDegreeY1mQPKVz() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreeY1mQPKVz)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeY1mQPKVz);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("Y1mQPKVz").isEqualTo(getValueOfTable);
        System.out.println("Y1mQPKVz");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Дедушка")
    public void sendRelationDegreeLnxmURg4() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreeLnxmURg4)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeLnxmURg4);
        getResponse(responseBody);

        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");
        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("LnxmURg4").isEqualTo(getValueOfTable);
        System.out.println("LnxmURg4");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Дочь")
    public void sendRelationDegreelR4v6uLT() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreelR4v6uLT)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreelR4v6uLT);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("lR4v6uLT").isEqualTo(getValueOfTable);
        System.out.println("lR4v6uLT");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Друг/подруга")
    public void sendRelationDegreevDPgw1Q6() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreevDPgw1Q6)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreevDPgw1Q6);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("vDPgw1Q6").isEqualTo(getValueOfTable);
        System.out.println("vDPgw1Q6");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Другой родственник")
    public void sendRelationDegreeC7ZMgbyc() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreeC7ZMgbyc)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeC7ZMgbyc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("C7ZMgbyc").isEqualTo(getValueOfTable);
        System.out.println("C7ZMgbyc");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Клиент")
    public void sendRelationDegreeOVOxPkpx() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreeOVOxPkpx)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOVOxPkpx);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("OVOxPkpx").isEqualTo(getValueOfTable);
        System.out.println("OVOxPkpx");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Коллега")
    public void sendRelationDegreerDzqPVJr() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreerDzqPVJr)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreerDzqPVJr);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("rDzqPVJr").isEqualTo(getValueOfTable);
        System.out.println("rDzqPVJr");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Мать")
    public void sendRelationDegreexKraP9DQ() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreexKraP9DQ)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreexKraP9DQ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("xKraP9DQ").isEqualTo(getValueOfTable);
        System.out.println("xKraP9DQ");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Остальные")
    public void sendRelationDegree0LilZJnc() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegree0LilZJnc)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegree0LilZJnc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("0LilZJnc").isEqualTo(getValueOfTable);
        System.out.println("0LilZJnc");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Отец")
    public void sendRelationDegreeekYxqj5U() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreeekYxqj5U)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeekYxqj5U);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("ekYxqj5U").isEqualTo(getValueOfTable);
        System.out.println("ekYxqj5U");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Сын")
    public void sendRelationDegree81dEVcZS() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegree81dEVcZS)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegree81dEVcZS);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("81dEVcZS").isEqualTo(getValueOfTable);
        System.out.println("81dEVcZS");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Сестра")
    public void sendRelationDegreesDTKdM7Z() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreesDTKdM7Z)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreesDTKdM7Z);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("sDTKdM7Z").isEqualTo(getValueOfTable);
        System.out.println("sDTKdM7Z");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Внук")
    public void sendRelationDegreemtsgrandchild() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreemtsgrandchild)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreemtsgrandchild);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsgrandchild").isEqualTo(getValueOfTable);
        System.out.println("mtsgrandchild");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправка всех полей Д анкеты")
    @Story("Отправка Кем приходится контактное лицо Внучка")
    public void sendRelationDegreemtsgrandchild2() throws IOException, JSONException, SQLException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendRelationDegreemtsgrandchild2)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreemtsgrandchild2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");

        getValueOfTable = getValueOfTable("select " + getRelationDegreeBD() + " from " + getTable_b_iblock_element_prop_s10() + " where " + getIblockElementIdBD() + " = " + getCustomerProfileIOfSQLRequest());
        assertThat("mtsgrandchild2").isEqualTo(getValueOfTable);
        System.out.println("mtsgrandchild2");
        System.out.println(getValueOfTable);
    }

    @Test(dependsOnMethods = "sendStep3")
    @Feature("Отправляем пустые/Невалидные поля на Третьем шаге анкеты")
    @Story("Отправка полной анкеты со вторым контактным лицом")
    public void sendFullProfileWithTwoConact() throws IOException, JSONException {
        send = BasePath + step3 + getTokenOfFile() + jsonOrderID + getIdOrderOfFile();
        response =
                expect()
                        .statusCode(200)
                        .given()
                        .header("content-type", JSON)
                        .header("cache-control", cachControl)
                        .cookie(phpSessId, getTokenOfFile())
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(sendFullProfileWithTwoConact)
                        .log().ifValidationFails()
                        .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendFullProfileWithTwoConact);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        String navigated = jsonObject.get("navigated").getAsString();
        assertThat(navigated).isEqualTo("-1");
    }
}
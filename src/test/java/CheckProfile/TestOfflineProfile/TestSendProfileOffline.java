package CheckProfile.TestOfflineProfile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.MatcherAssert;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

import static CheckProfile.GeneralData.AllParameters.EndPoints.*;
import static CheckProfile.GeneralData.JsonBody.sendTrueBody.*;
import static CheckProfile.TestOnlineProfile.TestSendProfileOnline.getJsonRequest;
import static CheckProfile.TestOnlineProfile.TestSendProfileOnline.getResponse;
import static com.jayway.restassured.RestAssured.expect;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@Epic("Проверка отправляемых данных в Оффлайне анкете и сохранение их в БД")
public class TestSendProfileOffline {

    @Test(description = "PHPSESSID")
    @Feature("Создаём заказ в Оффлайне")
    @Story("Получаем PHPSESSID при авторизации пользователя")
    public void getPHPHSESSSID() throws IOException {
        response =
                expect()
                        .statusCode(302)
                        .given()
                        .contentType("application/x-www-form-urlencoded")
                        .header(cachControl, "no-cache")
                        .log().all()
                        .body("AUTH_FORM=Y&TYPE=AUTH&backurl=%2F&USER_LOGIN=mv_test_new_1&USER_PASSWORD=mv_test_new_1&check_agreement=on&Login=")
                        .log().ifValidationFails()
                        .post("https://lk-test.direct-credit.ru/?login=yes");
        responseBody = response.getBody().asString();
        String responseBody1 = response.getCookie("PHPSESSID");
        getJsonRequest("AUTH_FORM=Y&TYPE=AUTH&backurl=%2F&USER_LOGIN=mv_test_new_1&USER_PASSWORD=mv_test_new_1&check_agreement=on&Login=");
        getResponse(responseBody);
        System.out.println(responseBody);
        System.out.println(responseBody1);
        FileWriter fileWriter = new FileWriter("PHPSESSID.txt");
        fileWriter.write(responseBody1);
        fileWriter.close();
    }

    @Test(dependsOnMethods = "getPHPHSESSSID")
    @Feature("Создаём заказ в Оффлайне")
    @Story("Создаём новый заказ в Мвидео")
    public void createNewOfflineOrder() throws IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOfflineOrder.txt");
        fileWriterNumberOrder.write(numberOffline + "0");
        fileWriterNumberOrder.close();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(createNewOfflineOrder)
                .when()
                .log().ifValidationFails()
                .post(createOfflineOrder);
        responseBody = response.getBody().asString();
        System.out.println(responseBody);
        getJsonRequest(createNewOfflineOrder);
        getResponse(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        result = jsonObject.get("order_number").getAsString();
        String order_id = jsonObject.get("order_id").getAsString();
        FileWriter fileWriter = new FileWriter("orderIdOffline.txt");
        fileWriter.write(order_id);
        fileWriter.close();
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем пустые/Невалидные поля при создании заказа")
    @Story("Создаём заказ в Оффлайне без Номера заказа")
    @Description("Бэк возвращает \"Номер заказа: Номер заказа должен быть уникальным\" в место \"Номер заказа: Поле не может быть пустым\"")
    public void createOrderOfflineWithoutOrderName() throws IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOfflineOrder.txt");
        fileWriterNumberOrder.write(numberOffline + "1");
        fileWriterNumberOrder.close();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(createOrderOfflineWithoutOrderName)
                .when()
                .log().ifValidationFails()
                .post(createOfflineOrder);
        responseBody = response.getBody().asString();
        getJsonRequest(createOrderOfflineWithoutOrderName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Номер заказа: Номер заказа должен быть уникальным");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем пустые/Невалидные поля при создании заказа")
    @Story("Создаём заказ в Оффлайне без Торговой точки")
    @Description("Бэк возвращает \"Номер заказа: Номер заказа должен быть уникальным\" в место \"Выбор торговой точки: Поле не может быть пустым\"")
    public void createOrderOfflineWithoutOutletStore() throws IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOfflineOrder.txt");
        fileWriterNumberOrder.write(numberOffline + "2");
        fileWriterNumberOrder.close();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(createOrderOfflineWithoutOutletStore)
                .when()
                .log().ifValidationFails()
                .post(createOfflineOrder);
        responseBody = response.getBody().asString();
        getJsonRequest(createOrderOfflineWithoutOutletStore);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Выбор торговой точки : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем пустые/Невалидные поля при создании заказа")
    @Story("Создаём заказ в Оффлайне без Название продукта")
    @Description("Бэк возвращает \"Номер заказа: Номер заказа должен быть уникальным\" в место \"Название товара: Поле не может быть пустым\"")
    public void createOrderOfflineWithoutNameProduct() throws IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOfflineOrder.txt");
        fileWriterNumberOrder.write(numberOffline + "3");
        fileWriterNumberOrder.close();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(createOrderOfflineWithoutNameProduct)
                .when()
                .log().ifValidationFails()
                .post(createOfflineOrder);
        responseBody = response.getBody().asString();
        getJsonRequest(createOrderOfflineWithoutNameProduct);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Название товара : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем пустые/Невалидные поля при создании заказа")
    @Story("Создаём заказ в Оффлайне без Тип продукта")
    @Description("Бэк возвращает \"Номер заказа: Номер заказа должен быть уникальным\" в место \"Тип товара: Поле не может быть пустым\"")
    public void createOrderOfflineWithoutTypeProduct() throws IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOfflineOrder.txt");
        fileWriterNumberOrder.write(numberOffline + "4");
        fileWriterNumberOrder.close();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(createOrderOfflineWithoutTypeProduct)
                .when()
                .log().ifValidationFails()
                .post(createOfflineOrder);
        responseBody = response.getBody().asString();
        getJsonRequest(createOrderOfflineWithoutTypeProduct);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Тип товара : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем пустые/Невалидные поля при создании заказа")
    @Story("Создаём заказ в Оффлайне без Стоимости")
    @Description("Бэк возвращает \"Номер заказа: Номер заказа должен быть уникальным\" в место \"Стоимость: Поле не может быть пустым\"")
    public void createOrderOfflineWithoutCosts() throws IOException {
        FileWriter fileWriterNumberOrder = new FileWriter("numberOfflineOrder.txt");
        fileWriterNumberOrder.write(numberOffline + "5");
        fileWriterNumberOrder.close();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(createOrderOfflineWithoutCosts)
                .when()
                .log().ifValidationFails()
                .post(createOfflineOrder);
        responseBody = response.getBody().asString();
        getJsonRequest(createOrderOfflineWithoutCosts);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Стоимость : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем шаг Профиль с соц. статусом Коммерческим сотрудником")
    public void sendStepProfileOffline() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendProfileOffline)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendProfileOffline);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Невалидные данные.")
    @Story("Не отправляем Пол")
    public void sendStepProfileOfflineWithoutSex() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepProfileOfflineWithoutSex)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepProfileOfflineWithoutSex);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Пол : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Невалидные данные.")
    @Story("Не отправляем Социальный статус")
    public void sendStepProfileOfflineWithoutSocialStatus() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepProfileOfflineWithoutSocialStatus)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepProfileOfflineWithoutSocialStatus);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Социальный статус : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Невалидные данные.")
    @Story("Не Отправляем Дату рождения")
    public void sendStepProfileOfflineWithoutBirthday() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepProfileOfflineWithoutBirthday)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepProfileOfflineWithoutBirthday);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Дата рождения : This is not date");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Государственный служащий")
    public void sendSocialStausOfflinelhPLvIuA() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflinelhPLvIuA)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflinelhPLvIuA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем дату. 100 лет назад")
    public void sendOfflineGetDate100YearsLast() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendOfflineGetDate100YearsLast)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendOfflineGetDate100YearsLast);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Невалидные данные.")
    @Story("Отправляем дату 100 лет и 1 день назад")
    public void sendOfflineGetDate100YearAnd1dayLast() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendOfflineGetDate100YearAnd1dayLast)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendOfflineGetDate100YearAnd1dayLast);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Дата рождения : Дата не входит в диапазон");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Невалидные данные.")
    @Story("Отправляем дату 18 лет и 1 день назад")
    public void sendOfflineGetDate18YearsLastAnd1Day() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendOfflineGetDate18YearsLastAnd1Day)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendOfflineGetDate18YearsLastAnd1Day);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Дата рождения : Дата не входит в диапазон");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем дату 18 лет назад")
    public void sendOfflineGetDate18YearsLast() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendOfflineGetDate18YearsLast)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendOfflineGetDate18YearsLast);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }
    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Невалидные данные.")
    @Story("Отправляем завтрашнюю дату")
    public void sendOfflineGetDateTomorrow() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendOfflineGetDateTomorrow)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendOfflineGetDateTomorrow);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Дата рождения : Дата не входит в диапазон");
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Пенсионер")
    public void sendSocialStausOffline0vxo1sNN() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOffline0vxo1sNN)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOffline0vxo1sNN);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус ИП/Частная практика")
    public void sendSocialStausOfflinemtsip2() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflinemtsip2)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflinemtsip2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Предприниматель")
    public void sendSocialStausOfflineokcnc8te() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflineokcnc8te)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflineokcnc8te);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Собственник/совладелец компании")
    public void sendSocialStausOfflinemtsowner() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflinemtsowner)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflinemtsowner);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Декретный отпуск")
    public void sendSocialStausOfflinebX2QDLZE() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflinebX2QDLZE)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflinebX2QDLZE);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Домохозяйка")
    public void sendSocialStausOfflineJ6VBpaeU() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflineJ6VBpaeU)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflineJ6VBpaeU);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Студент")
    public void sendSocialStausOffline1r8IYIt8() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOffline1r8IYIt8)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOffline1r8IYIt8);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Не работаю")
    public void sendSocialStausOfflineDrBuzeAn() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflineDrBuzeAn)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflineDrBuzeAn);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "createNewOfflineOrder")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем социальный статус Разнорабочий")
    public void sendSocialStausOfflinerQrxbFSC() throws IOException {
        send = BasePathOffline + assessment + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialStausOfflinerQrxbFSC)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialStausOfflinerQrxbFSC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepProfileOffline")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Проверяем калькулятор, срок кредитования не должен быть == 0. Проверяем значения loanTermMin, loanTermMax, downPaymentMin, downPaymentMax")
    public void checkCalculator() throws IOException {
        send = BasePathOffline + "calc/programs&json=Y&order_id=" + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().ifValidationFails()
                .get(send);
        responseBody = response.getBody().asString();
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

    @Test(dependsOnMethods = "checkCalculator")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем параметры калькулятора")
    public void sendCalculator() throws IOException {
        send = BasePathOffline + "calc/save&json=Y&order_id=" + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCalculator)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCalculator);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
        result = jsonObject.get("order_id").getAsString();
        assertThat(result).isEqualTo(getOrderIdOfflineOfFile());
    }

    @Test(dependsOnMethods = "sendCalculator")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Запрашиваем СМС-код")
    public void getSmsCode() throws IOException {
        send = BasePathOffline + "profile/sendsms&json=Y&order_id=" + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(getSmsCode)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(getSmsCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
        String isAttempt = jsonObject.get("isAttempt").getAsString();
        assertThat(isAttempt).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "getSmsCode")
    @Feature("Отправляем шаг Профиль. Валидные данные.")
    @Story("Отправляем СМС-код")
    public void sendSmsCode() throws IOException {
        send = BasePathOffline + "profile/checkcode&json=Y&order_id=" + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSmsCode)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSmsCode);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Отправляем валидные данные.")
    public void sendStepPersonalData() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPersonalData)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPersonalData);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Отправляем Фамилию через дефис")
    public void sendStepPersonalDataHyphenatedSurname() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataHyphenatedSurname)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataHyphenatedSurname);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем Фамилию с символами")
    public void sendStepPersonalDataWithSimbolsInlastName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithSimbolsInlastName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithSimbolsInlastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Фамилия : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем Имя с символами")
    public void sendStepPersonalDataWithSimbolsInFirstName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithSimbolsInFirstName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithSimbolsInlastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Имя : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем Отчество с символами")
    public void sendStepPersonalDataWithSimbolsInSecondName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithSimbolsInSecondName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithSimbolsInSecondName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Отчество : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Отправляем Имя через дефис")
    public void sendStepPersonalDataHyphenatedFirstName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataHyphenatedFirstName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataHyphenatedFirstName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Отправляем Отчество через дефис")
    public void sendStepPersonalDataHyphenatedSecondName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataHyphenatedSecondName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataHyphenatedSecondName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Не отправляем Фамилию")
    public void sendStepPersonalDataWithoutLastName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutLastName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Фамилия : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем в фамилии Английские буквы")
    public void sendStepPersonalDataWithEnglishSimbolsInLastName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithEnglishSimbolsInLastName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutLastName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Фамилия : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Не отправляем Имя")
    public void sendStepPersonalDataWithoutFirstName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutFirstName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutFirstName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Имя : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем в Имя Английские буквы")
    public void sendStepPersonalDataWithEnglishSimbolsInFirstName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithEnglishSimbolsInFirstName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithEnglishSimbolsInFirstName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Имя : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Не отправляем Отчество")
    public void sendStepPersonalDataWithoutSecondName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutSecondName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutSecondName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем в Отчество Английские буквы")
    public void sendStepPersonalDataWithEnglishSimbolsInSecondName() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithEnglishSimbolsInSecondName)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithEnglishSimbolsInSecondName);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Отчество : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Не отправляем Серия и номер паспорта")
    public void sendStepPersonalDataWithoutSerialAndNumberPassport() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutSerialAndNumberPassport)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutSerialAndNumberPassport);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Серия и номер паспорта : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Не отправляем Серия и номер паспорта")
    public void sendStepPersonalDataWith0SerialAndNumberPassport() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWith0SerialAndNumberPassport)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWith0SerialAndNumberPassport);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем серию и номер паспорта через пробел")
    public void sendStepPersonalDataSerialAndNumberPassportOfflineThroughSpace() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataSerialAndNumberPassportOfflineThroughSpace)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataSerialAndNumberPassportOfflineThroughSpace);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Серия и номер паспорта : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Не отправляем Дата выдачи")
    public void sendStepPersonalDataWithoutDateIssue() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutDateIssue)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutDateIssue);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Дата выдачи : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Не отправляем Ежемесячный доход")
    public void sendStepPersonalDataWithoutMonthlyIncome() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutMonthlyIncome)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutMonthlyIncome);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем Ежемесячный доход в 8 символов")
    public void sendStepPersonalDataWithMonthlyIncomeIN8Simbols() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithMonthlyIncomeIN8Simbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithMonthlyIncomeIN8Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Валидные данные. СК.")
    @Story("Не отправляем email")
    public void sendStepPersonalDataWithoutEmail() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutEmail)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutEmail);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Отправляем в email русские буквы")
    public void sendStepPersonalDataWithEmailRussianSimbols() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithEmailRussianSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithEmailRussianSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Электронная почта : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendSmsCode")
    @Feature("Отправляем шаг Перс. данные. Невалидные данные. СК.")
    @Story("Не отправляем Номер телефона")
    public void sendStepPersonalDataWithoutPhone() throws IOException {
        send = BasePathOffline + profile + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepPersonalDataWithoutPhone)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepPersonalDataWithoutPhone);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Мобильный телефон : Поле не должно быть пустым");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Собственность")
    public void sendStepAdditionalData() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendAdditionalData)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendAdditionalData);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Аренда")
    public void sendPropertyTypeHomeZo8buZRw() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHomeZo8buZRw)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHomeZo8buZRw);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Проживаю у родственников")
    public void sendPropertyTypeHome73neHtC3() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHome73neHtC3)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHome73neHtC3);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Предоставляется работодателем")
    public void sendPropertyTypeHome2f2ATRAL() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHome2f2ATRAL)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHome2f2ATRAL);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Оплачено более 6 мес")
    public void sendPropertyTypeHomeikgSPiQC() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHomeikgSPiQC)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHomeikgSPiQC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Общежитие (Студент)")
    public void sendPropertyTypeHomeuv4It78N() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHomeuv4It78N)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHomeuv4It78N);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Собственность в залоге")
    public void sendPropertyTypeHomeu6Ks36W0() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHomeu6Ks36W0)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHomeu6Ks36W0);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Муниципальное жилье")
    public void sendPropertyTypeHomeuSnQ0Vb2X() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHomeSnQ0Vb2X)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHomeSnQ0Vb2X);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Тип недвижимости по адресу проживания Другое")
    public void sendPropertyTypeHomeYCOipzlk() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPropertyTypeHomeYCOipzlk)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPropertyTypeHomeYCOipzlk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Код подразделения 000-001")
    public void sendSubdivisionCodeOffline000001() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSubdivisionCodeOffline000001)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeOffline000001);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Код подразделения 000-455")
    public void sendSubdivisionCodeOffline000455() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSubdivisionCodeOffline000455)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeOffline000455);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Код подразделения рандом1")
    public void sendSubdivisionCodeOfflineRandom1() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSubdivisionCodeOfflineRandom1)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeOfflineRandom1);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем Код подразделения рандом2")
    public void sendSubdivisionCodeOfflineRandom2() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSubdivisionCodeOfflineRandom2)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSubdivisionCodeOfflineRandom2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем 200 символов в Кем выдан")
    public void sendIssuedPassportOfflineWith200Simbols() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWith200Simbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWith200Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем 2 символа в Кем выдан")
    public void sendIssuedPassportOfflineWith2Simbols() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWith2Simbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWith2Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем пробел и дефис в Кем выдан")
    public void sendIssuedPassportOfflineWithSpacesAndHyphen() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWithSpacesAndHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWithSpacesAndHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Невалидные данные. К.")
    @Story("Отправляем 201 символов в Кем выдан")
    public void sendIssuedPassportOfflineWith201Simbols() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWith201Simbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWith201Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Кем выдан : Колличество символов не должно превышать 201");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Невалидные данные. К.")
    @Story("Отправляем в Кем выдан текст начиная с -")
    @Description("Не верная фурмулировка. Символ \"-\" разрешён. Нужно изменить текст ошибки с \"Поле содержит недопустимые символы\" на \"Значение короче допустимого на 1 символ\" (либо любое другое)")
    public void sendIssuedPassportOfflineWithHyphen() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWithHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWithHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Кем выдан : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Невалидные данные. К.")
    @Story("Отправляем 1 символов в Кем выдан")
    @Description("Во фронте: При отправке 1 символа выводит ошибку \"Значение короче допустимого на 1 символов. Поле содержит недопустимые символы\", хотя нет недопустимых символов. Нужно изменить текст на \"Значение короче допустимого на 1 символ\"")
    public void sendIssuedPassportOfflineWith1Simbol() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWith1Simbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWith1Simbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Кем выдан : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Невалидные данные. К.")
    @Story("Отправляем Английские символов в Кем выдан")
    public void sendIssuedPassportOfflineWithEnglishSimbols() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendIssuedPassportOfflineWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendIssuedPassportOfflineWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Кем выдан : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Невалидные данные. К.")
    @Story("Отправляем Английские символов в Место рождения")
    public void sendBirthplaceOfflineWithEnglishSimbols() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBirthplaceOfflineWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBirthplaceOfflineWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Место рождения : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepPersonalData")
    @Feature("Отправляем шаг Доп. данные. Валидные данные. К.")
    @Story("Отправляем дефис в Место рождения")
    public void sendBirthplaceOfflineWithHyphen() throws IOException {
        send = BasePathOffline + additional + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBirthplaceOfflineWithHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBirthplaceOfflineWithHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем валидные данные")
    public void sendStepSocialData() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendSocialData)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendSocialData);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Личные среднемесячные расходы + 1 единица к Ежемесячный доход")
    public void sendStepSocialDataWitCostPlus1() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWitCostPlus1)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWitCostPlus1);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Девичью фамилию матери с Английскими символами")
    public void sendStepSocialDataWithMotherLastNameWithEnglishSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithMotherLastNameWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithMotherLastNameWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Девичья фамилия матери : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Фамилия контактного лица через дефис")
    public void sendStepSocialDataWithLastNameContactThroughHyphen() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithLastNameContactThroughHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithLastNameContactThroughHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Имя контактного лица через дефис")
    public void sendStepSocialDataWithFirstNameContactThroughHyphen() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithFirstNameContactThroughHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithFirstNameContactThroughHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Отчество контактного лица через дефис")
    public void sendStepSocialDataWithSecondNameContactThroughHyphen() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithSecondNameContactThroughHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithSecondNameContactThroughHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Фамилию контактного лица с Английскими символами")
    public void sendStepSocialDataWithLastNameContactWithEnglishSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithLastNameContactWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithLastNameContactWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Фамилия контактного лица : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Имя контактного лица с Английскими символами")
    public void sendStepSocialDataWithFirstNameContactWithEnglishSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithFirstNameContactWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithFirstNameContactWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Имя контактного лица : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Имя контактного лица с символами")
    public void sendStepSocialDataWithFirstNameContactWithSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithFirstNameContactWithSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithFirstNameContactWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Имя контактного лица : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Фамилию контактного лица с символами")
    public void sendStepSocialDataWithLastNameContactWithSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithLastNameContactWithSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithLastNameContactWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Фамилия контактного лица : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Отчество контактного лица с Английскими символами")
    public void sendStepSocialDataWithSecondNameContactWithEnglishSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithSecondNameContactWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithSecondNameContactWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Отчество контактного лица : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Отчество контактного лица с символами")
    public void sendStepSocialDataWithSecondNameContactWithSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithSecondNameContactWithSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithSecondNameContactWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Отчество контактного лица : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Название организации с Английскими символами")
    public void sendStepSocialDataWithCompanyNameWithEnglishSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithCompanyNameWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithCompanyNameWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Название организации состоящую только из символов")
    public void sendStepSocialDataWithCompanyNameWithSimbols() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepSocialDataWithCompanyNameWithSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepSocialDataWithCompanyNameWithSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Название организации : Формат поля неверный.");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Нет")
    public void sendEducationOfflineiMX4K9nC() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOfflineiMX4K9nC)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOfflineiMX4K9nC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Начальное или незаконченное среднее")
    public void sendEducationOffline864JGulJ() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOffline864JGulJ)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOffline864JGulJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Среднее")
    public void sendEducationOfflinejcolhX0Z() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOfflinejcolhX0Z)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOfflinejcolhX0Z);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Среднетехническое")
    public void sendEducationOfflinejjqjrJTK() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOfflinejjqjrJTK)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOfflinejjqjrJTK);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Специальное техническое")
    public void sendEducationOfflinetFQILYCv() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOfflinetFQILYCv)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOfflinetFQILYCv);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Незаконченное высшее")
    public void sendEducationOffline57Paul47() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOffline57Paul47)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOffline57Paul47);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Второе высшее")
    public void sendEducationOffline8IDMA3HA() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOffline8IDMA3HA)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOffline8IDMA3HA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Образование Степень")
    public void sendEducationOfflinenI429G0N() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEducationOfflinenI429G0N)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEducationOfflinenI429G0N);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Бытовые услуги")
    public void sendBusinessTypeOffline9JL0CJaJ() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOffline9JL0CJaJ)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOffline9JL0CJaJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Вооруженные силы")
    public void sendBusinessTypeOfflineYbZ9AkwY() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineYbZ9AkwY)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineYbZ9AkwY);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Гос.и муниципальные структуры")
    public void sendBusinessTypeOfflineGYwOPZHc() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineGYwOPZHc)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineGYwOPZHc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Детективное, охранное предприятие")
    public void sendBusinessTypeOfflinezfKLutAC() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinezfKLutAC)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinezfKLutAC);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации ЖКХ")
    public void sendBusinessTypeOfflinewqLuaWF5() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinewqLuaWF5)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinewqLuaWF5);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Издательская деятельность")
    public void sendBusinessTypeOfflineTLnIGYrA() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineTLnIGYrA)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineTLnIGYrA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Информационные технологии")
    public void sendBusinessTypeOfflineMZHlWynW() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineMZHlWynW)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineMZHlWynW);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Легкая промышленность")
    public void sendBusinessTypeOfflineT3eM0HYh() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineT3eM0HYh)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineT3eM0HYh);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Лесное хозяйство")
    public void sendBusinessTypeOfflineMRDuHN8B() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineMRDuHN8B)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineMRDuHN8B);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Машиностроение, металлургия")
    public void sendBusinessTypeOfflineRI4dVLx7() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineRI4dVLx7)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineRI4dVLx7);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Образование и наука")
    public void sendBusinessTypeOfflineqUvTRUyI() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineqUvTRUyI)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineqUvTRUyI);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Оптовая торговля")
    public void sendBusinessTypeOfflineSXSvcWC0() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineSXSvcWC0)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineSXSvcWC0);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Пищевая промышленность")
    public void sendBusinessTypeOfflinebUvScCuH() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinebUvScCuH)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinebUvScCuH);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Полиграфическая промышленность")
    public void sendBusinessTypeOfflineg8sPMDIf() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineg8sPMDIf)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineg8sPMDIf);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Посредническая деятельность")
    public void sendBusinessTypeOfflineYwy3KLwt() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineYwy3KLwt)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineYwy3KLwt);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Правоохранительные органы")
    public void sendBusinessTypeOfflineQdOlqnJy() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineQdOlqnJy)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineQdOlqnJy);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Реклама, PR агентства, СМИ")
    public void sendBusinessTypeOfflineGBE8nNMU() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineGBE8nNMU)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineGBE8nNMU);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Рестораны, кафе")
    public void sendBusinessTypeOffline7hOyZaSi() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOffline7hOyZaSi)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOffline7hOyZaSi);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Розничная торговля")
    public void sendBusinessTypeOfflineV9SXT6aF() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineV9SXT6aF)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineV9SXT6aF);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Салоны красоты, фитнес-центры")
    public void sendBusinessTypeOfflineSdvuwza2() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineSdvuwza2)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineSdvuwza2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Связь")
    public void sendBusinessTypeOffliner9v180sZ() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOffliner9v180sZ)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOffliner9v180sZ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Сельское хозяйство")
    public void sendBusinessTypeOfflinegusuzCJ6() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinegusuzCJ6)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinegusuzCJ6);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Строительство, строительные материалы")
    public void sendBusinessTypeOfflinexomrEYGH() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinexomrEYGH)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinexomrEYGH);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Транспорт")
    public void sendBusinessTypeOfflinespZgk3vs() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinespZgk3vs)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinespZgk3vs);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации ТЭК, горнодобывающая промышленность")
    public void sendBusinessTypeOfflineURpGBtDS() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineURpGBtDS)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineURpGBtDS);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Увеселительный, шоу-бизнес, туризм")
    public void sendBusinessTypeOfflinekiZh51bJ() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinekiZh51bJ)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinekiZh51bJ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Финансы, банковское дело")
    public void sendBusinessTypeOffline3CQJza5Y() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOffline3CQJza5Y)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOffline3CQJza5Y);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Юридические услуги")
    public void sendBusinessTypeOfflinePmApfVXO() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinePmApfVXO)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinePmApfVXO);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Другое")
    public void sendBusinessTypeOfflineXrsTOwWt() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineXrsTOwWt)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineXrsTOwWt);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Игорный бизнес")
    public void sendBusinessTypeOfflineCFgxtHBa() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineCFgxtHBa)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineCFgxtHBa);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Страхование")
    public void sendBusinessTypeOfflineyi2BL42u() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineyi2BL42u)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineyi2BL42u);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Благотворительные и религиозные организации")
    public void sendBusinessTypeOfflinezp9P7jO8() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinezp9P7jO8)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinezp9P7jO8);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Подбор персонала")
    public void sendBusinessTypeOfflineLFKbshBl() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflineLFKbshBl)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflineLFKbshBl);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Химия, парфюмерия, фармацевтика")
    public void sendBusinessTypeOfflinemtschymistry() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinemtschymistry)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinemtschymistry);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Производство и распределение электроэнергии, газа, воды")
    public void sendBusinessTypeOfflinemtsenergy() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinemtsenergy)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinemtsenergy);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Производство строительных материалов")
    public void sendBusinessTypeOfflinemtsconstrmaterials() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinemtsconstrmaterials)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinemtsconstrmaterials);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Складское хранение и логистика")
    public void sendBusinessTypeOfflinemtslogistics2() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinemtslogistics2)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinemtslogistics2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Операции с недвижимостью")
    public void sendBusinessTypeOfflinemtsseo() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinemtsseo)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinemtsseo);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Аудит, консталтинг")
    public void sendBusinessTypeOfflinemtsaudit() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendBusinessTypeOfflinemtsaudit)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendBusinessTypeOfflinemtsaudit);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Вид деятельности организации Младший специалист")
    public void sendPositionTypeOfflinerZ0E4mZP() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPositionTypeOfflinerZ0E4mZP)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeOfflinerZ0E4mZP);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Тип должности Старший специалист")
    public void sendPositionTypeOfflinecEGMbybk() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPositionTypeOfflinecEGMbybk)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeOfflinecEGMbybk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Тип должности Начинающий руководитель")
    public void sendPositionTypeOfflinenbzIyADA() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPositionTypeOfflinenbzIyADA)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeOfflinenbzIyADA);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Тип должности Руководитель с опытом")
    public void sendPositionTypeOfflinemjwE1TnM() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPositionTypeOfflinemjwE1TnM)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeOfflinemjwE1TnM);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Тип должности Руководитель высшего звена")
    public void sendPositionTypeOfflineau38D9bk() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendPositionTypeOfflineau38D9bk)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendPositionTypeOfflineau38D9bk);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Бабушка")
    public void sendRelationDegreeOffline7q9E0NKr() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOffline7q9E0NKr)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOffline7q9E0NKr);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Дедушка")
    public void sendRelationDegreeOfflineLnxmURg4() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflineLnxmURg4)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflineLnxmURg4);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Дочь")
    public void sendRelationDegreeOfflinelR4v6uLT() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinelR4v6uLT)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinelR4v6uLT);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Друг/подруга")
    public void sendRelationDegreeOfflinevDPgw1Q6() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinevDPgw1Q6)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinevDPgw1Q6);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Другой родственник")
    public void sendRelationDegreeOfflineC7ZMgbyc() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflineC7ZMgbyc)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflineC7ZMgbyc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Клиент")
    public void sendRelationDegreeOfflineOVOxPkpx() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflineOVOxPkpx)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflineOVOxPkpx);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Коллега")
    public void sendRelationDegreeOfflinerDzqPVJr() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinerDzqPVJr)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinerDzqPVJr);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Мать")
    public void sendRelationDegreeOfflinexKraP9DQ() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinexKraP9DQ)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinexKraP9DQ);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Остальные")
    public void sendRelationDegreeOffline0LilZJnc() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOffline0LilZJnc)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOffline0LilZJnc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Отец")
    public void sendRelationDegreeOfflineekYxqj5U() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflineekYxqj5U)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflineekYxqj5U);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Сын")
    public void sendRelationDegreeOffline81dEVcZS() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOffline81dEVcZS)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOffline81dEVcZS);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Сестра")
    public void sendRelationDegreeOfflinesDTKdM7Z() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinesDTKdM7Z)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinesDTKdM7Z);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Внук")
    public void sendRelationDegreeOfflinemtsgrandchild() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinemtsgrandchild)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinemtsgrandchild);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Кем приходится контактное лицо Внучка")
    public void sendRelationDegreeOfflinemtsgrandchild2() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendRelationDegreeOfflinemtsgrandchild2)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendRelationDegreeOfflinemtsgrandchild2);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Подозрение на мошенничество")
    public void sendCustomerEstimateOfflinenR9SpJQI() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinenR9SpJQI)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinenR9SpJQI);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Подозрительный внешний вид")
    public void sendCustomerEstimateOfflinelMuGGgHq() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinelMuGGgHq)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinelMuGGgHq);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Неадекватное / подозрительное поведение")
    public void sendCustomerEstimateOffline2VHwUFwG() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOffline2VHwUFwG)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOffline2VHwUFwG);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Противоречивые перс. данные")
    public void sendCustomerEstimateOfflinecg45v345fdgc() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinecg45v345fdgc)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinecg45v345fdgc);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Влияние третьих лиц")
    public void sendCustomerEstimateOfflinec45cg845hhh() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinec45cg845hhh)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinec45cg845hhh);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Подозрительный паспорт")
    public void sendCustomerEstimateOfflinecfg42g57b67() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinecfg42g57b67)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinecfg42g57b67);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Подозрительные доп. документы")
    public void sendCustomerEstimateOfflinen545cvb7u567() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinen545cvb7u567)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinen545cvb7u567);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Подозрительные финансовые документы")
    public void sendCustomerEstimateOfflinen8i57kv4f5fr() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinen8i57kv4f5fr)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinen8i57kv4f5fr);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Недействительные документы")
    public void sendCustomerEstimateOfflinecu28cr203u93() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinecu28cr203u93)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinecu28cr203u93);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Клиент имеет просроченную задолженность")
    public void sendCustomerEstimateOfflinexm3e1019fd21() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinexm3e1019fd21)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinexm3e1019fd21);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Не имеет официального места работы")
    public void sendCustomerEstimateOfflined289dh1h21() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflined289dh1h21)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflined289dh1h21);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Место работы не подтверждено")
    public void sendCustomerEstimateOfflinecn19cby9132() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinecn19cby9132)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinecn19cby9132);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Не подходит под ограничения банков")
    public void sendCustomerEstimateOfflinec18761cb19e9() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOfflinec18761cb19e9)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOfflinec18761cb19e9);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Визуальная оценка Другое")
    public void sendCustomerEstimateOffline3cn139cb12hmi() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCustomerEstimateOffline3cn139cb12hmi)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCustomerEstimateOffline3cn139cb12hmi);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Семейное положение Разведен/разведена")
    public void sendMaritalStatusOfflineADoBCpAh() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendMaritalStatusOfflineADoBCpAh)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusOfflineADoBCpAh);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Семейное положение Раздельное проживание")
    public void sendMaritalStatusOfflineXCuGVp6h() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendMaritalStatusOfflineXCuGVp6h)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusOfflineXCuGVp6h);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Семейное положение Вдова/вдовец")
    public void sendMaritalStatusOfflinepfQr7U3s() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendMaritalStatusOfflinepfQr7U3s)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusOfflinepfQr7U3s);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Семейное положение Гражданский брак")
    public void sendMaritalStatusOffline0LqzSuFm() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendMaritalStatusOffline0LqzSuFm)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusOffline0LqzSuFm);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Соц. данные. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Семейное положение Женат/замужем")
    public void sendMaritalStatusOffline5KvUof3u() throws IOException {
        send = BasePathOffline + social + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendMaritalStatusOffline5KvUof3u)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendMaritalStatusOffline5KvUof3u);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее")
    public void sendStepOther() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOther)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOther);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее C Фамилия дополнительного контактного лица через дефис")
    public void sendStepOtherWithLastNameContactThroughHyphen() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherWithLastNameContactThroughHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherWithLastNameContactThroughHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее C Имянем дополнительного контактного лица через дефис")
    public void sendStepOtherWithFirstNameContactThroughHyphen() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherWithFirstNameContactThroughHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherWithFirstNameContactThroughHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее C Отчеством дополнительного контактного лица через дефис")
    public void sendStepOtherWithSecondNameContactThroughHyphen() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherWithSecondNameContactThroughHyphen)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherWithSecondNameContactThroughHyphen);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее C Фамилией дополнительного контактного лица с английскими символами")
    public void sendStepOtherWithLastNameContactWithEnglishSimbols() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherWithLastNameContactWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherWithLastNameContactWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее C Имянем дополнительного контактного лица с английскими символами")
    public void sendStepOtherWithFirstNameContactWithEnglishSimbols() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherWithFirstNameContactWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherWithFirstNameContactWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Шаг Прочее C Отчеством дополнительного контактного лица с английскими символами")
    public void sendStepOtherSecondFirstNameContactWithEnglishSimbols() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherSecondFirstNameContactWithEnglishSimbols)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherSecondFirstNameContactWithEnglishSimbols);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Расходы на жилье и коммунальные услуги равные Личному месячному доходу")
    public void sendStepOtherUtilitiesMonthlyPayments() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherUtilitiesMonthlyPayments)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherUtilitiesMonthlyPayments);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Расходы на жилье и коммунальные услуги больше на 1 Личному месячному доходу")
    public void sendStepOtherUtilitiesMonthlyPaymentsPlus1() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherUtilitiesMonthlyPaymentsPlus1)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherUtilitiesMonthlyPaymentsPlus1);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
        result = jsonObject.get("message").getAsString();
        assertThat(result).isEqualTo("Расходы на жилье и коммунальные услуги : Значение должно быть меньше 130001");
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Расходы на жилье и коммунальные состоящую из 10 чисел")
    public void sendStepOtherUtilitiesMonthlyPayments10() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherUtilitiesMonthlyPayments10)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherUtilitiesMonthlyPayments10);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueFalse);
    }

    @Test(dependsOnMethods = "sendStepAdditionalData")
    @Feature("Отправляем шаг Прочее. Невалидные данные. Д - РСБ, Тинькофф, МТС.")
    @Story("Отправляем Семейный среднемесячный доход меньше Личного месячного дохода")
    public void sendStepOtherFamilyMonthlyIncome() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendStepOtherFamilyMonthlyIncome)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendStepOtherFamilyMonthlyIncome);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем кол-во сотрудников От 10 до 100 человек")
    public void sendEmployeesOffline1LwmhdES() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEmployeesOffline1LwmhdES)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEmployeesOffline1LwmhdES);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем кол-во сотрудников От 100 до 1000 человек")
    public void sendEmployeesOfflinea2C9ZNqu() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEmployeesOfflinea2C9ZNqu)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEmployeesOfflinea2C9ZNqu);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем кол-во сотрудников Свыше 1000 человек")
    public void sendEmployeesOfflineBK5XTLyG() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEmployeesOfflineBK5XTLyG)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEmployeesOfflineBK5XTLyG);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем кол-во сотрудников От 500 до 1000 человек")
    public void sendEmployeesOfflinemts500() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendEmployeesOfflinemts500)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendEmployeesOfflinemts500);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Япония")
    public void sendCountryOfBirthOfflineNjBlOWM5() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineNjBlOWM5)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineNjBlOWM5);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Франция")
    public void sendCountryOfBirthOfflineYzMzZDI5() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineYzMzZDI5)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineYzMzZDI5);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Украина")
    public void sendCountryOfBirthOfflineOTQwOTM4() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineOTQwOTM4)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineOTQwOTM4);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Турция")
    public void sendCountryOfBirthOfflinezYjEyYmU() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflinezYjEyYmU)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflinezYjEyYmU);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Сент - Китс и Невис")
    public void sendCountryOfBirthOfflineYjlmODU0() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineYjlmODU0)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineYjlmODU0);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения США")
    public void sendCountryOfBirthOfflineNTk0ODk3() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineNTk0ODk3)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineNTk0ODk3);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Объединенные Арабские Эмираты")
    public void sendCountryOfBirthOfflineMzFkYWUy() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineMzFkYWUy)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineMzFkYWUy);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Корея (Республика)")
    public void sendCountryOfBirthOfflineZGMyYmMw() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineZGMyYmMw)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineZGMyYmMw);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Доминиканская Республика")
    public void sendCountryOfBirthOfflineMDYxMGIy() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineMDYxMGIy)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineMDYxMGIy);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Виргинские острова (Британия)")
    public void sendCountryOfBirthOfflineMTZiNTIw() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineMTZiNTIw)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineMTZiNTIw);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения Саудовская Аравия")
    public void sendCountryOfBirthOfflineYyOWVlYz() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflineYyOWVlYz)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflineYyOWVlYz);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем Страна рождения СССР")
    public void sendCountryOfBirthOfflinemts_sssr() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendCountryOfBirthOfflinemts_sssr)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendCountryOfBirthOfflinemts_sssr);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем C кем проживаете Другое")
    public void sendJointResidencexlmofxwaForVostochkaBank() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendJointResidencexlmofxwaForVostochkaBank)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendJointResidencexlmofxwaForVostochkaBank);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем C кем проживаете С родителями")
    public void sendJointResidencenaZd4QZ1ForVostochkaBank() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendJointResidencenaZd4QZ1ForVostochkaBank)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendJointResidencenaZd4QZ1ForVostochkaBank);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем C кем проживаете С родителями и родственниками")
    public void sendJointResidenceczlHm2AvForVostochkaBank() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendJointResidenceczlHm2AvForVostochkaBank)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendJointResidenceczlHm2AvForVostochkaBank);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Отправляем шаг Прочее. Валидные данные. Д - Рен, ОТП, Почта, Восточка, ХКБ, Русфинанс, Кеб.")
    @Story("Отправляем C кем проживаете С родственниками")
    public void sendJointResidenceVHRDxjmCForVostochkaBank() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendJointResidenceVHRDxjmCForVostochkaBank)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendJointResidenceVHRDxjmCForVostochkaBank);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }

    @Test(dependsOnMethods = "sendStepSocialData")
    @Feature("Решение банкомВыбираем банк")
    @Story("Отправляем C кем проживаете С родственниками")
    public void choiceBank() throws IOException {
        send = BasePathOffline + other + getOrderIdOfflineOfFile();
        response = expect()
                .statusCode(200)
                .given()
                .header("cache-control", cachControl)
                .cookie("PHPSESSID", getPhpSessId())
                .contentType(JSON)
                .log().all()
                .body(sendJointResidenceVHRDxjmCForVostochkaBank)
                .when()
                .log().ifValidationFails()
                .post(send);
        responseBody = response.getBody().asString();
        getJsonRequest(sendJointResidenceVHRDxjmCForVostochkaBank);
        getResponse(responseBody);
        System.out.println(responseBody);
        jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        result = jsonObject.get("result").getAsString();
        assertThat(result).isEqualTo(valueTrue);
    }
}

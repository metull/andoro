package TestPackage;

import TestAndroidOrIOS.AppiumMobileAndroid;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static PageOperations.OtherMethods.RandomMethods.*;
import static PageOperations.PageOperation.*;

public class TestAndroid extends AppiumMobileAndroid {
    public String loanTerm = "10";
    public String downPayment = "10";

    @Epic("Проверка отправляемых данных в Оффлайне анкете и сохранение их в БД")
    @Test
    @Feature("Создаём заказ в Онлайне через мобилку")
    @Story("Различные надписинас переход в калькулятор ")
    public void tessOnlineOnAndroidOrIOS() throws Exception {
        System.out.println("Step 1.Create new driver");

        System.out.println("Step 2.Open website");
        appiumDriver.get("https://test.direct-credit.ru/api/shop.php?shop_id=1316853&token=q75sb21&shop_region=S029&token=q75sb21");

        System.out.println("Step 3. Write phone client");
        stringValue = byId("client_phone", "Телефон");
        stringValue.sendKeys("9969602297");

        System.out.println("Step 4. Write last name client");
        stringValue = byId("client_last_name", "Имя") ;
        stringValue.sendKeys(randomLastName());

        System.out.println("Step 5. Write first name client");
        stringValue = byId("client_first_name", "Фамилия");
        stringValue.sendKeys(randomFirstName());

        System.out.println("Step 6. Write second name client");
        stringValue = byId("client_second_name", "Имя");
        stringValue.sendKeys(randomSecondName());
        Thread.sleep(1000);

        System.out.println("Step 7. Select product");
        stringValue = byXpath("//input[@id='88781']", "Товар");
        stringValue.click();
        Thread.sleep(1000);

        System.out.println("Step 8. click on button");
        stringValue = byXpath("//input[@id='order']", "Оформляем заказ");
        stringValue.click();

        System.out.println("Step 9. Switch to frame");
        stringValue = byXpath("//iFrame[@id='DCiFrame']", "go to iFrame");
        appiumDriver.switchTo().frame(stringValue);

        System.out.println("Step 10. Wrtie serial and number passport");
        stringValue = byXpath("//input[@placeholder='Серия и номер паспорта']", "Серия и номер паспорта");
        stringValue.click();
        Thread.sleep(1000);
        stringValue.sendKeys(randomPhone(10));
        Thread.sleep(1000);

        /**      System.out.println("Step 11. Открываем калькулятор");
        stringValue = byXpath("//div[@class='col-12 reset-bottom-padding text-center']//a", "Открыть калькулятор →");
        stringValue.click();

        System.out.println("Step 12. Изменяем первоначальный взнос");
        stringValue = byXpath("//online-calc-tab[@title='Срок кредитования']//input",  "Срок кредитования:");
        stringValue.clear();
        stringValue.sendKeys(loanTerm);

        System.out.println("Step 13. Изменяем срок кредита");
        stringValue = byXpath("//online-calc-tab[@title='Первоначальный взнос']//input", "Первоначальный взнос:");
        stringValue.clear();
        stringValue.sendKeys(downPayment);

        System.out.println("Step 14. Сохраняем шаг калькулятора");
        stringValue = byXpath("//div[@align='spaceBetween']//button[@class='mat-raised-button mat-primary']", "для ХКБ");
        stringValue.click();
         */

        System.out.println("Step 15. Запрашиваем СМС-код");
        stringValue = byXpath("//span[@class='mat-button-wrapper']", "Заполнить анкету и получить решения");
        stringValue.click();

        System.out.println("Step 16. отправляем СМС-Код СМС-код");
        stringValue = byXpath("//input[@placeholder='Код из SMS']", "Код из SMS");
        stringValue.sendKeys("111111");

        System.out.println("Step 17. Указываем пол");
        stringValue = byXpath("//mat-button-toggle[@id='mat-button-toggle-2']", "Мужской");
        stringValue.click();

        System.out.println("Step 18. Вносим дату рождения");
        stringValue = byXpath("//input[@placeholder='Дата рождения']",  "Дата рождения");
        stringValue.sendKeys(randomDate());

        System.out.println("Step 19. Указываем ежемесячный доход");
        stringValue = byXpath("//input[@id='monthly_income']", "Ежемесячный доход");
        stringValue.sendKeys("130000");

        System.out.println("Step 20. Указываем серию паспорта");
        stringValue = byXpath("//input[@id='serial_passport']", "Серия и номер");
        stringValue.sendKeys(randomPhone(4));

        System.out.println("Step 21. Указываем номер паспорта");
        stringValue = byXpath("//input[@id='number_passport']", "Серия и номер");
        stringValue.sendKeys(randomPhone(6));

        System.out.println("Step 22. Указываем дату выдачи паспорт");
        stringValue = byXpath("//input[@id='date_issue']", "Дата выдачи паспорта");
        stringValue.sendKeys(staticDate());

        System.out.println("Step 23. Указываем электронную почту");
        stringValue = byXpath("//input[@id='email']",  "Электронная почта");
        stringValue.sendKeys(randomEmail(6));

        System.out.println("Step 24. Указываем дату выдачи");
        stringValue = byXpath("//input[@placeholder='Дата выдачи']", "Дата выдачи");
        stringValue.sendKeys(staticDate());

        System.out.println("Step 25. Отправляем заявку по СК");
        stringValue = byXpath("//span[@class='mat-button-wrapper']", "date of issue");
        stringValue.click();
    }
}

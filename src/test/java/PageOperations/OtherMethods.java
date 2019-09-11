package PageOperations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

import static FilesForWrites.FilesToWrites.*;
import static PageOperations.PageOperation.byXpath;
import static TestAndroidOrIOS.AppiumMobileAndroid.appiumDriver;

public class OtherMethods {

    public static String date;
    public static int textYY;
    protected static WebElement stringValue;
    protected static LocalDate localDateTime;

    public static class RandomMethods {

        public static void doubleClick(String xpath) throws Exception {
            stringValue = byXpath(xpath, "dc");
            Actions action = new Actions(appiumDriver);
            action.doubleClick(stringValue).perform();
        }

        public static int random(int lowerBound, int upperBound) {
            return (lowerBound + (int) Math.round(Math.random() * (upperBound - lowerBound)));
        }

        public static boolean isLeapYear(int year) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
            if (noOfDays > 365) {
                return true;
            }
            return false;
        }


        public static String randomDate() throws IOException {

            int yyyy = random(1920, 2001);
            int mm = random(1, 12);
            int dd = 0;

            switch (mm) {
                case 2:
                    if (isLeapYear(yyyy)) {
                        dd = random(1, 29);
                    } else {
                        dd = random(1, 28);
                    }
                    break;

                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    dd = random(1, 31);
                    break;

                default:
                    dd = random(1, 30);
                    break;
            }

            String year = Integer.toString(yyyy);
            String month = Integer.toString(mm);
            String day = Integer.toString(dd);

            if (mm < 10) {
                month = "0" + mm;
            }

            if (dd < 10) {
                day = "0" + dd;
            }
            FileWriter fileWriterDD = new FileWriter(getString() + dateDD);
            fileWriterDD.write(day);
            fileWriterDD.close();
            FileWriter fileWriterMM = new FileWriter(getString() + dateMM);
            fileWriterMM.write(month);
            fileWriterMM.close();
            FileWriter fileWriterYY = new FileWriter(getString() + dateYY);
            fileWriterYY.write(year);
            fileWriterYY.close();
            return day + month + year;
        }

        public static String getDateNowDD() {
            localDateTime = LocalDate.now();
            date = localDateTime.format(DateTimeFormatter.ofPattern("dd"));
            return date;
        }

        public static String getDateNowMM() {
            localDateTime = LocalDate.now();
            date = localDateTime.format(DateTimeFormatter.ofPattern("MM"));
            return date;
        }

        public static String getDateNowddMM() {
            localDateTime = LocalDate.now();
            date = localDateTime.format(DateTimeFormatter.ofPattern("ddMM"));
            return date;
        }

        public static String getDateMM() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getString() + dateMM)));
            return bufferedReader.readLine();
        }

        public static String getDateDD() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getString() + dateDD)));
            return bufferedReader.readLine();
        }

        public static String getDateYY() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getString() + dateYY)));
            return bufferedReader.readLine();
        }

        public static String staticDate() throws IOException {
            int i = Integer.parseInt(getDateYY());

            if (i >= 1920 && i <= 1973 && Integer.parseInt(getDateNowDD()) + Integer.parseInt(getDateNowMM()) + i < Integer.parseInt(getDateNowddMM()) + 1974) {
                textYY = i + 45;
                System.out.println("добавляем 45 лет");
                FileWriter writer = new FileWriter(getString() + getDateYYFinal);
                writer.write(String.valueOf(textYY));
                writer.close();
            } else if (Integer.parseInt(getDateNowDD()) + Integer.parseInt(getDateNowMM()) + i >= Integer.parseInt(getDateNowDD()) + Integer.parseInt(getDateNowMM()) + 1974 && Integer.parseInt(getDateNowDD()) + Integer.parseInt(getDateNowMM()) + i <= Integer.parseInt(getDateNowDD()) + Integer.parseInt(getDateNowMM()) + 1999) {
                textYY = i + 20;
                System.out.println("добавили 20");
                FileWriter writer = new FileWriter(getString() + getDateYYFinal);
                writer.write(String.valueOf(textYY));
                writer.close();
            }

            return getDateDD() + getDateMM() + textYY;
        }

        private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>();

        public static String getString() {
            return stringThreadLocal.get();
        }

        public static void setString(String string) {
            stringThreadLocal.set(string);
        }


        static String[] lastName = {"Смирнова", "Зиновьев", "Зуев", "Зыков", "Иванков", "Иванов", "Игнатов", "Игнатьев", "Ильин", "Исаев", "Исаков", "Кабанов", "Казаков", "Калашников", "Калинин", "Капустин", "Карпов",
                "Кириллов", "Киселёв", "Князев", "Ковалёв", "Козлов", "Колесников", "Колобов", "Комаров", "Комиссаров", "Кондратьев", "Коновалов", "Кононов", "Константинов", "Копылов", "Корнилов", "Королёв",
                "Костин", "Котов", "Кошелев", "Красильников", "Крылов", "Крюков", "Кудрявцев", "Кудряшов", "Кузнецов", "Кузьмин", "Кулагин", "Кулаков", "Куликов", "Лаврентьев", "Лазарев", "Лапин", "Ларионов",
                "Лебедев", "Лихачёв", "Лобанов", "Логинов", "Лукин", "Лыткин", "Макаров", "Максимов", "Мамонтов", "Марков", "Мартынов", "Маслов", "Матвеев", "Медведев", "Мельников", "Меркушев", "Миронов",
                "Михайлов", "Михеев", "Мишин", "Моисеев", "Молчанов", "Морозов", "Муравьёв", "Мухин"};

        static String[] firsName = {"Аарон", "Абрам", "Аваз", "Августин", "Авраам", "Агап", "Агапит", "Агафон", "Адам", "Адриан", "Азамат", "Азат", "Айдар", "Айрат", "Акакий", "Аким", "Алан", "Александр",
                "Алексей", "Али", "Алик", "Алим", "Алихан", "Алишер", "Алмаз", "Альберт", "Амир", "Амирам", "Анар", "Анастасий", "Анатолий", "Анвар", "Ангел", "Андрей", "Анзор", "Антон", "Артур",
                "Архип", "Аскар", "Асхан", "Асхат", "Ахмет", "Ашот", "Бахрам", "Блез", "Богдан", "Борис", "Борислав", "Бронислав", "Булат", "Вадим", "Валентин", "Валерий", "Вальдемар", "Вардан",
                "Василий", "Вениамин", "Виктор", "Вильгельм", "Вит", "Виталий", "Владимир", "Владислав", "Владлен", "Влас", "Всеволод", "Вячеслав", "Гавриил", "Гамлет", "Гарри", "Геннадий",
                "Генри", "Генрих", "Георгий", "Герасим", "Герман", "Германн", "Глеб", "Гордей", "Григорий", "Густав", "Давид", "Давлат", "Дамир", "Дана", "Даниил", "Данислав", "Даниэль",
                "Данияр", "Дарий", "Даурен", "Демид", "Демьян", "Денис", "Джамал", "Джан", "Джеймс", "Джереми", "Джозеф", "Джонатан", "Дик", "Динар", "Дино", "Дмитрий", "Добрыня", "Доминик"};

        static String[] secondName = {"Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Антонович", "Аркадьевич", "Арсеньевич", "Артемович", "Афанасьевич", "Богданович", "Борисович", "Вадимович", "Валентинович",
                "Валериевич", "Васильевич", "Викторович", "Витальевич", "Владимирович", "Всеволодович", "Вячеславович", "Гаврилович", "Геннадиевич", "Георгиевич", "Глебович", "Григорьевич", "Давыдович", "Данилович",
                "Денисович", "Дмитриевич", "Евгеньевич", "Егорович", "Емельянович", "Ефимович", "Иванович", "Игоревич", "Ильич", "Иосифович", "Кириллович", "Константинович", "Корнеевич", "Леонидович", "Львович",
                "Макарович", "Максимович", "Маркович", "Матвеевич", "Митрофанович", "Михайлович", "Назарович", "Наумович", "Николаевич", "Олегович", "Павлович", "Петрович", "Платонович", "Робертович",
                "Родионович", "Романович", "Савельевич", "Семенович", "Сергеевич", "Станиславович", "Степанович", "Тарасович", "Тимофеевич", "Тихонович", "Федорович", "Феликсович", "Филиппович", "Эдуардович",
                "Юрьевич", "Яковлевич", "Ярославович"};

        static final String email = "qwertyuiopasdfghjklzxcvbnm123456789";
        static SecureRandom rndE = new SecureRandom();

        static final String phone = "1234567890";
        static SecureRandom rndP = new SecureRandom();

        static final String AB = "АБВГДЕЁЖЗИКЛМНОПРСТУФЧШЩЪЫЬЭЮЯ";
        static SecureRandom rnd = new SecureRandom();

        public static String randomFirstName() {
            Random random = new Random();
            int text = random.nextInt(firsName.length);
            return firsName[text];
        }

        public static String randomLastName() {
            Random random = new Random();
            int text = random.nextInt(lastName.length);
            return lastName[text];
        }

        public static String randomSecondName() {
            Random random = new Random();
            int text = random.nextInt(secondName.length);
            return secondName[text];
        }

        public static String randomPhone(int len) {
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(phone.charAt(rndP.nextInt(phone.length())));
            return sb.toString();
        }

        public static String randomEmail(int len) {
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(email.charAt(rndE.nextInt(AB.length())));
            String emailRes = sb.toString() + "@gmail.com";
            return emailRes;
        }
    }
}

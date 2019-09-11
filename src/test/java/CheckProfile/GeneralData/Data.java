package CheckProfile.GeneralData;

import java.security.SecureRandom;
import java.util.Random;

public class Data {

    private static String[] lastName = {"Смирнова", "Зиновьев", "Зуев", "Зыков", "Иванков", "Иванов", "Игнатов", "Игнатьев", "Ильин", "Исаев", "Исаков", "Кабанов", "Казаков", "Калашников", "Калинин", "Капустин", "Карпов",
            "Кириллов", "Киселёв", "Князев", "Ковалёв", "Козлов", "Колесников", "Колобов", "Комаров", "Комиссаров", "Кондратьев", "Коновалов", "Кононов", "Константинов", "Копылов", "Корнилов", "Королёв",
            "Костин", "Котов", "Кошелев", "Красильников", "Крылов", "Крюков", "Кудрявцев", "Кудряшов", "Кузнецов", "Кузьмин", "Кулагин", "Кулаков", "Куликов", "Лаврентьев", "Лазарев", "Лапин", "Ларионов",
            "Лебедев", "Лихачёв", "Лобанов", "Логинов", "Лукин", "Лыткин", "Макаров", "Максимов", "Мамонтов", "Марков", "Мартынов", "Маслов", "Матвеев", "Медведев", "Мельников", "Меркушев", "Миронов",
            "Михайлов", "Михеев", "Мишин", "Моисеев", "Молчанов", "Морозов", "Муравьёв", "Мухин"};

    private static String[] firsName = {"Аарон", "Абрам", "Аваз", "Августин", "Авраам", "Агап", "Агапит", "Агафон", "Адам", "Адриан", "Азамат", "Азат", "Айдар", "Айрат", "Акакий", "Аким", "Алан", "Александр",
            "Алексей", "Али", "Алик", "Алим", "Алихан", "Алишер", "Алмаз", "Альберт", "Амир", "Амирам", "Анар", "Анастасий", "Анатолий", "Анвар", "Ангел", "Андрей", "Анзор", "Антон", "Артур",
            "Архип", "Аскар", "Асхан", "Асхат", "Ахмет", "Ашот", "Бахрам", "Блез", "Богдан", "Борис", "Борислав", "Бронислав", "Булат", "Вадим", "Валентин", "Валерий", "Вальдемар", "Вардан",
            "Василий", "Вениамин", "Виктор", "Вильгельм", "Вит", "Виталий", "Владимир", "Владислав", "Владлен", "Влас", "Всеволод", "Вячеслав", "Гавриил", "Гамлет", "Гарри", "Геннадий",
            "Генри", "Генрих", "Георгий", "Герасим", "Герман", "Германн", "Глеб", "Гордей", "Григорий", "Густав", "Давид", "Давлат", "Дамир", "Дана", "Даниил", "Данислав", "Даниэль",
            "Данияр", "Дарий", "Даурен", "Демид", "Демьян", "Денис", "Джамал", "Джан", "Джеймс", "Джереми", "Джозеф", "Джонатан", "Дик", "Динар", "Дино", "Дмитрий", "Добрыня", "Доминик"};

    private static String[] secondName = {"Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Антонович", "Аркадьевич", "Арсеньевич", "Артемович", "Афанасьевич", "Богданович", "Борисович", "Вадимович", "Валентинович",
            "Валериевич", "Васильевич", "Викторович", "Витальевич", "Владимирович", "Всеволодович", "Вячеславович", "Гаврилович", "Геннадиевич", "Георгиевич", "Глебович", "Григорьевич", "Давыдович", "Данилович",
            "Денисович", "ДмитриевичЕвгеньевич", "Егорович", "Емельянович", "Ефимович", "Иванович", "Игоревич", "Ильич", "Иосифович", "Кириллович", "Константинович", "Корнеевич", "Леонидович", "Львович",
            "Макарович", "Максимович", "Маркович", "Матвеевич", "Митрофанович", "Михайлович", "Назарович", "Наумович", "Николаевич", "Олегович", "Павлович", "Петрович", "Платонович", "Робертович",
            "Родионович", "Романович", "Савельевич", "Семенович", "Сергеевич", "Станиславович", "Степанович", "Тарасович", "Тимофеевич", "Тихонович", "Федорович", "Феликсович", "Филиппович", "Эдуардович",
            "Юрьевич", "Яковлевич", "Ярославович"};

    static String randomFirstName() {
        Random random = new Random();
        int text = random.nextInt(firsName.length);
        return firsName[text];
    }

    static String randomLastName() {
        Random random = new Random();
        int text = random.nextInt(lastName.length);
        return lastName[text];
    }

    static String randomSecondName() {
        Random random = new Random();
        int text = random.nextInt(secondName.length);
        return secondName[text];
    }

    private static SecureRandom newRandom = new SecureRandom();

    private static final String AB = "АБВГДЕЁЖЗИКЛМНОПРСТУФЧШЩЪЫЬЭЮЯ";
    private static final String phone = "1234567890";
    private static final String english = "qwertyuiopasdfghjklzxcvbnm";
    private static final String randomSerialNumberPassport = "1234567890";
    private static final String simbols = "!\"#%$'()*+,-./:;<=>@?[\\]^_`ǣǤǥǧǦǨǩǪǫǬǭǮǯǰǱǲǳǴǵȈȇȅȆȄȂȁȀǿǾǽǼǻǺǹǸǷǶǐǑǒǓǕǔǗǖǘǙǚǛǝǜǞǟǠǢǡțȚșȘȗȖȕȔȓȒȑȐȏȎȍȌȋȊȉʴʵʶʷʸʹʺʻʼʽʿʾˀˁ˂˃˄˅ˆˈˇˊˉˋ˝˜˛˚˞˟ˠˡˢˣˤ˥˦˨˧˩˪˫ˬ˱̝̝̝̝̞̞̂̊̋̌̍̎̎̐̑͝ѼѻѺѼѽ҉҈јѿ҂ѰѮѯ\u052A\u052C\u052DԦԣԢӹӸ";
    private static final String manySimbols = "АБВГДЕЁЖЗИКЛМНОПРСТУФЧШЩЪЫЬЭЮЯ .,1234567890-№";

    static String randomSerialNumberPassport(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(randomSerialNumberPassport.charAt(newRandom.nextInt(randomSerialNumberPassport.length())));
        return sb.toString();
    }

    public static String manyRandomSimbols(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(simbols.charAt(newRandom.nextInt(simbols.length())));
        return sb.toString();
    }

    public static String sendManyRandomSimbols(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(manySimbols.charAt(newRandom.nextInt(manySimbols.length())));
        return sb.toString();
    }

    public static String randomEnglString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(english.charAt(newRandom.nextInt(english.length())));
        return sb.toString();
    }

    public static String randomPhone(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(phone.charAt(newRandom.nextInt(phone.length())));
        return sb.toString();
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(newRandom.nextInt(AB.length())));
        return sb.toString();
    }
}

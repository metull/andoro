package SetterAndGetter;

public class SettersAndGetters {

    public static String uDID;
    public static String platfiormVerison;

    public static String getuDID() {
        return uDID;
    }

    public static void setuDID(String uDID) {
        SettersAndGetters.uDID = uDID;
    }

    public static String getPlatfiormVerison() {
        return platfiormVerison;
    }

    public static void setPlatfiormVerison(String platfiormVerison) {
        SettersAndGetters.platfiormVerison = platfiormVerison;
    }
}

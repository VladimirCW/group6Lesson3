package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private final static ResourceBundle RES = ResourceBundle.getBundle("config");
    private final static ResourceBundle RES_SECURED = ResourceBundle.getBundle("config");

    public static String loadProperty(String name) {
        return RES.getString(name);
    }

    public static String loadSecuredProp(String name) {
        return RES_SECURED.getString(name);
    }
}

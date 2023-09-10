package ru.aston.popov_am.task4.DataBaseUtil;

import java.util.ResourceBundle;

public final class ResourceBundleUtil {
   public static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    public static String getProperties1(String key){
        return System.getenv(resourceBundle.getString(key));
    }
}

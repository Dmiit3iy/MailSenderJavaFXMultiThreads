package org.dmiit3iy.util;

import javafx.scene.control.Alert;
import org.dmiit3iy.App;

import org.dmiit3iy.model.Mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isEmail(String str) {
        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}

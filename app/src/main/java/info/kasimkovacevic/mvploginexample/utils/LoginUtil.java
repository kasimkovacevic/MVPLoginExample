package info.kasimkovacevic.mvploginexample.utils;


import java.util.regex.Pattern;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
public class LoginUtil {

    public static final Pattern EMAIL_ADDRESS
            = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}

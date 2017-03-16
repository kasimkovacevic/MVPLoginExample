package info.kasimkovacevic.mvploginexample.utils;


/**
 * @author Kasim Kovacevic <kasim@atlantbh.com> on 3/16/17.
 */
public class LoginUtil {

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}

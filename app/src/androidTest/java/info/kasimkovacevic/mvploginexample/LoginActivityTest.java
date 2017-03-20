package info.kasimkovacevic.mvploginexample;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import info.kasimkovacevic.mvploginexample.activities.LoginActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Faruk Ljuca <faruk.ljuca@atlantbh.com>
 * for Atlantbh
 * on 20. March 2017.
 */

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void checkLoginSuccess() {
        onView(withId(R.id.et_email))
                .perform(typeText("kasim@atlantbh.com"));

        closeSoftKeyboard();

        onView(withId(R.id.et_password))
                .perform(typeText("password"));

        closeSoftKeyboard();

        onView(withId(R.id.btn_sign_in))
                .perform(click());

        onView(withText("This email address is invalid"))
                .check(doesNotExist());
    }
}

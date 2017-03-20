package info.kasimkovacevic.mvploginexample.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import info.kasimkovacevic.mvploginexample.utils.LoginUtil;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginUtilTest {

    @Test
    public void onValidEmail() {
        assertEquals(LoginUtil.isValidEmail("kasim@atlantbh.com"), true);
    }

    @Test
    public void onInValidEmail() {
        assertEquals(false, LoginUtil.isValidEmail("kasim"));
        assertEquals(false, LoginUtil.isValidEmail("kasim@atlantbh"));
        assertEquals(false, LoginUtil.isValidEmail("kasim.com"));
        assertEquals(false, LoginUtil.isValidEmail("@atlantbh.com"));
    }

}

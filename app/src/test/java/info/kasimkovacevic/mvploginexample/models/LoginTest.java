package info.kasimkovacevic.mvploginexample.models;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Test
    public void constructorTest() {
        String email = "kasim@atlantbh.com";
        String password = "password";
        Login login = new Login(email, password);

        assertEquals(email, login.getEmail());
        assertEquals(password, login.getPassword());
    }

}

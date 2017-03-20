package info.kasimkovacevic.mvploginexample.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class UserModelTest {

    @Test
    public void userToString() throws Exception {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("email@test.com");
        user.setAddress("Bana Jelacica 12A");
        user.setUsername("Test_User");
        user.setCity("Zagreb");
        user.setAge(18);

        String toStringContent = user.getFirstName() + " " + user.getLastName() +
                "\n" + "Age: " + user.getAge() +
                "\n" + "Address: " + user.getAddress() +
                "\n" + "City: " + user.getCity() +
                "\n" + "Email: " + user.getEmail() +
                "\n" + "Username: " + user.getUsername();

        assertEquals(toStringContent, user.toString());
    }
}

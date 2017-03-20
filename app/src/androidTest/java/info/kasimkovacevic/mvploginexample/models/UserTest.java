package info.kasimkovacevic.mvploginexample.models;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
@RunWith(AndroidJUnit4.class)
public class UserTest {
    @Test
    public void userWriteReadParcel() throws Exception {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("email@test.com");
        user.setAddress("Bana Jelacica 12A");
        user.setUsername("Test_User");
        user.setCity("Zagreb");
        user.setAge(18);
        //write to parcel
        Parcel parcel = Parcel.obtain();
        user.writeToParcel(parcel, user.describeContents());

        // user.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        //read from parcel
        User createdFromParcel = User.CREATOR.createFromParcel(parcel);

        //assert that read and write objects are same
        assertEquals(user.getAddress(), createdFromParcel.getAddress());
        assertEquals(user.getAge(), createdFromParcel.getAge());
        assertEquals(user.getCity(), createdFromParcel.getCity());
        assertEquals(user.getEmail(), createdFromParcel.getEmail());
        assertEquals(user.getFirstName(), createdFromParcel.getFirstName());
        assertEquals(user.getLastName(), createdFromParcel.getLastName());
        assertEquals(user.getUsername(), createdFromParcel.getUsername());

    }

}
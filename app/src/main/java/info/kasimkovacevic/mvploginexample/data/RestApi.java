package info.kasimkovacevic.mvploginexample.data;


import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
public interface RestApi {

    @POST("/api/v1/login")
    Call<User> login(@Body Login login);

}

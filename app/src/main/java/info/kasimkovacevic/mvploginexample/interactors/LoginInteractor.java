package info.kasimkovacevic.mvploginexample.interactors;

import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.data.RestApi;
import info.kasimkovacevic.mvploginexample.data.RestClientRouter;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
public class LoginInteractor implements LoginContract.Interactor {

    private Call<User> mCall;
    private RestApi mRestApi;

    public LoginInteractor(RestApi restApi) {
        this.mRestApi = restApi;
    }


    @Override
    public void login(Login login, final LoginContract.InteractorCallback callback) {
        mCall = mRestApi.login(login);
        mCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    callback.onLoginSuccess(response.body());
                } else {
                    callback.onLoginFailed();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                if (!mCall.isCanceled()) {
                    callback.onServerError();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        if (mCall != null)
            mCall.cancel();
    }
}

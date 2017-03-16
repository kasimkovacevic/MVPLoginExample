package info.kasimkovacevic.mvploginexample.interceptors;

import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.data.RestClientRouter;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Kasim Kovacevic <kasim@atlantbh.com> on 3/16/17.
 */
public class LoginInterceptorImpl implements LoginContract.Interceptor {

    private LoginContract.InterceptorCallback mCallback;
    private Call<User> mCall;

    public LoginInterceptorImpl(LoginContract.InterceptorCallback callback) {
        this.mCallback = callback;
    }


    @Override
    public void login(Login login) {
        mCall = RestClientRouter.get().login(login);
        mCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    mCallback.onLoginSuccess(response.body());
                } else {
                    mCallback.onLoginFailed();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                if (!mCall.isCanceled()) {
                    mCallback.onServerError();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        mCall.cancel();
    }
}

package info.kasimkovacevic.mvploginexample.contracts;

import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;

/**
 * @author Kasim Kovacevic on 3/16/17.
 */
public interface LoginContract {

    interface View {

        void onInvalidEmail();

        void onInvalidPassword();

        void onServerError();

        void onLoginFailed();

        void onLoginSuccess(User user);
    }

    interface Presenter {
        void login(Login login);

        void onDestroy();
    }

    interface Interceptor {
        void login(Login login);

        void onDestroy();
    }

    interface InterceptorCallback {
        void onLoginSuccess(User user);

        void onLoginFailed();

        void onServerError();
    }
}

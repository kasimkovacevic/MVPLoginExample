package info.kasimkovacevic.mvploginexample.contracts;

import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
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

    interface Interactor {
        void login(Login login, LoginContract.InteractorCallback callback);

        void onDestroy();
    }

    interface InteractorCallback {
        void onLoginSuccess(User user);

        void onLoginFailed();

        void onServerError();
    }
}

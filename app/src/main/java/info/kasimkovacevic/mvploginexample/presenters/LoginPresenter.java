package info.kasimkovacevic.mvploginexample.presenters;

import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import info.kasimkovacevic.mvploginexample.utils.LoginUtil;


/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
public class LoginPresenter implements LoginContract.Presenter, LoginContract.InteractorCallback {

    private LoginContract.View mLoginView;
    private LoginContract.Interactor mLoginInteractor;


    public LoginPresenter(LoginContract.View view, LoginContract.Interactor interactor) {
        this.mLoginView = view;
        this.mLoginInteractor = interactor;
    }


    @Override
    public void login(Login login) {
        if (login.getEmail() == null || !LoginUtil.isValidEmail(login.getEmail())) {
            mLoginView.onInvalidEmail();
        } else if (login.getPassword() == null || login.getPassword().length() < 4) {
            mLoginView.onInvalidPassword();
        } else {
            mLoginInteractor.login(login, this);
        }
    }

    @Override
    public void onDestroy() {
        mLoginInteractor.onDestroy();
    }

    @Override
    public void onLoginSuccess(User user) {
        //TODO if need to save in session
        mLoginView.onLoginSuccess(user);
    }

    @Override
    public void onLoginFailed() {
        mLoginView.onLoginFailed();
    }

    @Override
    public void onServerError() {
        mLoginView.onServerError();
    }
}

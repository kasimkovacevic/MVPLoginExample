package info.kasimkovacevic.mvploginexample.presenters;

import android.text.TextUtils;

import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.interceptors.LoginInterceptorImpl;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import info.kasimkovacevic.mvploginexample.utils.LoginUtil;


/**
 * @author Kasim Kovacevic <kasim@atlantbh.com> on 3/16/17.
 */
public class LoginPresenterImpl implements LoginContract.Presenter, LoginContract.InterceptorCallback {

    private LoginContract.View mLoginView;
    private LoginContract.Interceptor mLoginInterceptor;


    public LoginPresenterImpl(LoginContract.View view) {
        this.mLoginView = view;
        this.mLoginInterceptor = new LoginInterceptorImpl(this);
    }

    @Override
    public void login(Login login) {
        if (TextUtils.isEmpty(login.getEmail()) || !LoginUtil.isValidEmail(login.getEmail())) {
            mLoginView.onInvalidEmail();
        } else if (TextUtils.isEmpty(login.getPassword()) || login.getPassword().length() < 4) {
            mLoginView.onInvalidPassword();
        } else {
            mLoginInterceptor.login(login);
        }
    }

    @Override
    public void onDestroy() {
        mLoginInterceptor.onDestroy();
    }

    @Override
    public void onLoginSuccess(User user) {
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

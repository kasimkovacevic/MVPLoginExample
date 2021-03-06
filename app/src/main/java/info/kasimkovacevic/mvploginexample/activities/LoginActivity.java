package info.kasimkovacevic.mvploginexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import info.kasimkovacevic.mvploginexample.R;
import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.data.RestClientRouter;
import info.kasimkovacevic.mvploginexample.interactors.LoginInteractor;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import info.kasimkovacevic.mvploginexample.presenters.LoginPresenter;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.et_email)
    protected EditText mEmailEditText;
    @BindView(R.id.et_password)
    protected EditText mPasswordEditText;
    @BindView(R.id.btn_sign_in)
    protected Button mSignInButton;
    @BindView(R.id.til_email)
    TextInputLayout mEmailTextInputLayout;
    @BindView(R.id.til_password)
    TextInputLayout mPasswordTextInputLayout;

    private Unbinder mUnbind;
    private LoginContract.Presenter mLoginPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUnbind = ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this, new LoginInteractor(RestClientRouter.get()));
    }

    @OnClick(R.id.btn_sign_in)
    protected void login() {
        mSignInButton.setEnabled(false);
        mLoginPresenter.login(new Login(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
        mUnbind.unbind();
    }

    @Override
    public void onInvalidEmail() {
        resetPasswordErrorField();
        mSignInButton.setEnabled(true);
        mEmailTextInputLayout.setError(getResources().getString(R.string.error_invalid_email));
    }

    @Override
    public void onInvalidPassword() {
        resetEmailErrorField();
        mSignInButton.setEnabled(true);
        mPasswordTextInputLayout.setError(getResources().getString(R.string.error_invalid_password));
    }

    @Override
    public void onServerError() {
        resetErrorFields();
        mSignInButton.setEnabled(true);
        Toast.makeText(this, getResources().getString(R.string.serrver_error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFailed() {
        resetErrorFields();
        mSignInButton.setEnabled(true);
        Toast.makeText(this, getResources().getString(R.string.login_failed), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess(User user) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(MainActivity.USER_BUNDLE_KEY, user);
        startActivity(intent);
        finish();
    }

    private void resetErrorFields() {
        resetEmailErrorField();
        resetPasswordErrorField();
    }

    private void resetEmailErrorField() {
        mEmailTextInputLayout.setError(null);
    }

    private void resetPasswordErrorField() {
        mPasswordTextInputLayout.setError(null);
    }

}

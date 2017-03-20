package info.kasimkovacevic.mvploginexample.presenters;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.presenters.LoginPresenter;

import static org.mockito.Mockito.times;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginContract.View view;
    @Mock
    LoginContract.Interactor interactor;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(view, interactor);
    }

    @After
    public void clear() {
        presenter = null;
        Mockito.clearInvocations(view);
        Mockito.clearInvocations(interactor);
    }

    @Test
    public void onInValidEmail() {
        Login login = new Login("kasim", "1234");
        presenter.login(login);
        Mockito.verify(view, times(1)).onInvalidEmail();
    }

    @Test
    public void onInValidPassword() {
        Login login = new Login("kasim@atlantbh.com", "124");
        presenter.login(login);
        Mockito.verify(view, times(1)).onInvalidPassword();
    }


    @Test
    public void onValidEmailAndPassword() {
        Login login = new Login("kasim@atlantbh.com", "1234");
        presenter.login(login);
        Mockito.verify(interactor, times(1)).login(login, presenter);
    }

    @Test
    public void onLoginSuccess() {
        presenter.onLoginSuccess(null);
        Mockito.verify(view, times(1)).onLoginSuccess(null);
    }

    @Test
    public void onLoginFailed() {
        presenter.onLoginFailed();
        Mockito.verify(view, times(1)).onLoginFailed();
    }

    @Test
    public void onLoginDestroy() {
        presenter.onDestroy();
        Mockito.verify(interactor, times(1)).onDestroy();
    }

    @Test
    public void onServerError() {
        presenter.onServerError();
        Mockito.verify(view, times(1)).onServerError();
    }


}

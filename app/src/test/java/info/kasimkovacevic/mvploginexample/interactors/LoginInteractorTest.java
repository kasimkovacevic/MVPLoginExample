package info.kasimkovacevic.mvploginexample.interactors;

import android.hardware.display.VirtualDisplay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.MockitoJUnitRunner;

import info.kasimkovacevic.mvploginexample.contracts.LoginContract;
import info.kasimkovacevic.mvploginexample.data.RestApi;
import info.kasimkovacevic.mvploginexample.interactors.LoginInteractor;
import info.kasimkovacevic.mvploginexample.models.Login;
import info.kasimkovacevic.mvploginexample.models.User;
import retrofit2.Call;
import retrofit2.Callback;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;

/**
 * @author Kasim Kovacevic <kasim.kovacevic@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginInteractorTest {

    private static final Long API_TIMEOUT = 60000L;

    @Mock
    LoginContract.InteractorCallback callback;
    @Mock
    RestApi restApi;
    @Mock
    Call<User> call;
    @Mock
    Callback<User> userCallback;

    private LoginInteractor loginInteractor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginInteractor = new LoginInteractor(restApi);
    }

    @After
    public void cleanUp() {
        loginInteractor = null;
        Mockito.clearInvocations(callback);
    }

    @Test
    public void onDestroyBeforeLoginCall() throws InterruptedException {
        loginInteractor.onDestroy();
        Mockito.verify(call, times(0)).cancel();
    }

}

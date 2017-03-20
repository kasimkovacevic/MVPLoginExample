package info.kasimkovacevic.mvploginexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import info.kasimkovacevic.mvploginexample.R;
import info.kasimkovacevic.mvploginexample.models.User;

/**
 * @author Kasim Kovacevic <kasim@atlantbh.com> on 3/16/17.
 */
public class MainActivity extends AppCompatActivity {

    public static final String USER_BUNDLE_KEY = "info.kasimkovacevic.mvploginexample.activities.MainActivity.USER_BUNDLE_KEY";

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = getIntent().getExtras().getParcelable(USER_BUNDLE_KEY);

        ((TextView) findViewById(R.id.tv_first_name)).setText(mUser.toString());
    }
}

package tazake.wearui.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.view.View;

public class ConfirmationMainActivity extends Activity {

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            transition(view);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_main);

        findViewById(R.id.confirm_success).setOnClickListener(mClickListener);
        findViewById(R.id.confirm_failure).setOnClickListener(mClickListener);
        findViewById(R.id.confirm_open_phone).setOnClickListener(mClickListener);
    }

    private void transition(View view) {

        Intent intent = new Intent(ConfirmationMainActivity.this, ConfirmationActivity.class);

        switch (view.getId()) {
            case R.id.confirm_success:
                intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION);
                intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, getString(R.string.confirm_success));
                break;
            case R.id.confirm_failure:
                intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.FAILURE_ANIMATION);
                intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, getString(R.string.confirm_failure));
                break;
            case R.id.confirm_open_phone:
                intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.OPEN_ON_PHONE_ANIMATION);
                intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, getString(R.string.confirm_open_phone));
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}

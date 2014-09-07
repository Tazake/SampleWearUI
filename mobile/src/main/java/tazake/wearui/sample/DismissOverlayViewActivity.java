package tazake.wearui.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.wearable.view.DismissOverlayView;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class DismissOverlayViewActivity extends Activity {

    private GestureDetectorCompat mGestureDetector;
    private DismissOverlayView mDismissOverlayView;

    private class LongPressListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public void onLongPress(MotionEvent event) {
            mDismissOverlayView.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismiss_overlay_view);

        mGestureDetector = new GestureDetectorCompat(DismissOverlayViewActivity.this, new LongPressListener());
        mDismissOverlayView = (DismissOverlayView) findViewById(R.id.dismiss_overlay);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event) || super.dispatchTouchEvent(event);
    }

}

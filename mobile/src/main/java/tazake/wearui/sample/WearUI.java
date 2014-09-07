package tazake.wearui.sample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public enum WearUI {

    BoxInsetLayout(R.string.box_inset_layout, BoxInsetLayoutActivity.class),
    CardFragment(R.string.card_fragment, CardActivity.class),
    CustomCardFragment(R.string.custom_card_fragment, CustomCardActivity.class),
    CircledImageView(R.string.circled_image_view, CircledImageViewActivity.class),
    ConfirmationActivity(R.string.confirmation_activity, ConfirmationMainActivity.class),
    DismissOverlayView(R.string.dismiss_overlay_view, DismissOverlayViewActivity.class),
    GridViewPager(R.string.grid_view_pager, GridViewPagerActivity.class);

    private int mWidgetNameResourceId;

    private Class<?> mNextActivity;

    private WearUI(int widgetNameResourceId, Class<?> nextActivity) {
        mWidgetNameResourceId = widgetNameResourceId;
        mNextActivity = nextActivity;
    }

    private int getWidgetNameResourceId() {
        return mWidgetNameResourceId;
    }

    private Intent createIntent(Activity activity) {
        return new Intent(activity, mNextActivity);
    }

    public String getWidgetName(Context context) {
        return context.getResources().getString(getWidgetNameResourceId());
    }

    public void transition(Activity activity) {
        activity.startActivity(createIntent(activity));
    }

}

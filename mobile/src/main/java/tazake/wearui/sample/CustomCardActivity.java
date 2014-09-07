package tazake.wearui.sample;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;

public class CustomCardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_card);

        tazake.wearui.sample.CustomCardFragment cardFragment = new tazake.wearui.sample.CustomCardFragment();
        cardFragment.setExpansionEnabled(false);
        cardFragment.setExpansionDirection(CardFragment.EXPAND_UP);
        cardFragment.setExpansionFactor(2.0f);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.card_layout_contents, cardFragment);
        ft.commit();
    }

}

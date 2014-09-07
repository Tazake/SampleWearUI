package tazake.wearui.sample;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.view.Gravity;

public class CardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        CardFragment cardFragment = CardFragment.create("Title", "Description \n\n\n\n" +
                "\n\n" +
                "\n\n" +
                "\n\n" +
                "\n\n" +
                "\n\n" +
                "\n\n" +
                "\n\n" +
                "Description", android.R.drawable.ic_delete);
        cardFragment.setCardGravity(Gravity.TOP);
        cardFragment.setExpansionEnabled(true);
        cardFragment.setExpansionDirection(CardFragment.EXPAND_DOWN);
        cardFragment.setExpansionFactor(2.0f);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.card_layout_contents, cardFragment);
        ft.commit();

    }

}

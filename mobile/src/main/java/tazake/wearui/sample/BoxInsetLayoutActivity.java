package tazake.wearui.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.BoxInsetLayout;
import android.widget.Toast;

public class BoxInsetLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_inset_layout);

        BoxInsetLayout boxInsetLayout = (BoxInsetLayout) findViewById(R.id.box_inset_layout);
        // エミュレータだと判定が正常に動作しない
        String str = boxInsetLayout.isRound() ? "round" : "shape";
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

}

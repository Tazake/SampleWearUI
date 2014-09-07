package tazake.wearui.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.view.WindowInsets;

import java.util.ArrayList;
import java.util.List;

public class GridViewPagerActivity extends Activity {

    private GridViewPager mGridViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_pager);

        mGridViewPager = (GridViewPager) findViewById(R.id.grid_view_pager);
        tazake.wearui.sample.SampleGridPagerAdapter adapter = new tazake.wearui.sample.SampleGridPagerAdapter(this, generateData());
        mGridViewPager.setAdapter(adapter);
        mGridViewPager.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (windowInsets.isRound()) {
                    //TODO: padding set for round layout
                    int rowMargin = getResources().getDimensionPixelOffset(R.dimen.page_row_margin);
                    int colMargin = getResources().getDimensionPixelOffset(
                            R.dimen.page_column_margin);
                    mGridViewPager.setPageMargins(rowMargin, colMargin);
                }

                return windowInsets;
            }
        });
    }

    private List<PagerItem> generateData() {

        List<PagerItem> pagerItems = new ArrayList<PagerItem>();

        tazake.wearui.sample.PagerItem item1 = new PagerItem("Page1\n\n" +
                "hoge\n" +
                "fuga\n" +
                "piyo\n" +
                "hogehoge\n" +
                "fugafuga\n" +
                "piyopiyo\n" +
                "hogehogehoge\n" +
                "fugafugafuga\n" +
                "piyopiyopiyo"
                , "Page1\n\nDescription1", android.R.drawable.ic_dialog_email, R.drawable.light_blue);
        pagerItems.add(item1);
        PagerItem item2 = new PagerItem("Page2", "Page2\n\nDescription2", android.R.drawable.ic_dialog_alert, R.drawable.light_sea_green);
        pagerItems.add(item2);
        PagerItem item3 = new PagerItem("Page3", "Page3\n\nDescription3", android.R.drawable.ic_media_next, R.drawable.light_pink);
        pagerItems.add(item3);

        return pagerItems;

    }

}

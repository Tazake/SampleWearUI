package tazake.wearui.sample;

import android.content.Context;
import android.support.wearable.view.CardFrame;
import android.support.wearable.view.CardScrollView;
import android.support.wearable.view.GridPagerAdapter;
import android.support.wearable.view.ImageReference;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SampleGridPagerAdapter extends GridPagerAdapter {
    private static final int GRID_COLUMN_COUNT = 3;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<PagerItem> mItemList;

    public SampleGridPagerAdapter(
            Context context, List<PagerItem> itemList) {
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mItemList = itemList;
    }

    @Override
    public int getRowCount() {
        if (mItemList != null && mItemList.size() > 0) {
            return mItemList.size();
        }
        return 1;
    }

    @Override
    public int getColumnCount(int i) {
        return GRID_COLUMN_COUNT;
    }

    @Override
    protected Object instantiateItem(ViewGroup container, int row, final int column) {
        if (mItemList.size() > 0) {
            final PagerItem item = mItemList.get(row);
            if (column == 0 || column == 1) {
                CardScrollView cardScrollView = (CardScrollView) mLayoutInflater.inflate(
                        R.layout.gridpager_card, container, false);
                TextView text = (TextView) cardScrollView.findViewById(R.id.grid_card_text);
                if (column == 0) {
                    text.setText(item.getName());
                } else {
                    text.setText(item.getDescription());
                }
                cardScrollView.setCardGravity(Gravity.BOTTOM);
                cardScrollView.setExpansionEnabled(true);
                cardScrollView.setExpansionDirection(CardFrame.EXPAND_DOWN);
                cardScrollView.setExpansionFactor(10);
                container.addView(cardScrollView);
                return cardScrollView;
            } else if (column == 2) {
                FrameLayout frameLayout = (FrameLayout) mLayoutInflater.inflate(
                        R.layout.gridpager_image, container, false);
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.grid_card_image);
                imageView.setBackgroundResource(item.getImageResourceId());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER;
                imageView.setLayoutParams(layoutParams);
                container.addView(frameLayout);
                return frameLayout;
            }
        }

        return new View(mContext);
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        if (column == 0) {
            return null;
        }
        if (mItemList.size() > 0) {
            return ImageReference.forDrawable(mItemList.get(row).getBackgroundResourceId());
        }
        return super.getBackground(row, column);
    }

    @Override
    protected void destroyItem(ViewGroup viewGroup, int row, int column, Object object) {
        viewGroup.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}

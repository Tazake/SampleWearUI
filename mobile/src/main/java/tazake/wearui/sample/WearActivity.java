package tazake.wearui.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class WearActivity extends Activity {

    private WearableListView mListView;
    private List<WearUI> mWidgetList = Arrays.asList(WearUI.values());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                initView(stub);
            }
        });
    }

    private void initView(WatchViewStub stub) {
        mListView = (WearableListView) stub.findViewById(R.id.list_view);

        mListView.setAdapter(new StringAdapter(this, mWidgetList));
        mListView.setHasFixedSize(true);
        mListView.setClickListener(new WearableListView.ClickListener() {
            @Override
            public void onClick(WearableListView.ViewHolder viewHolder) {
                mWidgetList.get(viewHolder.getPosition()).transition(WearActivity.this);
            }

            @Override
            public void onTopEmptyRegionClick() {
                Toast.makeText(WearActivity.this, "onTopEmptyRegionClick", Toast.LENGTH_LONG).show();
            }
        });
    }

    private class StringAdapter extends WearableListView.Adapter {

        private LayoutInflater mLayoutInflater;
        private List<WearUI> mWidgetList;

        public StringAdapter(Context context, List<WearUI> widgetList) {
            super();
            mLayoutInflater = LayoutInflater.from(context);
            mWidgetList = widgetList;
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = mLayoutInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            MyViewHolder viewHolder = new MyViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            String data = mWidgetList.get(position).getWidgetName(getApplicationContext());
            myViewHolder.text.setText(data);
        }

        @Override
        public int getItemCount() {
            return mWidgetList.size();
        }
    }

    static class MyViewHolder extends WearableListView.ViewHolder {
        public TextView text;

        public MyViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(android.R.id.text1);
        }
    }

}

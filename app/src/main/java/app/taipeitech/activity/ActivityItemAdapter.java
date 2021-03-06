package app.taipeitech.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import app.taipeitech.R;
import app.taipeitech.model.ActivityInfo;
import app.taipeitech.model.ActivityList;

public class ActivityItemAdapter extends ArrayAdapter<ActivityInfo> {

    public ActivityItemAdapter(Context context, ActivityList datas) {
        super(context, R.layout.activity_item, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = new ActivityItemView(getContext());
        }
        ((ActivityItemView) convertView).setActivityInfo(getItem(position));
        return convertView;
    }
}

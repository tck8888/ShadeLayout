package com.wejiji.shadelayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by tck on 2017/4/17.
 */

public class TestAdapter extends BaseAdapter {
    private List<UserBean> mUserBeanList;
    private Context mContext;

    public TestAdapter(Context context,List<UserBean> userBeanList) {
        mUserBeanList = userBeanList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mUserBeanList == null ? 0 : mUserBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        TestHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_test, parent, false);
            holder = new TestHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (TestHolder) convertView.getTag();
        }

        UserBean userBean = mUserBeanList.get(position);
        holder.mImageIv.setImageResource(userBean.getIconId());
        holder.mUsernameTv.setText(userBean.getUsername());
        holder.mDescriptionTv.setText(userBean.getDescription());

        holder.rootview.setOnBackInfo(new ShadeLayout.onBackInfo() {
            @Override
            public void doSomething() {
                Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class TestHolder {
        private ImageView mImageIv;
        private TextView mUsernameTv;
        private TextView mDescriptionTv;
        private ShadeLayout rootview;

        public TestHolder(View convertView) {
            mImageIv = (ImageView) convertView.findViewById(R.id.image_iv);
            mUsernameTv = (TextView) convertView.findViewById(R.id.username_tv);
            mDescriptionTv = (TextView) convertView.findViewById(R.id.description_tv);
            rootview = (ShadeLayout) convertView.findViewById(R.id.rootview);
        }
    }


}

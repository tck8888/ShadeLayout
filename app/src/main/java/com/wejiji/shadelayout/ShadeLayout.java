package com.wejiji.shadelayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by tck on 2017/4/17.
 */

public class ShadeLayout extends FrameLayout {

    private Context mContext;
    private FrameLayout mShade;


    public ShadeLayout(@NonNull Context context) {
        this(context, null);
    }

    public ShadeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.shade_view, null);
        mShade = (FrameLayout) view.findViewById(R.id.shade);
        TextView cancel_action = (TextView) view.findViewById(R.id.cancel_action);
        addView(view);

        cancel_action.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBackInfo!=null){
                    mOnBackInfo.doSomething();
                }
            }
        });

    }

    public void setViewVisible(boolean visible) {
        if (visible) {
            mShade.setVisibility(View.VISIBLE);
        } else {
            mShade.setVisibility(View.GONE);
        }
    }

    public interface onBackInfo{
        void doSomething();
    }

    private onBackInfo mOnBackInfo;

    public void setOnBackInfo(onBackInfo onBackInfo) {
        mOnBackInfo = onBackInfo;
    }
}

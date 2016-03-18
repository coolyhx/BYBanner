package com.brantyu.bybannerlib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.imbryk.viewPager.LoopViewPager;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by brantyu on 16/3/18.
 */
public class BYBanner extends RelativeLayout{
    private LoopViewPager mViewPager;
    private CirclePageIndicator mCirclePageIndicator;

    private boolean mIsSetAdapter = false;

    public BYBanner(Context context) {
        this(context,null);
    }

    public BYBanner(Context context, AttributeSet attrs) {
        this(context, attrs,R.attr.vpiCirclePageIndicatorStyle);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BYBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context,attrs);
    }

    private void initViews(Context context,AttributeSet attrs){
        Log.e("initViews","init");
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.banner,null);
        mViewPager = (LoopViewPager) rootView.findViewById(R.id.bybanner_vp);
        mCirclePageIndicator = (CirclePageIndicator) rootView.findViewById(R.id.by_indicator);
        addView(rootView);
    }

    public void setAutoScroll(boolean flag){
        if(mIsSetAdapter && mViewPager!=null){
            mViewPager.setAutoScroll(flag);
        }
    }

    public void setAdapter(PagerAdapter adapter){
        setAdapter(adapter,0);
    }

    public void setAdapter(PagerAdapter adapter,int initialPosition){
        if(mViewPager!=null){
            mViewPager.setAdapter(adapter);

            if(mCirclePageIndicator!=null){
                mCirclePageIndicator.setViewPager(mViewPager,initialPosition);
            }
        }

        mIsSetAdapter = true;
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        Log.e("onConfigurationChanged",newConfig.orientation+" "+this.getResources().getConfiguration().orientation);
        removeAllViews();
        super.onConfigurationChanged(newConfig);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
        } else {
            //横屏
        }
    }
}

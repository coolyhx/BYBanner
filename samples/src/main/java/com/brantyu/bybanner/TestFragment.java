package com.brantyu.bybanner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by brantyu on 16/3/18.
 */
public class TestFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";
    private static final String KEY_ID = "TestFragment:id";

    public static TestFragment newInstance(int id) {
        TestFragment fragment = new TestFragment();
        fragment.mIndex = id;
        return fragment;
    }

    private String mContent = "???";
    private int mIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
            mIndex = savedInstanceState.getInt(KEY_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView iv = new ImageView(getContext());
        iv.setBackgroundColor(getBackgroundColorById(mIndex));
        Glide.with(getContext()).load(getResIdById(mIndex)).into(iv);
        return iv;
    }

    private int getBackgroundColorById(int id){
        int resId;
        switch (id){
            case 0:
                resId = Color.GREEN;
                break;
            case 1:
                resId = Color.GRAY;
                break;
            case 2:
                resId = Color.YELLOW;
                break;
            case 3:
                resId = Color.BLUE;
                break;
            default:
                resId = Color.GREEN;
                break;
        }
        return resId;
    }

    private int getResIdById(int id){
        int resId;
        switch (id){
            case 0:
                resId = R.mipmap.p1;
                break;
            case 1:
                resId = R.mipmap.p2;
                break;
            case 2:
                resId = R.mipmap.p3;
                break;
            case 3:
                resId = R.mipmap.p4;
                break;
            default:
                resId = R.mipmap.p1;
                break;
        }
        return resId;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
        outState.putInt(KEY_ID,mIndex);
    }
}

package com.example.eissa.silders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by EISSA on 02/12/2017.
 */

public class MyPagerAdapter extends PagerAdapter {
    int[] layouts;
    LayoutInflater layoutInflater;
    Context mCTX;

    public MyPagerAdapter(int[] layouts,Context context){
        this.mCTX=context;
        this.layouts=layouts;
        this.layoutInflater=(LayoutInflater)mCTX.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {

        View view=layoutInflater.inflate(layouts[position],container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        View view=(View)object;
        container.removeView(view);
    }
}

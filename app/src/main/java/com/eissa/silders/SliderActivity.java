package com.example.eissa.silders;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class SliderActivity extends AppCompatActivity {

    ViewPager mPager;
    ImageView[] dots;
    LinearLayout dotsLayout;
    private int[] layoutsilder={R.layout.first_silder_layout,R.layout.second_slider_layout,
                                R.layout.three_slider_layout,R.layout.four_slider_layout};

    MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        mPager=(ViewPager)findViewById(R.id.viewpager);
        pagerAdapter = new MyPagerAdapter(layoutsilder,this);
        mPager.setAdapter(pagerAdapter);
        dotsLayout=(LinearLayout)findViewById(R.id.dotsLayout);
        CreatDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              CreatDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void  CreatDots(int currentPosition){

        if(dotsLayout != null){
            dotsLayout.removeAllViews();
            dots= new ImageView[layoutsilder.length];

            for (int i=0; i<layoutsilder.length;i++){

                dots[i]= new ImageView(this);
                if(i==currentPosition){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
                }else{
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
                }
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4,0,4,0);
                dotsLayout.addView(dots[i],params);
            }

        }
    }


}

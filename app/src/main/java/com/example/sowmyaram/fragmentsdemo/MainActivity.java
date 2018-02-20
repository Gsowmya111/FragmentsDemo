package com.example.sowmyaram.fragmentsdemo;

/**
 * Created by sowmyaram on 6/19/2017.
 */
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sowmyaram.fragmentsdemo.CustomPagerAdapter;
import com.example.sowmyaram.fragmentsdemo.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {


    /* int[] mResources = {R.drawable.backyard, R.drawable.balcony, R.drawable.bed_room, R.drawable.cafeteria,
             R.drawable.backyard01, R.drawable.balcony,R.drawable.ac,R.drawable.dimmer
     };*/
    int layoutes[]={R.layout.one,R.layout.two};


    ViewPager mViewPager;
    private CustomPagerAdapter mAdapter;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    String roomnamesdb[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        //  mAdapter = new CustomPagerAdapter(this, mResources);
        mAdapter = new CustomPagerAdapter(this,layoutes);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(this);

        setPageViewIndicator();








    }





    private void setPageViewIndicator() {



        Log.d("###setPageViewIndicator", " : called");



        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dots[presentPosition].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    mViewPager.setCurrentItem(presentPosition);
                    return true;
                }

            });


            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditemdot));
    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

      //  Intent i11 =new Intent(MainActivity.this,One.class);
      //  startActivity(i11);


        Log.d("###onPageSelected, pos ", String.valueOf(position));
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditemdot));

        if (position + 1 == dotsCount) {

        } else {

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }
}
package com.example.foodmate.firstmeet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.foodmate.MainActivity;
import com.example.foodmate.R;
import com.example.foodmate.sign.signin;

import java.util.ArrayList;
import java.util.List;

public class activity_guide extends AppCompatActivity {
    private Button button;
    private ViewPager mVpGuide;
    private List<ImageView> mImageList;
    private static int[] mImageIds = new int[]{
            R.drawable.foodpacture1, R.drawable.foodpacture2, R.drawable.foodpacture3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        mVpGuide.setAdapter(new GuideAdapter());
        mVpGuide.setOnPageChangeListener(new GuidePageChangeListener());
        button=(Button)findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(activity_guide.this, signin.class));
                finish();
            }
        });



    }

    private void initView() {
        mVpGuide = (ViewPager) findViewById(R.id.vp_guide);
        mImageList = new ArrayList<ImageView>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageIds[i]);
            mImageList.add(imageView);
        }
    }

    class GuideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mImageList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageList.get(position));
            //每次滑动的时候把视图添加到viewpager
            return mImageList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            // 将当前位置的View移除
            container.removeView(mImageList.get(position));
        }


    }
    class GuidePageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i==mImageIds.length-1){
                button.setVisibility(View.VISIBLE);
            }
            else {
                button.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}

package com.example.foodmate.fragments.Pacfragment1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodmate.R;
import com.example.foodmate.recyclepart.RecycleAdapter;
import com.example.foodmate.recyclepart.recycleformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class fragment1 extends Fragment {
    private List<recycleformation> recycleList=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewit =inflater.inflate(R.layout.fragment_fragment1, container, false);
        initrefruits();
        RecyclerView recyclerView=viewit.findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager layoutManager=new
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecycleAdapter adapter=new RecycleAdapter(recycleList);
        recyclerView.setAdapter(adapter);
        return viewit;
    }
    private void initrefruits() {
        for(int i=0;i<12;i++)
        {
            recycleformation qq=new recycleformation(R.drawable.greatfood1, getRandomLengthName("红烧鸡排"));
            recycleList.add(qq);
            recycleformation cc=new recycleformation(R.drawable.greatfood2, getRandomLengthName("鱼香肉丝"));
            recycleList.add(cc);
            recycleformation pp=new recycleformation(R.drawable.greatfood3, getRandomLengthName("糖醋排骨"));
            recycleList.add(pp);
            recycleformation ppp=new recycleformation(R.drawable.greatfood4, getRandomLengthName("四喜丸子"));
            recycleList.add(ppp);
        }
    }

    private String getRandomLengthName(String name) {
        Random random=new Random();
        int length=random.nextInt(10)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }

}
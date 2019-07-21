package com.example.foodmate.fragments.Pacfragment1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodmate.R;
import com.example.foodmate.fragments.Pacfragment1.recyclepart.RecycleAdapter;
import com.example.foodmate.fragments.Pacfragment1.recyclepart.recycleformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class fragment1 extends Fragment {
    private List<recycleformation> recycleList=new ArrayList<>();
    private RecycleAdapter adapter;
    private recycleformation[] fruit_lists={
            new recycleformation(R.drawable.greatfood1,"红烧鸡排"),
            new recycleformation(R.drawable.greatfood2,"鱼香肉丝"),
            new recycleformation(R.drawable.greatfood3,"糖醋排骨"),
            new recycleformation(R.drawable.greatfood4,"四喜丸子"),
    };
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
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecycleAdapter(recycleList);
        recyclerView.setAdapter(adapter);
        return viewit;
    }
    private void initrefruits() {
        recycleList.clear();
        for (int i=0;i<20;i++){
            Random random=new Random();
            int index=random.nextInt(fruit_lists.length);
            recycleList.add(fruit_lists[index]);
        }
    }



}
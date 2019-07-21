package com.example.foodmate.fragments.Pacfragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodmate.R;
import com.example.foodmate.fragments.Pacfragment2.Fruitinformation.FruitAdapterfrag_2;
import com.example.foodmate.fragments.Pacfragment2.Fruitinformation.Fruit_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class fragment2 extends Fragment {
    private Fruit_2[] fruit_2s={
            new Fruit_2("舌尖上的中国",R.drawable.chinafood1),
            new Fruit_2("日出之食",R.drawable.chinafood2),
            new Fruit_2("上海的味道",R.drawable.chinafood3),
            new Fruit_2("青春应佰味",R.drawable.chinafood4)



    };
    private List<Fruit_2> fruit_2List=new ArrayList<>();
    private FruitAdapterfrag_2 adapterfrag_2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initFruitfrag_2();
        View view=inflater.inflate(R.layout.fragment_fragment2, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclfrag_2);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapterfrag_2=new FruitAdapterfrag_2(fruit_2List);
        recyclerView.setAdapter(adapterfrag_2);
        return view;


    }
    private void initFruitfrag_2()
    {
        fruit_2List.clear();
        for(int i=0;i<20;i++){
            Random random=new Random();
            int index=random.nextInt(fruit_2s.length);
            fruit_2List.add(fruit_2s[index]);
        }
    }

}

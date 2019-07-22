package com.example.foodmate.fragments.Pacfragment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodmate.MainActivity;
import com.example.foodmate.R;

import java.util.ArrayList;


public class fragment3 extends Fragment {
    private FloatingActionButton button ;
    private Button button3;
    private LinearLayout my_layout;
    private Button button4;
    private  int i=-1;
    private  int qqq=0;
    private ArrayList<TextView> editTexts=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment3, container, false);
        button=view.findViewById(R.id.ddd);
        button3=view.findViewById(R.id.getnew);
        button4=view.findViewById(R.id.delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent=new Intent(getContext(), idea.class);
               getActivity().startActivityForResult(intent,1);
               qqq=1;

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qqq==1){
                    addView();
                    qqq=0;
                }

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteView();
            }
        });



        return view;

    }
    public void deleteView() {//删除edittext
        TextView editText = editTexts.get(i);
        my_layout.removeView(editText);
        editTexts.remove(i);
        i--;
    }
    public void  addView(){


        my_layout=getActivity().findViewById(R.id.My_layout);
        TextView editText=new TextView(getActivity());
        MainActivity mainActivity=(MainActivity)getActivity();
        String s=mainActivity.getReturndata();
        Log.d("qwert","shu"+s);
        if(s!=null) {
            i++;
            editText.setBackgroundResource(R.drawable.shape_edit2);
            editText.setWidth(220);
            editText.setHeight(150);
            editText.setTextSize(23);
            editText.setText(s);
            editText.setGravity(20);
            editText.setPadding(50,0,0,0);
            //editText.setSingleLine(true);
            editText.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            editText.setMovementMethod(LinkMovementMethod.getInstance());
            editTexts.add(i,editText);
            my_layout.addView(editText);

        }

    }

}

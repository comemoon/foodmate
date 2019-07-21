package com.example.foodmate.fragments.Pacfragment1.foodAPI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.foodmate.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class food_how extends AppCompatActivity {
    private TextView title;
   // private TextView ingredients;
    private TextView burden;
    private TextView steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_how);
        title=findViewById(R.id.title);
        //ingredients=findViewById(R.id.ingredients);
        burden=findViewById(R.id.burden);
        steps=findViewById(R.id.steps);
        initData();
    }
    private void initData(){
        String url= CONFIG.API.URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        processData(response);
                    }

                    private void processData(String response) {
                        JsonBean.ResultBean.DataBean dataBean=JSON.parseObject(response, JsonBean.ResultBean.DataBean.class);

                        //title.setText(dataBean.getTitle());
                        //ingredients.setText(dataBean.getIngredients());
                        //burden.setText(dataBean.getBurden());
                        //steps.setText(dataBean.getSteps().toString());

                    }
                });





    }

}

package com.example.foodmate.fragments.Pacfragment1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.foodmate.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class food_how extends AppCompatActivity {
    private TextView textView22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_how);
        textView22=findViewById(R.id.food_how);
        initData();
    }
    private void initData(){
        OkHttpClient client=new OkHttpClient();
        String url=CONFIG.API.URL;
        final Request request=new Request.Builder()
                .get()
                .url(url)
                .build();
        final Call call=client.newCall(request);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response=call.execute();
                    Message message=new Message();
                    Log.v("asd",response.toString());
                    String s=response.body().string();
                    message.obj=s;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.v("asd","asd");
                }
            }
        }).start();

    }
    Handler handler=new Handler(){
        @Override
        public  void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Log.d("asd","as"+msg.toString());
                    textView22.setText(msg.obj.toString());
                    Gson gson=new Gson();
                    JsonBean jsonBean=gson.fromJson(msg.obj.toString(),JsonBean.class);
                    //textView22.setText(jsonBean.getResult().getTotalNum());

                    break;
                    default:
                        break;
            }
        }
    };
}

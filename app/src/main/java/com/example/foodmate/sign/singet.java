package com.example.foodmate.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmate.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class singet extends AppCompatActivity {
    private  Button button;
    private EditText editaccount;
    private EditText editcode;
    private EditText editcodeagain;
    private String p1,p2,p3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "de3c3dc01f116c2332a5d98695bba463");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_singet);
        editaccount=findViewById(R.id.textaccount);
        editcode=findViewById(R.id.textcode);
        editcodeagain=findViewById(R.id.textcodeagain);
        button=findViewById(R.id.singet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1=editaccount.getText().toString();
                p2=editcode.getText().toString();
                p3=editcodeagain.getText().toString();
                if(p2.equals(p3)) {
                    User myUser=new User();
                    myUser.setUsername(editaccount.getText().toString());
                    myUser.setPassword(editcodeagain.getText().toString());
                    myUser.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if(e==null){
                                Toast.makeText(singet.this, "注册成功", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(singet.this,signin.class));
                                finish();
                            }else{
                                //loge(e);
                                Toast.makeText(singet.this, "注册失败"+e, Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
                else{
                    Toast.makeText(singet.this, "两次密码不一致", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}

package com.example.foodmate.sign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmate.MainActivity;
import com.example.foodmate.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class signin extends AppCompatActivity {
    private Button getAccount;
    private Button signinyes;
    private EditText qq1,qq2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "de3c3dc01f116c2332a5d98695bba463");
        setContentView(R.layout.activity_signin);
        getAccount=findViewById(R.id.getaccount);
        signinyes=findViewById(R.id.singinyes);
        qq1=findViewById(R.id.textView);
        qq2=findViewById(R.id.textView2);
        getAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(signin.this,singet.class));
            }
        });
        signinyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qq1.getText().toString().isEmpty() || qq2.getText().toString().isEmpty()) {
                    Toast.makeText(signin.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                User bu2 = new User();
                bu2.setUsername(qq1.getText().toString());
                bu2.setPassword(qq2.getText().toString());
                bu2.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Intent intent_main = new Intent(signin.this, MainActivity.class);
                            startActivity(intent_main);
                            Toast.makeText(signin.this,"登陆成功",Toast.LENGTH_SHORT).show();
                            finish();
                            //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                            //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                        } else {
                            Toast.makeText(signin.this, "登录失败", Toast.LENGTH_SHORT).show();

                            //loge(e);

                        }
                    }
                });
            }

        });
    }
}

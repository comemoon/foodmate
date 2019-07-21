package com.example.foodmate.sign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodmate.MainActivity;
import com.example.foodmate.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class signin extends AppCompatActivity {
    private int qw;

    private TextView mResistText;

    private EditText mAccountEdit, mPasswordEdit;

    private Button mLogInButton;

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "de3c3dc01f116c2332a5d98695bba463");
        setContentView(R.layout.activity_signin);

//        if (BmobUser.isLogin()&&qw!=1){
//            startActivity(new Intent(signin.this, MainActivity.class));
//            finish();
//            qw=0;
//        }



        iniViews();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass= findViewById(R.id.remember_pass);
        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember){
            String account = preferences.getString("account", "");
            String password= preferences.getString("password", "");
            mAccountEdit.setText(account);
            mPasswordEdit.setText(password);
            rememberPass.setChecked(true);
        }


    }

    private void iniViews(){
        mResistText = findViewById(R.id.getaccount);
        mAccountEdit = findViewById(R.id.textView);
        mPasswordEdit = findViewById(R.id.textView2);
        mLogInButton= findViewById(R.id.singinyes);

        mResistText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signin.this, singet.class));
                qw=1;
            }
        });

        mLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /**
     * 账号密码登录
     */
    private void login() {
        final User user = new User();
        //此处替换为你的用户名
        user.setUsername(mAccountEdit.getText().toString());
        //此处替换为你的密码
        user.setPassword(mPasswordEdit.getText().toString());
        user.login(new SaveListener<User>() {
            @Override
            public void done(User bmobUser, BmobException e) {
                if (e == null) {
                    saveAccount();
                    User user = BmobUser.getCurrentUser(User.class);
                    Toast.makeText(signin.this, "登录成功：" + user.getUsername(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(signin.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(signin.this, "登录失败，请检查网络", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * 保存密码
     */
    private void saveAccount(){
        String account  = mAccountEdit.getText().toString();
        String password = mPasswordEdit.getText().toString();
        editor = preferences.edit();
        if (rememberPass.isChecked()){
            editor.putString("account", account);
            editor.putString("password", password);
            editor.putBoolean("remember_password", true);
        }else {
            editor.clear();
        }
        editor.apply();
    }
}

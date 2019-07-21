package com.example.foodmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodmate.fragments.Pacfragment1.fragment1;
import com.example.foodmate.fragments.Pacfragment2.fragment2;
import com.example.foodmate.fragments.Pacfragment3.fragment3;
import com.example.foodmate.sign.signin;

import cn.bmob.v3.BmobUser;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Button button;
    String returndata;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNaviga=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.headview:
                            replaceFragment(new fragment1());
                            return true;
                        case R.id.imagines:
                            replaceFragment(new fragment2());
                            return true;
                        case R.id.flag:
                            replaceFragment(new fragment3());
                            return true;
                    }
                    return  false;
                }
            };
    private  NavigationView.OnNavigationItemSelectedListener mcircle=
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case  R.id.set:
                            logOut();
                            break;
                            default:

                    }
                    return true;

                }
            };

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram,fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView=findViewById(R.id.nav_view);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout=findViewById(R.id.drawer_layout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.food2);
        }
        navigationView.setCheckedItem(R.id.likefood);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                return true;
            }

        });
        NavigationView navigationView2=findViewById(R.id.nav_view);
        BottomNavigationView navigationView1=findViewById(R.id.button_view);
        replaceFragment(new fragment1());
        navigationView1.setOnNavigationItemSelectedListener(mOnNaviga);
        navigationView2.setNavigationItemSelectedListener(mcircle);



    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                     returndata=data.getStringExtra("yew");
                    Log.d("qwe","shuju"+returndata);

                }
                break;
            default:
        }
    }

    @Override
    public Intent getIntent() {
        replaceFragment(new fragment3());
        return super.getIntent();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;



                default:
        }
        return  true;
    }

    private void logOut() {
        BmobUser.logOut();
        startActivity(new Intent(MainActivity.this, signin.class));
        Toast.makeText(MainActivity.this,"退出成功",Toast.LENGTH_SHORT).show();
    }

    public String getReturndata() {
        return returndata;
    }
}

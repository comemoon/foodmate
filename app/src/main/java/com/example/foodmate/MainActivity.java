package com.example.foodmate;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.example.foodmate.fragments.Pacfragment1.fragment1;
import com.example.foodmate.fragments.fragment2;
import com.example.foodmate.fragments.fragment3;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Button button;
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

        BottomNavigationView navigationView1=findViewById(R.id.button_view);
        replaceFragment(new fragment1());
        navigationView1.setOnNavigationItemSelectedListener(mOnNaviga);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sing_out:

                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

                default:
        }
        return  true;
    }
}

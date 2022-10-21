package com.bt2.ktrgiuaky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavActivity extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagavition);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        nav = findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new IntroFragment()).commit();
        nav.setSelectedItemId(R.id.homenav);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {

                    case R.id.homenav:
                        fragment = new IntroFragment();
                        break;

                    case R.id.usernav:
                        fragment = new ProfileFragment();
                        break;

                    case R.id.shopnav:
                        fragment = new SkinFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });
    }
}
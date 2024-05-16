package com.sahmyook.ugs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.NavigableMap;

public class MainActivity extends AppCompatActivity {

    FriendsActivity friendsActivity;
    StudyTableActivity studyTableActivity;
    StudyMettingActivity studyMettingActivity;
    SettingActivity settingActivity;
    HomeActivity homeActivity;
    private FirebaseAuth mFireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendsActivity = new FriendsActivity();
        studyTableActivity = new StudyTableActivity();
        studyMettingActivity = new StudyMettingActivity();
        settingActivity = new SettingActivity();
        homeActivity = new HomeActivity();


        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFireBaseAuth.signOut(); //로그아웃 구현
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_container , homeActivity );

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigation_view);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_study_table:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_container,studyTableActivity).commit();
                        return true;
                    case R.id.navigation_study_meeting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_container,studyMettingActivity).commit();
                        return true;
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_container,homeActivity).commit();
                        return true;
                    case R.id.navigation_friends_list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_container,friendsActivity).commit();
                        return true;
                    case R.id.navigation_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_container,settingActivity).commit();
                        return true;
                }
                return false;
            }
        });

        // 계정 탈퇴 할때는
        // mFireBaseAuth.getCurrentUser().delete();
    }
}

















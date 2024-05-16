package com.sahmyook.ugs;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class AgreementActivity extends AppCompatActivity {
    private Button mBtnNext, mBtnTest;
    private CheckBox CheckAgree1, CheckAgree2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        mBtnNext = findViewById(R.id.btn_next);
        //mBtnTest = findViewById(R.id.btn_test);
        CheckAgree1 = findViewById(R.id.CheckBox_Agree1);
        CheckAgree2 = findViewById(R.id.CheckBox_Agree2);

        // 다음 버튼 비활성화
        mBtnNext.setEnabled(false);

        // 체크박스 리스너 
        CheckAgree1.setOnCheckedChangeListener(checkListener);
        CheckAgree2.setOnCheckedChangeListener(checkListener);

        // next버튼 클릭 시 회원가입 화면으로 이동
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgreementActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        
        /* 테스트용 버튼
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgreementActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        */
    }

    // 두개가 동시에 체크되야 next 버튼 활성화
    private final CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // Enable the button only if both checkboxes are checked
            mBtnNext.setEnabled(CheckAgree1.isChecked() && CheckAgree2.isChecked());
        }
    };
}

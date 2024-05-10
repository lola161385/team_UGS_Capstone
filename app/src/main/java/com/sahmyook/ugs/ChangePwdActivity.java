package com.sahmyook.ugs;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ChangePwdActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    EditText mEtEmail;
    Button mBtnSend, mBtnBack;
    String strEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepwd);

        //init
        mFirebaseAuth = FirebaseAuth.getInstance();
        mEtEmail = findViewById(R.id.et_email);
        mBtnSend = findViewById(R.id.btn_send);
        mBtnBack = findViewById(R.id.btn_back);
        //초기화 버튼 동작
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = mEtEmail.getText().toString().trim();
                if (!TextUtils.isEmpty(strEmail)) {
                    ResetPassword();

                } else {
                    mEtEmail.setError("이메일을 적어주세요!");
                }
            }
        });
        //뒤로가기 버튼
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePwdActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void ResetPassword() {
        mBtnSend.setVisibility(View.INVISIBLE);

        mFirebaseAuth.sendPasswordResetEmail(strEmail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ChangePwdActivity.this, "비밀번호 변경 링크가 이메일로 전송 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChangePwdActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ChangePwdActivity.this, "Error: - "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        mBtnSend.setVisibility(View.VISIBLE);
                    }
                });
    }
}

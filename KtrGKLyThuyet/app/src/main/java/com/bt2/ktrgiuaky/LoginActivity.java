package com.bt2.ktrgiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText textView1 = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText textView2 =  (EditText)  findViewById(R.id.editTextPas);
        ImageView signIn = (ImageView) findViewById(R.id.imageView);
        TextView textView3 = (TextView) findViewById(R.id.textView2);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "dung";
                String pass = "dung";

                if (textView1.getText().toString().equals("") || textView2.getText().toString().equals("")){
                    Toast.makeText( LoginActivity.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((textView1.getText().toString().equals(user)) && (textView2.getText().toString().equals(pass))){
                        Toast.makeText( LoginActivity.this,"Thành Công" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, NavActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText( LoginActivity.this,"Tài khoản hoặc mật khẩu không đúng" , Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
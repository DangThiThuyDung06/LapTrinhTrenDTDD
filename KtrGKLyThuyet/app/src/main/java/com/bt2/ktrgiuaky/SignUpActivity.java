package com.bt2.ktrgiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText textView0  = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText textView1 = (EditText) findViewById(R.id.editTextTextEmail);
        EditText textView2 = (EditText) findViewById(R.id.editTextTextPass);
        EditText textView3 = (EditText) findViewById(R.id.editTextTextRePass);
        ImageView button = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView2) ;

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView0.getText().toString().equals("")||textView1.getText().toString().equals("")||textView2.getText().toString().equals("")||textView3.getText().toString().equals("")){
                    Toast.makeText( SignUpActivity.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
                } else
                if (textView2.getText().toString().equals(textView3.getText().toString())){
                    Toast.makeText( SignUpActivity.this,"Đăng Kí Thành Công" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText( SignUpActivity.this,"Mật khẩu Không trùng" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
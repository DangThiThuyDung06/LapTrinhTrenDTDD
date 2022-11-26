package com.bt2.baikt1_th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText textView1 = (EditText) findViewById(R.id.email);
        EditText textView2 =  (EditText)  findViewById(R.id.pass);
        ImageView signIn = (ImageView) findViewById(R.id.imageView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "dung";
                String pass = "dung";

                if (textView1.getText().toString().equals("") || textView2.getText().toString().equals("")){
                    Toast.makeText( MainActivity.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((textView1.getText().toString().equals(user)) && (textView2.getText().toString().equals(pass))){
                        Toast.makeText( MainActivity.this,"Thành Công" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, DashBoardSinggerActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText( MainActivity.this,"Tài khoản hoặc mật khẩu không đúng" , Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    }
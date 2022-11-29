package com.bt2.baikt2_th;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class dangKi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView textView = (TextView) findViewById(R.id.textView8);
        ImageView button = (ImageView) findViewById(R.id.imageDangki);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangKi.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
    }
    private void   signup() {
        String taiKhoan, pass;
        EditText textView1 = (EditText) findViewById(R.id.name);
        EditText textView2 = (EditText) findViewById(R.id.emaildk);
        EditText textView3 = (EditText) findViewById(R.id.passdk);
        taiKhoan = textView2.getText().toString();
        pass = textView3.getText().toString();
        FirebaseAuth authException = FirebaseAuth.getInstance();
        authException.createUserWithEmailAndPassword(taiKhoan, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Đăng Kí thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(dangKi.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(dangKi.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

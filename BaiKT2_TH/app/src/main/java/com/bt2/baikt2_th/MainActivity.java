package com.bt2.baikt2_th;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView signIn = (ImageView) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textViewlg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , dangKi.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private void   login(){
        String taiKhoan , pass;
        EditText textView1 = (EditText) findViewById(R.id.emaildk);
        EditText textView2 =  (EditText)  findViewById(R.id.passdk);
        taiKhoan = textView1.getText().toString();
        pass = textView2.getText().toString();
//        if (TextUtils.isEmpty(taiKhoan) || TextUtils.isEmpty(pass)){
//            Toast.makeText( Login.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
//        }
        FirebaseAuth authException = FirebaseAuth.getInstance();
        authException.signInWithEmailAndPassword(taiKhoan,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText( MainActivity.this,"Đăng nhập thành công" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this , ListFish.class);
                    startActivity(intent);
                } else{
                    Toast.makeText( MainActivity.this,"Tài khoản hoặc mật khẩu không đúng" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
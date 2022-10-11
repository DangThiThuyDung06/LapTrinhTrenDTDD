package com.bt2.ktrgiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroMainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        textView = (TextView) findViewById(R.id.textView9);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroMainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        textView = (TextView) findViewById(R.id.textView7);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroMainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
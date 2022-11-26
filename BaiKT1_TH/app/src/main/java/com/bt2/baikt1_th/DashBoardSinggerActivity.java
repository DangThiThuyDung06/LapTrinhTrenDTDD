package com.bt2.baikt1_th;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DashBoardSinggerActivity extends AppCompatActivity {
    TextView btn_left, btn_right;
    ArrayList<Casy> arrCaSy;
    CasyAdapter adapter;
    GridView lsvcasy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_singger);
        init();
        anhXa();
        setClick();
        setUp();
    }

    private void init(){
        arrCaSy = new ArrayList<>();

        arrCaSy.add(new Casy("Nguyễn Thanh Tùng", "Sơn Tùng MTP", "Việt Nam", R.drawable.st, 4f));
        arrCaSy.add(new Casy("Snoop Dogg", "Snoop Dogg", "Mỹ", R.drawable.snoopdogg, 4.5f));
        arrCaSy.add(new Casy("Selena Gomez", "Selena Gomez", "Anh", R.drawable.selenagomez, 3f));
        arrCaSy.add(new Casy("Charlie Puth", "Charlie Puth", "Anh", R.drawable.charlieputh, 3.5f));
        arrCaSy.add(new Casy("Justin Bibber", "Justin Bibber", "Mỹ", R.drawable.iustinbb, 5f));
        arrCaSy.add(new Casy("Nguyễn Thanh Tùng", "Sơn Tùng MTP", "Việt Nam", R.drawable.st, 4f));
        arrCaSy.add(new Casy("Snoop Dogg", "Snoop Dogg", "Mỹ", R.drawable.snoopdogg, 4.5f));
        arrCaSy.add(new Casy("Selena Gomez", "Selena Gomez", "Anh", R.drawable.selenagomez, 3f));
        arrCaSy.add(new Casy("Charlie Puth", "Charlie Puth", "ANh", R.drawable.charlieputh, 3.5f));
        arrCaSy.add(new Casy("Justin Bibber", "Justin Bibber", "Mỹ", R.drawable.iustinbb, 5f));


        adapter = new CasyAdapter(this, 0, arrCaSy);
    };
    private void anhXa(){
        btn_left = findViewById(R.id.btn_left);
        btn_right = findViewById(R.id.btn_right);
        lsvcasy = findViewById(R.id.lsvcasy);
    };
    private void setUp(){
        btn_left.setTextColor(DashBoardSinggerActivity.this.getResources().getColor(R.color.white));
        btn_left.setBackgroundResource(R.drawable.bg_btn_chooseleft);
        btn_right.setTextColor(DashBoardSinggerActivity.this.getResources().getColor(R.color.gray));
        btn_right.setBackground(null);

        lsvcasy.setAdapter(adapter);
    };
    private void setClick(){
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_left.setTextColor(DashBoardSinggerActivity.this.getResources().getColor(R.color.white));
                btn_left.setBackgroundResource(R.drawable.bg_btn_chooseleft);
                btn_right.setTextColor(DashBoardSinggerActivity.this.getResources().getColor(R.color.gray));
                btn_right.setBackground(null);
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_right.setTextColor(DashBoardSinggerActivity.this.getResources().getColor(R.color.white));
                btn_right.setBackgroundResource(R.drawable.bg_btn_chooseright);
                btn_left.setTextColor(DashBoardSinggerActivity.this.getResources().getColor(R.color.gray));
                btn_left.setBackground(null);
            }
        });
    };
}
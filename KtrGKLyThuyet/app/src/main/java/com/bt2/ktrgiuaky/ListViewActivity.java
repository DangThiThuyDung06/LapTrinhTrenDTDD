package com.bt2.ktrgiuaky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class ListViewActivity extends AppCompatActivity {
    ListView lsvdisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lsvdisk = findViewById(R.id.lsvdisk);

        ArrayList<DiskView> arr = new ArrayList<>();

        Random r = new Random();

        arr.add(new DiskView(R.drawable.innishuxanh, 10, "Citric")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.combo, r.nextInt(10) * 5, "Green Tea")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.forest, r.nextInt(10) * 5, "Lotion Cream")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.matna, r.nextInt(10) * 5, "Mask Hyal")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.sonin, r.nextInt(10) * 5, "Lipstick Tints")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.bongmut, r.nextInt(10) * 5, "Cosmetics")); //tap Ctrl+D

        DiskAdapter adapter = new DiskAdapter(this, 0, arr);
        lsvdisk.setAdapter(adapter);

        /*lsvdisk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(ListViewActivity.this, MainActivity2.class));
                }
            }
        });*/

        lsvdisk.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int which_item = i;
                new AlertDialog.Builder(ListViewActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn xóa hay không?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arr.remove(which_item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });

    }

}
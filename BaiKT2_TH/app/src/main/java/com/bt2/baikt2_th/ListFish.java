package com.bt2.baikt2_th;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ListFish extends AppCompatActivity {
    RecyclerView recyclerView;
    CaAdapter caAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fish);

        imageView = (ImageView)findViewById(R.id.add1);
        recyclerView = (RecyclerView) findViewById(R.id.lsvca);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Ca> options =
                new FirebaseRecyclerOptions.Builder<Ca>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("QuanLyCa"), Ca.class)
                        .build();

        caAdapter=new CaAdapter(options);
        recyclerView.setAdapter(caAdapter);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , AddActivity.class));
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        caAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        caAdapter.stopListening();
    }
}
package com.bt2.ktrgiuaky;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class SkinFragment extends Fragment {
    ListView lsvdisk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        lsvdisk = lsvdisk.findViewById(R.id.lsvdisk);

        ArrayList<DiskView> arr = new ArrayList<>();

        Random r = new Random();

        arr.add(new DiskView(R.drawable.innishuxanh, 10, "Citric")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.combo, r.nextInt(10) * 5, "Green Tea")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.forest, r.nextInt(10) * 5, "Lotion Cream")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.matna, r.nextInt(10) * 5, "Mask Hyal")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.sonin, r.nextInt(10) * 5, "Lipstick Tints")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.bongmut, r.nextInt(10) * 5, "Cosmetics")); //tap Ctrl+D

        DiskAdapter adapter = new DiskAdapter(null, 0, arr);
        lsvdisk.setAdapter(adapter);

        /*lsvdisk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(ListViewActivity.this, MainActivity2.class));
                }
            }
        });*/
        return inflater.inflate(R.layout.activity_listview, container, false);


    }
}
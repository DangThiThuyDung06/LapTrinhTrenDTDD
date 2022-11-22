package com.bt2.baikt2_th;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class CaAdapter extends ArrayAdapter<Ca> {
    private Context ct;
    private ArrayList<Ca> arr;
    public CaAdapter(@NonNull Context context, int resource, @NonNull List<Ca> objects) {
        super(context, resource, objects);

        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater =  (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_casy, null);
        }
        if(arr.size()>0){
            Ca h = arr.get(position);
            ImageView anh = convertView.findViewById(R.id.imgAnh);
            anh.setImageResource(h.getAnh());

            TextView tenkhoahoc = convertView.findViewById(R.id.tenkhoahoc);
            tenkhoahoc.setText(h.getTenkhoahoc());

            TextView tenthuonggoi = convertView.findViewById(R.id.tenthuonggoi);
            tenthuonggoi.setText(h.getTenthuonggoi());

            TextView dactinh = convertView.findViewById(R.id.dactinh);
            dactinh.setText(h.getDactinh());

            TextView mausac = convertView.findViewById(R.id.mausac);
            mausac.setText(h.getMausac());

            MaterialRatingBar star = convertView.findViewById(R.id.star);
            star.setRating(h.getStar());
        }
        return convertView;
    }
}

//adapter = new CasyAdapter(this, R.layout.custom_list, arrCaSy);

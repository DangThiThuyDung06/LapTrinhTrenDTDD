package com.bt2.baikt1_th;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class CasyAdapter extends ArrayAdapter<Casy> {
    private Context ct;
    private ArrayList<Casy> arr;
    public CasyAdapter(@NonNull Context context, int resource, @NonNull List<Casy> objects) {
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
            Casy h = arr.get(position);
            ImageView anh = convertView.findViewById(R.id.imgAnh);
            anh.setImageResource(h.getAnh());

            TextView tencasy = convertView.findViewById(R.id.tencasy);
            tencasy.setText(h.getTen());

            TextView nghedanh = convertView.findViewById(R.id.nghedanh);
            nghedanh.setText(h.getNghedanh());

            TextView quocgia = convertView.findViewById(R.id.quocgia);
            quocgia.setText(h.getQuocgia());

            MaterialRatingBar star = convertView.findViewById(R.id.star);
            star.setRating(h.getStar());
        }
        return convertView;
    }
}

package com.bt2.baikt2_th;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class CaAdapter extends FirebaseRecyclerAdapter<Ca, CaAdapter.myviewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CaAdapter(@NonNull FirebaseRecyclerOptions<Ca> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Ca model) {
        holder.tenkhoahoc.setText(model.tenkhoahoc);
        holder.tenthuonggoi.setText(model.tenthuonggoi);
        holder.mausac.setText(model.mausac);
        holder.dactinh.setText(model.dactinh);
        Glide.with(holder.img.getContext()).load(model.hinhanh).into(holder.img);
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update))
                        .setExpanded(true,1200)
                        .create();
                View view = dialogPlus.getHolderView();
                EditText tenkhoahoc = view.findViewById(R.id.tenkhoahocud);
                EditText tenthuonggoi = view.findViewById(R.id.tenthuonggoiud);
                EditText mausac = view.findViewById(R.id.mausacud);
                EditText dactinh = view.findViewById(R.id.dactinhud);
                EditText hinhanh = view.findViewById(R.id.hinhanhud);


                Button btnButton = view.findViewById(R.id.btnUpdate);

                tenkhoahoc.setText(model.getTenkhoahoc());
                tenthuonggoi.setText(model.getTenthuonggoi());
                mausac.setText(model.getMausac());
                dactinh.setText(model.getDactinh());
                hinhanh.setText(model.getHinhanh());
                dialogPlus.show();

                btnButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("tenkhoahoc",tenkhoahoc.getText().toString());
                        map.put("tenthuonggoi",tenthuonggoi.getText().toString());
                        map.put("mausac",mausac.getText().toString());
                        map.put("dactinh",dactinh.getText().toString());
                        map.put("hinhanh",hinhanh.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("QuanLyCa")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.tenkhoahoc.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                                        Toast.makeText(holder.tenkhoahoc.getContext(), "Data Updated Error", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.tenkhoahoc.getContext());
                builder.setTitle("Are you Sure ?");
                builder.setMessage("Detele data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("QuanLyCa")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.tenkhoahoc.getContext(), "Cancel", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_casy,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder  extends RecyclerView.ViewHolder {
        ImageView img, btnUpdate, btnDelete;
        TextView tenkhoahoc, tenthuonggoi, mausac, dactinh;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            btnUpdate = (ImageView) itemView.findViewById(R.id.btn_update);
            btnDelete = (ImageView) itemView.findViewById(R.id.btn_delete);
            img = (ImageView) itemView.findViewById(R.id.imgAnh);
            tenkhoahoc = (TextView) itemView.findViewById(R.id.tenkhoahoc);
            tenthuonggoi = (TextView) itemView.findViewById(R.id.tenthuonggoi);
            mausac = (TextView) itemView.findViewById(R.id.mausac);
            dactinh = (TextView) itemView.findViewById(R.id.dactinh);
        }
    }
}



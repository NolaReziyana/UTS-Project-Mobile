package com.example.resepku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoder>{

    private ArrayList<String> gambar = new ArrayList<>();
    private ArrayList<String> namaresep = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> gambar, ArrayList<String> namaresep, Context context) {
        this.gambar = gambar;
        this.namaresep = namaresep;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardresep, parent, false);
        ViewHoder holder = new ViewHoder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        Glide.with(context).asBitmap().load(gambar.get(position)).into(holder.gambar);
        holder.namaresep.setText(namaresep.get(position));
    }

    @Override
    public int getItemCount() {
        return namaresep.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{

        ImageView gambar;
        TextView namaresep;
        RelativeLayout relativeLayout;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            namaresep = itemView.findViewById(R.id.namaresep);
            relativeLayout = itemView.findViewById(R.id.r1);
        }
    }
}

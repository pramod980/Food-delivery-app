package com.example.myapplication.Activity.Adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.Domain.RecommendedDomain;
import com.example.myapplication.Activity.Show_detail;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecommendyAdapter extends RecyclerView.Adapter<RecommendyAdapter.ViewHolder> {
    ArrayList<RecommendedDomain> recommendedDomains;

    public RecommendyAdapter(ArrayList<RecommendedDomain> recommendedDomains) {
        this.recommendedDomains = recommendedDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infalte= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(infalte);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title1.setText(recommendedDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(recommendedDomains.get(position).getFee()));
        String picurl = " ";
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(recommendedDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.Pic);
        holder.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), Show_detail.class);
                intent.putExtra("data",recommendedDomains.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommendedDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView  title1,fee;
        ImageView Pic;
        TextView addbtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1=itemView.findViewById(R.id.title1);
            fee=itemView.findViewById(R.id.fee);
            Pic=itemView.findViewById(R.id.pic);
            addbtn=itemView.findViewById(R.id.addbtn);
        }
    }
}

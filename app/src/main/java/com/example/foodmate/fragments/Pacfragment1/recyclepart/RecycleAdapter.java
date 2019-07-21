package com.example.foodmate.fragments.Pacfragment1.recyclepart;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodmate.R;
import com.example.foodmate.fragments.Pacfragment1.foodAPI.food_how;
import com.example.foodmate.fragments.Pacfragment1.frag1_vewview;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<recycleformation>mrecycleformation;
    private Context mContext;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(mContext==null){
            mContext=viewGroup.getContext();
        }
        View view= LayoutInflater.from(mContext)
                .inflate(R.layout.recyclelittlepart,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), food_how.class);
               v.getContext().startActivity(intent);
            }
        });
        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(holder.ii.equals("asd")){
                    holder.imageView22.setImageResource(R.drawable.call1);
                    holder.ii="zxc";
                }
                else {
                    holder.imageView22.setImageResource(R.drawable.call2);
                    holder.ii = "asd";
                }

            }
        });
        holder.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), frag1_vewview.class);
                v.getContext().startActivity(intent);

            }
        });

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        recycleformation mmformation=mrecycleformation.get(i);
        viewHolder.textView.setText(mmformation.getName());
        Glide.with(mContext).load(mmformation.getImageid()).into(viewHolder.imageView);
    }
    @Override
    public int getItemCount() {
        return mrecycleformation.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        ImageView imageView22;
        TextView textView;
        ImageView image2;
        ImageView image3;
        String ii=new String();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView)itemView;
            imageView=itemView.findViewById(R.id.recycle_imageview);
            textView=itemView.findViewById(R.id.recycle_include);
            image2=itemView.findViewById(R.id.call);
            imageView22=itemView.findViewById(R.id.call);
            image3=itemView.findViewById(R.id.share);
        }
    }
    public RecycleAdapter(List<recycleformation>recycleformationList){
        mrecycleformation=recycleformationList;

    }


}

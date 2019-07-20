package com.example.foodmate.recyclepart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodmate.R;
import com.example.foodmate.fragments.Pacfragment1.food_how;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<recycleformation>mrecycleformation;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclelittlepart,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.fruitview.setOnClickListener(new View.OnClickListener() {
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

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        recycleformation mmformation=mrecycleformation.get(i);
        viewHolder.imageView.setImageResource(mmformation.getImageid());
        viewHolder.textView.setText(mmformation.getName());
    }
    @Override
    public int getItemCount() {
        return mrecycleformation.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitview;
        ImageView imageView;
        ImageView imageView22;
        TextView textView;
        ImageView image2;
        String ii=new String();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitview=itemView;
            imageView=itemView.findViewById(R.id.recycle_imageview);
            textView=itemView.findViewById(R.id.recycle_include);
            image2=itemView.findViewById(R.id.call);
            imageView22=itemView.findViewById(R.id.call);
        }
    }
    public RecycleAdapter(List<recycleformation>recycleformationList){
        mrecycleformation=recycleformationList;

    }


}

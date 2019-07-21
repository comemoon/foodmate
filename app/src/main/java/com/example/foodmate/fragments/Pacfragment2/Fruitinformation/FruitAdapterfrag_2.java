package com.example.foodmate.fragments.Pacfragment2.Fruitinformation;

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
import com.example.foodmate.fragments.Pacfragment2.webviewfrag_2;

import java.util.List;

public class FruitAdapterfrag_2 extends RecyclerView.Adapter<FruitAdapterfrag_2.ViewHolder> {
    private Context mContext;
    private List<Fruit_2>mFruitlistfrag_2;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(mContext==null){
            mContext=viewGroup.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fruit_itemfrag_2,viewGroup,false);
        final  ViewHolder holder=new ViewHolder(view);
        holder.fruitImagefrag_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),webviewfrag_2.class);
                v.getContext().startActivity(intent);
            }
        });
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit_2 fruit222=mFruitlistfrag_2.get(i);
        viewHolder.fruitNamefrag_2.setText(fruit222.getName());
        Glide.with(mContext).load(fruit222.getImageid()).into(viewHolder.fruitImagefrag_2);

    }
    @Override
    public int getItemCount() {
        return mFruitlistfrag_2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImagefrag_2;
        TextView fruitNamefrag_2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView)itemView;
            fruitImagefrag_2=itemView.findViewById(R.id.imagefrag_2);
            fruitNamefrag_2=itemView.findViewById(R.id.textfrag_2);
        }
    }
    public FruitAdapterfrag_2(List<Fruit_2>fruitlist22)
    {
        mFruitlistfrag_2=fruitlist22;
    }
}

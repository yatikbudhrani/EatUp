package com.example.antailbaxt3r.myrestaurant;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private ArrayList<String> mItemNames;
    private ArrayList<String> mItemPrices;
    private ArrayList<String> mImages;
    private Context mcontext;

    public ItemAdapter(ArrayList<String> mItemNames, ArrayList<String> mItemPrices, ArrayList<String> mImages, Context mcontext) {
        this.mItemNames = mItemNames;
        this.mItemPrices = mItemPrices;
        this.mImages = mImages;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String price = "Rs. " + mItemPrices.get(i);
        viewHolder.itemName.setText(mItemNames.get(i));
        viewHolder.itemPrice.setText(price);
        Glide.with(mcontext)
                .load(mImages.get(i))
                .into(viewHolder.image);

        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mcontext , Description.class);
                intent.putExtra("imageURL", mImages.get(i));
                intent.putExtra("itemName", mItemNames.get(i));
                intent.putExtra("itemPrice", mItemPrices.get(i));

                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView itemName;
        TextView itemPrice;
        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            itemName = itemView.findViewById(R.id.textViewTitle);
            itemPrice = itemView.findViewById(R.id.textViewPrice);
            parent_layout = itemView.findViewById(R.id.parent_layout);

        }
    }

}

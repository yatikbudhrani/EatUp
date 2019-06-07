package com.example.antailbaxt3r.myrestaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private Context mOrderContext;

    public OrderItemAdapter(Context mOrderContext) {
        this.mOrderContext = mOrderContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String price = "Rs. " + OrderClass.orderPrice.get(i);
        viewHolder.orderItemName.setText(OrderClass.orderItems.get(i));
        viewHolder.orderItemPrice.setText(price);

    }

    @Override
    public int getItemCount() {
        return OrderClass.orderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       TextView orderItemName;
       TextView orderItemPrice;
       LinearLayout order_items_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderItemName = itemView.findViewById(R.id.orderItemTV);
            orderItemPrice = itemView.findViewById(R.id.orderPriceTV);
            order_items_layout = itemView.findViewById(R.id.order_parent_layout);
        }
    }
}
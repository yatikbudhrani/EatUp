package com.example.antailbaxt3r.myrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    RecyclerView recyclerView;
    int total = 0;
    String totalCost = "Rs. ";
    TextView totalPrice;
    CardView placeOrderbtn;
    CardView removeOrderbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        placeOrderbtn = findViewById(R.id.placeOrder_btn);
        removeOrderbtn = findViewById(R.id.removeOrder_btn);
        totalPrice = findViewById(R.id.total);

        initRecyclerView();
        getTotal();
        totalCost = totalCost + Integer.toString(total);

        totalPrice.setText(totalCost);

        placeOrderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(OrderClass.orderItems.size() >=1){

                    Toast.makeText(Order.this, "Your Order Has Been Placed. The Total Bill is " + totalCost, Toast.LENGTH_SHORT).show();
                    OrderClass.orderItems = new ArrayList<>();
                    OrderClass.orderPrice = new ArrayList<>();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }else{

                    Toast.makeText(Order.this, "Your Order Is Empty", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        removeOrderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int last = OrderClass.orderItems.size();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                if(last >= 1) {
                    OrderClass.orderItems.remove(OrderClass.orderItems.get(last - 1));
                    OrderClass.orderPrice.remove(OrderClass.orderPrice.get(last - 1));
                }else{

                    Toast.makeText(Order.this, "Nothing To Remove", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initRecyclerView(){
        RecyclerView recyclerView2 = findViewById(R.id.recyclerViewOrder);
        OrderItemAdapter adapter = new OrderItemAdapter(this);
        recyclerView2.setAdapter(adapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getTotal(){

        for(int i = 0; i< OrderClass.orderPrice.size();i++){
            total = total + Integer.parseInt(OrderClass.orderPrice.get(i));
        }
    }
}
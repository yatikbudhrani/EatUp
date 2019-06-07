package com.example.antailbaxt3r.myrestaurant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Yatik extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    CardView btn,btn2;
    int tables;

    DatabaseReference mRootRef=FirebaseDatabase.getInstance().getReference();
    DatabaseReference tablesFree=mRootRef.child("TablesFree");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yatik);

        tv2 = findViewById(R.id.tablesfreeTV);
        btn = findViewById(R.id.bookatablebtn);
        btn2 = findViewById(R.id.vacatetablebtn);

    }

    @Override
    protected void onStart() {
        super.onStart();

        tablesFree.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                tables=Integer.parseInt(text);
                tv2.setText(Integer.toString(tables));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tables >0) {
                    tables--;
                    tablesFree.setValue(Integer.toString(tables));
                }else{
                    Toast.makeText(Yatik.this, "No More Tables To Book", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tables <= 10) {
                    tables++;
                    tablesFree.setValue(Integer.toString(tables));
                }else{
                    Toast.makeText(Yatik.this, "All Tables Have Been Vacated", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
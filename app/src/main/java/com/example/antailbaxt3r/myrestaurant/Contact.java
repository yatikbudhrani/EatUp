package com.example.antailbaxt3r.myrestaurant;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Contact extends AppCompatActivity {

    CardView callArjun;
    CardView callYash;
    CardView callYatik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        callArjun = findViewById(R.id.callArjun);
        callYash  = findViewById(R.id.callYash);
        callYatik = findViewById(R.id.callYatik);

        callArjun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posted_by = "111-333-222-4";

                String uri = "tel:" + posted_by.trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        callYash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posted_by = "111-333-222-4";

                String uri = "tel:" + posted_by.trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        callYatik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posted_by = "111-333-222-4";

                String uri = "tel:" + posted_by.trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}

package com.zmei.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //setTitle("Zmei_order");
        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userName");
        String goodsName = orderIntent.getStringExtra("goodsName");
        int quantity = orderIntent.getIntExtra("quantity",0);
        double orderPrice = orderIntent.getDoubleExtra("orderPrice",0);
        double price = orderIntent.getDoubleExtra("price",0);
        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText("Customer name: "+userName+ " \n" + "Goods name: "+goodsName+ " \n" + "Quantity: "+quantity+ " \n"+"Price: "+price+ " \n" +"Order price: "+orderPrice);
    }
}
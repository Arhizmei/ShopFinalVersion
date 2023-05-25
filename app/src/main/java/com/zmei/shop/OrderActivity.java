package com.zmei.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    String[] addresses = {"example@gmail.com"};
    String subject = "Order from music shop";
    String emailText ;
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
        emailText = "Customer name: "+userName+ " \n" + "Goods name: "+goodsName+ " \n" + "Quantity: "+quantity+ " \n"+"Price: "+price+ " \n" +"Order price: "+orderPrice;

        orderTextView.setText( emailText);

    }
    public void submitOrder(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,  emailText);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send email"));;
        }
    }
}
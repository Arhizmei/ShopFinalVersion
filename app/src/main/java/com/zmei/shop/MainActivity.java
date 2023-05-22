package com.zmei.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    int quantity = 0;
    Spinner mySpinner;
    ArrayList mySpinnerArrayList;
    ArrayAdapter mySpinnerAdapter;
    HashMap  goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mySpinner = findViewById(R.id.mySpinner);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

        mySpinnerArrayList = new ArrayList();
    mySpinnerArrayList.add("guitar");
    mySpinnerArrayList.add("drums");
    mySpinnerArrayList.add("keyboard");
    mySpinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mySpinnerArrayList);
    mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    mySpinner.setAdapter(mySpinnerAdapter);
    mySpinner.setOnItemSelectedListener(this);
    goodsMap = new HashMap();
    goodsMap.put("guitar", 100);
    goodsMap.put("drums", 900);
    goodsMap.put("keyboard", 600);
    }

    public void increaseQuantity(View view) {

        quantity = quantity + 1;
        TextView quantitY = findViewById(R.id.quantitY);
        quantitY.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.price);
        String priceQuantity;
        priceQuantity = String.valueOf(quantity * price);
        priceTextView.setText(priceQuantity );

    }

    public void DecreaseQuantity(View view) {
        quantity = quantity - 1;
        if (quantity<0){
            quantity=0;

        }

        TextView quantitY = findViewById(R.id.quantitY);
        quantitY.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.price);
        String priceQuantity;
        priceQuantity = String.valueOf(quantity * price);
        priceTextView.setText(priceQuantity );


    }
    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.button2) {
            increaseQuantity(view);
        } else if (viewId == R.id.button1) {
            DecreaseQuantity(view);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = mySpinner.getSelectedItem().toString();
        price = (int)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.price);
        String priceQuantity;
        priceQuantity = String.valueOf(quantity * price);
        priceTextView.setText(priceQuantity );
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}



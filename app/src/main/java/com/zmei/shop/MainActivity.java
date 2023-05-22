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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
    mySpinnerArrayList = new ArrayList();
    mySpinnerArrayList.add("guitar");
    mySpinnerArrayList.add("drums");
    mySpinnerArrayList.add("keyboard");
    mySpinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mySpinnerArrayList);
    mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    mySpinner.setAdapter(mySpinnerAdapter);
    goodsMap = new HashMap();
    goodsMap.put("guitar", 100);
    goodsMap.put("drums", 900);
    goodsMap.put("keyboard", 600);
    }

    public void increaseQuantity(View view) {

        quantity = quantity + 1;
        TextView quantitY = findViewById(R.id.quantitY);
        quantitY.setText("" + quantity);
    }

    public void DecreaseQuantity(View view) {
        quantity = quantity - 7;
        if (quantity<0){
            quantity=0;
        }

        TextView quantitY = findViewById(R.id.quantitY);
        quantitY.setText("" + quantity);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = mySpinner.getSelectedItem().toString();
        price = goodsMap.get(goodsName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



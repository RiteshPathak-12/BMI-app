package com.example.myfirstapplicationbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight,edtHeightIN,edtHeightFT;
        Button btnCalculate;
        LinearLayout main;

        edtHeightIN=findViewById(R.id.edtHeightIN);
        edtHeightFT=findViewById(R.id.edtHeightFT);
        edtWeight=findViewById(R.id.edtWeight);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        main=findViewById(R.id.main);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int in= Integer.parseInt(edtHeightIN.getText().toString());
                int ft=Integer.parseInt(edtHeightFT.getText().toString());

                int totalIn=ft*12+in;

                double totalCm=totalIn*2.54;

                double totalM=totalCm/100;

                double bmi=wt/(totalM*totalM);
                if(bmi>25)
                {
                    txtResult.setText("  You are over weight. \n You need to decrese your weight" +
                            "\n\n   Perfect Diet Plan for Weight less:- \n\nBreakfast :- Oats with milk and nuts or vegetable poha with peanuts \n\nMid-Morning Snack:- A piece of Fruit \n\nLunch:- Roti(1-2) or brown Rice, mixed vegetable curry and a side of dal\n\nEvening Snack :- A handfull of rosted chana or almonds.\n\nDinner:- Vegetable khichdi with curd");
                    main.setBackgroundColor(getResources().getColor(R.color.colorOW));

                } else if (bmi<18) {
                    txtResult.setText("\tYou are under weight. \n You Need to increase your weight.\n\nBreakfast:- 2 egg brown bread sandwich, Green chutney, 1 cup milk, 3  cashews, 4 almonds, 2 walnuts.\n\nMid_Meal:- 1 cup banana shake.\n\nLunch:- Arhar Dal,potato curry,3 chapatti,rice,curd,Salad.\n\nEvening:- Vegetable Poha\n\nDinner:- Chicken curry,3 Roti,Salad");
                    main.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else {
                    txtResult.setText("You are healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });
    }
}
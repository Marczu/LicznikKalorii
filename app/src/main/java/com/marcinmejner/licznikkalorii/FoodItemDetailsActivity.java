package com.marcinmejner.licznikkalorii;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Food;

public class FoodItemDetailsActivity extends AppCompatActivity {
    private TextView foodName, calories, dateTaken;
    private Button shareButton;
    private int foodId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details);

        foodName = findViewById(R.id.detsFoodName);
        calories = findViewById(R.id.detsCalioriesValue);
        dateTaken = findViewById(R.id.detsDateText);
        shareButton = findViewById(R.id.detsShareButton);

        Food food = (Food) getIntent().getSerializableExtra("userObj");

        foodName.setText(food.getFoodName());
        calories.setText(String.valueOf(food.getCalories()));
        dateTaken.setText(food.getRecordDate());

        foodId = food.getFoodId();

        calories.setTextSize(45);
        calories.setTextColor(Color.RED);










    }

    public void shareCals(){

        StringBuilder dataString = new StringBuilder();

        String name = foodName.getText().toString();
        String cals = calories.getText().toString();
        String date = dateTaken.getText().toString();

        dataString.append(" Jedzenie: " + name + "\n" );
        dataString.append(" Kalorii: " + cals+ "\n" );
        dataString.append(" Zjedzone: " + date );

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc882");
        i.putExtra(Intent.EXTRA_SUBJECT, "Moje zjedzone kalorie");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"traxus100@gmail.com"} );
        i.putExtra(Intent.EXTRA_TEXT, dataString.toString());

        try{

            startActivity(Intent.createChooser());

        }catch (ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(), "Prosze zainstalować klienta Email", Toast.LENGTH_LONG).show();
        }

    }
}

package com.example.android.droidcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


/**
 * This activity handles five checkboxes and a Show Toast button for displaying selected checkboxes
 */
public class CheckboxesActivity extends AppCompatActivity {
    String showshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxes);
    }

    public void ShowToast(View view) {
        showshow = "Topping:";
        CheckBox checkBox = findViewById(R.id.checkBox);
        if(checkBox.isChecked()){
            showshow += " Chocolate syrup";
        }
        checkBox = findViewById(R.id.checkBox2);
        if(checkBox.isChecked()){
            showshow += " Sprinkles";
        }
        checkBox = findViewById(R.id.checkBox3);
        if(checkBox.isChecked()){
            showshow += " Crushed nuts";
        }
        checkBox = findViewById(R.id.checkBox4);
        if(checkBox.isChecked()){
            showshow += " Cherries";
        }
        checkBox = findViewById(R.id.checkBox5);
        if(checkBox.isChecked()){
            showshow += " Orio cookie crumbles";
        }
        Toast toast = Toast.makeText(this, showshow,
                Toast.LENGTH_SHORT);
        toast.show();

    }
}

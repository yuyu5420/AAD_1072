package com.example.batterylevelindicator;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView battery_level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery_level = findViewById(R.id.battery);

    }

    public void decrease(View view) {
        LevelListDrawable listDrawable = (LevelListDrawable)battery_level.getDrawable();
        int n = listDrawable.getLevel();
        if(n != 0)  listDrawable.setLevel(n-1);

    }

    public void increase(View view) {
        LevelListDrawable listDrawable = (LevelListDrawable)battery_level.getDrawable();
        int n = listDrawable.getLevel();
        if(n != 6)  listDrawable.setLevel(n+1);
    }
}

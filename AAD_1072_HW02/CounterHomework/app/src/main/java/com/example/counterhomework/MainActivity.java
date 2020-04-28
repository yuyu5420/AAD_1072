package com.example.counterhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // EditText view for the message
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount =  findViewById(R.id.show_count);
        // Initialize all the view variables.
        mEditText = findViewById(R.id.editText);


        // Restore the state.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                mCount = Integer.valueOf(savedInstanceState.getString("reply_text"));
                mShowCount.setText(savedInstanceState.getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(LOG_TAG, "onSave");
        super.onSaveInstanceState(outState);
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mShowCount.getText().toString());

        }
    }
    public void CountUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

    }
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}

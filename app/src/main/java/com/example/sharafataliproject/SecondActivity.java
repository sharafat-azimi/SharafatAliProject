package com.example.sharafataliproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by sharafat lai on 4/4/2017.
 */
public class SecondActivity extends Activity {
    TextView nameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameTextView = (TextView) findViewById(R.id.textView_name);
        Intent intent = getIntent();
        String fName = intent.getStringExtra("name");
        nameTextView.setText(fName);
    }
}

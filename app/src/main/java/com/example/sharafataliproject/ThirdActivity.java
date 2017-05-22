package com.example.sharafataliproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sharafat lai on 4/4/2017.
 */
public class ThirdActivity extends Activity implements View.OnClickListener {
    Button resultButton;
    EditText resultEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        resultButton = (Button) findViewById(R.id.button_result);
        resultEditText = (EditText) findViewById(R.id.editText_result);
        resultButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = resultEditText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name",name);
        setResult(RESULT_OK,intent);
    }
}

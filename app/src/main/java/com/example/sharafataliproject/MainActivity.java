package com.example.sharafataliproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharafat lai on 4/4/2017.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    Button submitButton,startSecondButton,activityResultButton,onoffButton;
    EditText dataEditText;
    public static final String TAG = "MainActivity";
    boolean state = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = (Button) findViewById(R.id.button_submit);
        startSecondButton = (Button) findViewById(R.id.button_start_second_activity);
        startSecondButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
        dataEditText = (EditText) findViewById(R.id.editText_data);
        activityResultButton = (Button) findViewById(R.id.button_activity_result);

        activityResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivityForResult(intent,200);
            }
        });
        onoffButton = (Button) findViewById(R.id.button_on_off);
        onoffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = !state;
                if(state == true){
                    onoffButton.setText(R.string.off);
                }else{
                    onoffButton.setText(R.string.on);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_submit) {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();
        }else if(id == R.id.button_start_second_activity){
            Intent intent = new Intent(this,SecondActivity.class);
            String data = dataEditText.getText().toString();
            intent.putExtra("name",data);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200){
            if(resultCode==RESULT_OK){
                String name = data.getStringExtra("name");
                Toast.makeText(this,name,Toast.LENGTH_LONG).show();

            }
        }
    }
}

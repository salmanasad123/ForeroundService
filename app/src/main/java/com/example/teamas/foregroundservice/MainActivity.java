package com.example.teamas.foregroundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextInput;
    private Button startService;
    private Button stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput = findViewById(R.id.et_input);
        startService = findViewById(R.id.btn_start_service);
        stopService = findViewById(R.id.btn_stop_service);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                String input = editTextInput.getText().toString();
                Intent serviceIntentStart = new Intent(MainActivity.this, ExampleService.class);
                serviceIntentStart.putExtra("Input", input);
                startService(serviceIntentStart);
                break;

            case R.id.btn_stop_service:
                Intent serviceIntentStop = new Intent(MainActivity.this, ExampleService.class);
                stopService(serviceIntentStop);
                break;
        }

    }
}

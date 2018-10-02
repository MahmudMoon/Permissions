package com.sms.demo.permissions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opening_window extends AppCompatActivity {

    Button btnAllApps, btnBackgroudApps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_window);

        init_views();
        init_variable();
        init_functions();
        init_listeners();



    }

    private void init_listeners() {

    }

    private void init_functions() {

    }

    private void init_variable() {
        btnAllApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opening_window.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnBackgroudApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opening_window.this,BackgroundApps.class);
                startActivity(intent);
            }
        });
    }

    private void init_views() {
        btnAllApps = (Button)findViewById(R.id.button4);
        btnBackgroudApps = (Button)findViewById(R.id.button3);
    }
}

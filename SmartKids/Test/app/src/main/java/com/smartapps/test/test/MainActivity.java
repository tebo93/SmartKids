package com.smartapps.test.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.smartapps.test.test.View.InformationA;
import com.smartapps.test.test.View.InformationSpecialA;
import com.smartapps.test.test.View.LoginA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tvMain);
        tv.setText("ClickMe");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginA.class);
                //Intent i = new Intent(MainActivity.this, InformationSpecialA.class);
                i.putExtra("cancerType", "Oido");
                startActivity(i);
            }
        });
    }
}

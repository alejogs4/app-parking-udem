package com.ags.agsmvmm.parqueaderosudem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonSearch;
    private Button buttonRegistryIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectViews();

        buttonRegistryIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegistryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void connectViews() {
        buttonSearch = (Button) findViewById(R.id.btn_search);
        buttonRegistryIncome = (Button) findViewById(R.id.btn_income);
    }
}

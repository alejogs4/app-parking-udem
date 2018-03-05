package com.ags.agsmvmm.parqueaderosudem;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by USUARIO on 5/03/2018.
 */

public class RegistryActivity extends AppCompatActivity {
    private EditText vehicleIdentification;
    private RadioGroup placeInformation;
    private RadioGroup typeOfVehicle;

    private Button buttonRegistryIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registry_activity);
        connectViews();
        buttonRegistryIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL urlEndpoint = new URL("https://jsonplaceholder.typicode.com/posts/");
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void connectViews() {
        vehicleIdentification = (EditText) findViewById(R.id.txt_placa);
        placeInformation = (RadioGroup) findViewById(R.id.place_group);
        typeOfVehicle = (RadioGroup) findViewById(R.id.type_group);
        buttonRegistryIncome = (Button) findViewById(R.id.btn_registry_income);
    }
}

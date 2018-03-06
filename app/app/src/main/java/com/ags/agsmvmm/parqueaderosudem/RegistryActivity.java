package com.ags.agsmvmm.parqueaderosudem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import Income.Income;


/**
 * Created by Alejandro Garcia on 5/03/2018.
 */

public class RegistryActivity extends AppCompatActivity {
    private EditText vehicleIdentification;
    private RadioGroup placeInformation;
    private RadioGroup typeOfVehicle;

    private Button buttonRegistryIncome;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registry_activity);
        reference = FirebaseDatabase.getInstance().getReference();
        connectViews();
        buttonRegistryIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vehicleIdentification.getText().toString().isEmpty()) {
                    Toast.makeText(RegistryActivity.this,"Se debe ingresar todos los datos",Toast.LENGTH_SHORT).show();
                    return;
                }
                Income income = new Income(vehicleIdentification.getText().toString(),setPlace(),setType());
                reference.child("entradas-universidad").child(income.getId()).setValue(income);
                Toast.makeText(RegistryActivity.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),IncomeReport.class);
                startActivity(intent);
            }
        });
    }

    private String setPlace() {
        if(placeInformation.getCheckedRadioButtonId() == R.id.engineering) return "I";
        if(placeInformation.getCheckedRadioButtonId() == R.id.administration) return "A";
        if(placeInformation.getCheckedRadioButtonId() == R.id.sport) return "S";
        return "M";
    }

    private String setType() {
        if(typeOfVehicle.getCheckedRadioButtonId() == R.id.car) return "Carro";
        return "Moto";
    }

    private void connectViews() {
        vehicleIdentification = (EditText) findViewById(R.id.txt_placa);
        placeInformation = (RadioGroup) findViewById(R.id.place_group);
        typeOfVehicle = (RadioGroup) findViewById(R.id.type_group);
        buttonRegistryIncome = (Button) findViewById(R.id.btn_registry_income);
    }
}

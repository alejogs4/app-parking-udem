package com.ags.agsmvmm.parqueaderosudem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Income.Income;

/**
 * Created by USUARIO on 6/03/2018.
 */

public class IncomeReport extends AppCompatActivity {

    private TextView vehicleId;
    private TextView vehiclePlace;
    private TextView incomePrice;
    private TextView vehicleType;
    private TextView incomeDate;

    private Button buttonBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_data);
        connectViews();

        Bundle extras = getIntent().getExtras();
        String key = extras.getString("key");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child(key);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Income income = dataSnapshot.getValue(Income.class);
                fillTextViews(income);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void fillTextViews(Income income) {
     vehicleId.setText(vehicleId.getText().toString() + "" + income.getId());
     vehiclePlace.setText(vehiclePlace.getText().toString() + "" + income.getPlace());
     incomePrice.setText(incomePrice.getText().toString() + "" + income.getPrice());
     vehicleType.setText(vehicleType.getText().toString() + "" + income.getType());
     incomeDate.setText(incomeDate.getText().toString() + "" + income.getDate());
    }

    private void connectViews() {
        vehicleId = (TextView) findViewById(R.id.txt_vehicle_id);
        vehiclePlace = (TextView) findViewById(R.id.txt_vehicle_place);
        incomePrice = (TextView) findViewById(R.id.txt_vehicle_price);
        vehicleType = (TextView) findViewById(R.id.txt_vehicle_type);
        incomeDate = (TextView) findViewById(R.id.txt_vehicle_date);

        buttonBackToHome = (Button) findViewById(R.id.btn_back_home);
    }
}

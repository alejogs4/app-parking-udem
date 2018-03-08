package com.ags.agsmvmm.parqueaderosudem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Income.Income;

/**
 * Created by USUARIO on 7/03/2018.
 */

public class IncomesResults extends AppCompatActivity {

    private ArrayList<String> incomes = new ArrayList<>();
    private ArrayList<Income> incomeData = new ArrayList<>();
    private ArrayAdapter adapter;

    private Button btnSearchAdvance;
    private ListView listIncomes;

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.income_results);

        adapter = new ArrayAdapter(IncomesResults.this,android.R.layout.simple_list_item_1,incomes);

        btnSearchAdvance = (Button) findViewById(R.id.btn_advanced);
        listIncomes = (ListView) findViewById(R.id.ltv_incomes);

        listIncomes.setAdapter(adapter);

        btnSearchAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IncomesResults.this,SearchAdvanced.class);
                startActivity(intent);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                incomes.clear();
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    Income in = data.getValue(Income.class);
                    if(in.isActive()){
                        incomes.add(in.getId() + " " + in.getType() + " " + in.getPlace());
                        incomeData.add(in);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

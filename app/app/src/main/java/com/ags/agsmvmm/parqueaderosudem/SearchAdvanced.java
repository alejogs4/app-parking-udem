package com.ags.agsmvmm.parqueaderosudem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.GregorianCalendar;

import Income.Income;

/**
 * Created by USUARIO on 7/03/2018.
 */

public class SearchAdvanced extends AppCompatActivity {

    private int avaibleParkings = 0;
    private int amountDinnerTotalCar = 0;
    private int amountTotalMotorcycle = 0;
    private int cars = 0;
    private int motorcycles = 0;

    private int dinnerDayCars = 0;
    private int dinnerDayMotorCycles = 0;
    private int carsDay = 0;
    private int motorcyclesDay = 0;

    private int dinnerMounthCars = 0;
    private int dinnerMounthMotorcycles = 0;
    private int carsMounth = 0;
    private int motorcyclesMounth = 0;


    private TextView avaibleParkingst;
    private TextView amountDinnerTotalCart;
    private TextView amountTotalMotorcyclet;
    private TextView carst;
    private TextView motorcyclest;
    private TextView dinnerDayCarst;
    private TextView dinnerDayMotorCyclest;
    private TextView carsDayt;
    private TextView motorcyclesDayt;
    private TextView dinnerMounthCarst;
    private TextView dinnerMounthMotorcyclest;
    private TextView carsMountht;
    private TextView motorcyclesMountht;

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.search_advanced);
        connect();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    Income in = data.getValue(Income.class);
                    if(in.isActive()) {
                        avaibleParkings++;
                        amountDinnerTotalCar = isACar(in.getType()) ?  amountDinnerTotalCar + in.getPrice() : amountDinnerTotalCar;
                        amountTotalMotorcycle = isAMotorcycle(in.getType()) ? amountTotalMotorcycle + in.getPrice() : amountTotalMotorcycle;
                        cars =  isACar(in.getType()) ?  cars + 1 : cars;
                        motorcycles = isAMotorcycle(in.getType()) ? motorcycles + 1 : motorcyclesDay;
                        calculateDataByDay(in);
                        calculateDataByMounth(in);
                    }
                }
                showData();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void calculateDataByDay(Income income) {
        String incomeDate[] = income.getDate().split(" ");
        String day = incomeDate[0];
        String dayDate = incomeDate[2];

        Calendar c = new GregorianCalendar();
        String currentDate[] = c.getTime().toString().split(" ");
        String currentDay = currentDate[0];
        String currentDayDate = currentDate[2];
        if(day.equals(currentDay) && dayDate.equals(currentDayDate)) {
            dinnerDayCars =  isACar(income.getType()) ?  dinnerDayCars + income.getPrice() : dinnerDayCars;
            dinnerDayMotorCycles =  isAMotorcycle(income.getType()) ? dinnerDayMotorCycles + income.getPrice() : dinnerDayMotorCycles;
            carsDay =  isACar(income.getType()) ?  carsDay + 1 : carsDay;
            motorcyclesDay = isAMotorcycle(income.getType()) ? motorcyclesDay + 1 : motorcyclesDay;
        }
    }

    private void calculateDataByMounth(Income income) {
        String incomeDate[] = income.getDate().split(" ");
        String mounth = incomeDate[1];

        Calendar c = new GregorianCalendar();
        String currentDate[] = c.getTime().toString().split(" ");
        String currentMonth = currentDate[1];
        if(mounth.equals(currentMonth)) {
            dinnerMounthCars =  isACar(income.getType()) ? dinnerMounthCars + income.getPrice() : dinnerMounthCars;
            dinnerMounthMotorcycles = isAMotorcycle(income.getType()) ? dinnerMounthMotorcycles + income.getPrice() : dinnerMounthMotorcycles;
            carsMounth =  isACar(income.getType()) ? carsMounth + 1 : carsMounth;
            motorcyclesMounth = isAMotorcycle(income.getType()) ? motorcyclesMounth + 1 : motorcyclesMounth;
        }
    }

    private boolean isACar(String type) {
        return type.equals("Carro");
    }

    private boolean isAMotorcycle(String type) {
        return type.equals("Moto");
    }

    private void showData() {
        avaibleParkingst.setText(avaibleParkingst.getText().toString() + ":" + (800 - avaibleParkings));
        amountDinnerTotalCart.setText(amountDinnerTotalCart.getText().toString() + ":" + amountDinnerTotalCar);
        amountTotalMotorcyclet.setText(amountTotalMotorcyclet.getText().toString() + ":" + amountTotalMotorcycle);
        carst.setText(carst.getText().toString() + ":" + cars);
        motorcyclest.setText(motorcyclest.getText().toString() + ":" + motorcycles);
        dinnerDayCarst.setText(dinnerDayCarst.getText().toString() + ":" + dinnerDayCars);
        dinnerDayMotorCyclest.setText(dinnerDayMotorCyclest.getText().toString() + ":" + dinnerDayMotorCycles);
        carsDayt.setText(carsDayt.getText().toString() + ":" + carsDay);
        motorcyclesDayt.setText(motorcyclesDayt.getText().toString() + ":" + motorcyclesDay);
        dinnerMounthCarst.setText(dinnerMounthCarst.getText().toString() + ":" + dinnerMounthCars);
        dinnerMounthMotorcyclest.setText(dinnerMounthMotorcyclest.getText().toString() + ":" + dinnerMounthMotorcycles);
        carsMountht.setText(carsMountht.getText().toString() + ":" + carsMounth);
        motorcyclesMountht.setText(motorcyclesMountht.getText().toString() + ":" + motorcyclesMounth);
    }

    private void connect() {
        avaibleParkingst = (TextView) findViewById(R.id.txt_amount);
        amountDinnerTotalCart = (TextView) findViewById(R.id.txt_amount_cars_dinner);
        amountTotalMotorcyclet = (TextView) findViewById(R.id.txt_amount_motos_dinner);
        carst = (TextView) findViewById(R.id.txt_amount_cars);
        motorcyclest = (TextView) findViewById(R.id.txt_amount_motos);
        dinnerDayCarst = (TextView) findViewById(R.id.txt_amount_cars_dinner_day);
        dinnerDayMotorCyclest = (TextView) findViewById(R.id.txt_amount_motos_dinner_day);
        carsDayt = (TextView) findViewById(R.id.txt_amount_carros_day);
        motorcyclesDayt = (TextView) findViewById(R.id.txt_amount_motos_day);
        dinnerMounthCarst = (TextView) findViewById(R.id.txt_amount_carros_dinner_mounth);
        dinnerMounthMotorcyclest = (TextView) findViewById(R.id.txt_amount_motos_dinner_mounth);
        carsMountht = (TextView) findViewById(R.id.txt_amount_carros_mounth);
        motorcyclesMountht = (TextView) findViewById(R.id.txt_amount_motos_mounth);
    }
}

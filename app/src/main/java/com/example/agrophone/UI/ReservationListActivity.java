package com.example.agrophone.UI;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReservationListActivity extends AppCompatActivity {
    /*
    date_assignment ImageView (calendar), show_all_date Button,  date_selection TextView
    type Spinner, region Spinner, reservation_list RecyclerView
     */
    private ImageView dateAssignment;
    private Button showAllDate;
    private TextView dateSelection;
    private Spinner type;
    private Spinner region;
    private RecyclerView reservationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_list);

        dateAssignment = findViewById(R.id.date_assignment);
        dateAssignment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                chooseDateTimeDialog(dateSelection);
            }
        });
        showAllDate = findViewById(R.id.show_all_date);
        dateSelection = findViewById(R.id.date_selection);
        type = findViewById(R.id.type);
        region = findViewById(R.id.Region);
        reservationList = findViewById(R.id.reservation_list);
    }

    private void chooseDateTimeDialog(TextView etDate) {
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MM.yyyy");

                etDate.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(ReservationListActivity.this,setListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        //mettre que ceux correspondant à la date, dont le client est inscrit
    }

    private void show(){
        dateSelection.setText("");
        //code juste pour recharger toute la recycler view du client
    }
}

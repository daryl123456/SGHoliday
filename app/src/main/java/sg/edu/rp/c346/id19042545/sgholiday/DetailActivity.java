package sg.edu.rp.c346.id19042545.sgholiday;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ListView lv;

    ArrayAdapter aa;
    ArrayList<Holiday> holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        lv = (ListView) this.findViewById(R.id.lv);


        Intent i = getIntent();
        String holiday = i.getStringExtra("holiday");
        ActionBar ab = getSupportActionBar();
        if (ab != null){
            ab.setTitle(holiday);
        }

        holidays = new ArrayList<Holiday>();
        if (holiday.trim().equals("Secular")){
            holidays.add(new Holiday("New Year's Day 1 Jan 2017"));
            holidays.add(new Holiday("Labour Day 1 May 2017"));
        }else{
            holidays.add(new Holiday("Chinese New Year 28-29 Jan 2017"));
            holidays.add(new Holiday("Good Friday 14 April 2017"));
        }
        aa = new HolidayAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Holiday selectedHoliday = holidays.get(i);

                Toast.makeText(DetailActivity.this,selectedHoliday.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
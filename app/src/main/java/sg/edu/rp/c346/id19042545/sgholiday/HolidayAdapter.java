package sg.edu.rp.c346.id19042545.sgholiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private Context context;
    private ArrayList<Holiday> holiday;
    private TextView tv;
    private ImageView iv;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv = (TextView) rowView.findViewById(R.id.textView);
        // Get the ImageView object
        iv = (ImageView) rowView.findViewById(R.id.imageView);
        String currentHoliday = holiday.get(position).getName();
        tv.setText(holiday.get(position).getName());

        if (currentHoliday.equals( "New Year's Day 1 Jan 2017")){
            iv.setImageResource(R.drawable.newyear);
        }else if (currentHoliday.equals("Labour Day 1 May 2017")){
            iv.setImageResource(R.drawable.labourday);
        }else if (currentHoliday.equals("Chinese New Year 28-29 Jan 2017")){
            iv.setImageResource(R.drawable.chinese);
        }else{
            iv.setImageResource(R.drawable.goodfriday);
        }

        return rowView;
    }
}

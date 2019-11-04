package edu.socialmedia.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Topic extends AppCompatActivity {
    public static final String EXTRA_CATEGORY = "edu.socialmedia.todolist.CATEGORY";
    public static final String EXTRA_DATE = "edu.socialmedia.todolist.DATE";
    public static final String EXTRA_TIMESPAN = "edu.socialmedia.todolist.TIMESPAN";
    DatePickerDialog.OnDateSetListener mSetListener;
    private TextView mTxtDate;
    private static final String[] listCategory = new String[]{"Default", "Personal", "shopping", "Wishlist", "computer Programming", "work"};
    private AutoCompleteTextView mAcCategory;
    private Spinner mTimeSpanSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

       autofill();
       date();


    }
    public void date(){
        mTxtDate = findViewById(R.id.txv_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        mTxtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Topic.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month +1;
                        String date = day+"/"+month+"/"+year;
                        mTxtDate.setText(date);


                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });

    }

    public void autofill(){
        mAcCategory = findViewById(R.id.actv_category_topic);
        final ImageButton imgCategory = findViewById(R.id.img_cat_dropdown);
        mAcCategory.setThreshold(2);

        ArrayAdapter<String> catAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, listCategory);
        mAcCategory.setAdapter(catAdapter);

        imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAcCategory.showDropDown();

            }
        });

    }

    public void createTopic(View view){
        Intent intent = new Intent(this, TodoList.class);
        //put extra category
        mAcCategory = findViewById(R.id.actv_category_topic);
        String acCatMsg = mAcCategory.getText().toString();
        intent.putExtra(EXTRA_CATEGORY, acCatMsg);
        //get extra date
        mTxtDate = findViewById(R.id.txv_date);
        String txtDate = mTxtDate.getText().toString();
        intent.putExtra(EXTRA_DATE, txtDate);
        //get extra timepan
        mTimeSpanSpinner = findViewById(R.id.spinner_timespan);
        String timeSpanSpinner = mTimeSpanSpinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_TIMESPAN, timeSpanSpinner);




        startActivity(intent);


    }
}

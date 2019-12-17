package edu.socialmedia.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtask);

        getXtrafromTopic();

    }
    public void getXtrafromTopic(){
        Intent intent = getIntent();
        //get extra date
        String txtDate = intent.getStringExtra(Topic.EXTRA_DATE);
        TextView txtDatemsg = findViewById(R.id.txtview_date);
        if (!txtDate.equals(getString(R.string.select_date_of_reminder))){
        txtDatemsg.setText(String.format("%s%s", txtDate, getString(R.string.comma)));
        }

        //get extra category
        String acCatMsg = intent.getStringExtra(Topic.EXTRA_CATEGORY);
        TextView actvCatMsg = findViewById(R.id.actv_category_topic);
        if(!acCatMsg.equals("")){
        actvCatMsg.setText(acCatMsg);
       }
        //get extra timespan
        String timeSpanspinner = intent.getStringExtra(Topic.EXTRA_TIMESPAN);
        TextView timeSpanSpinnerTodolist = findViewById(R.id.spinner_timespan_topic);
        timeSpanSpinnerTodolist.setText(timeSpanspinner);

    }
}

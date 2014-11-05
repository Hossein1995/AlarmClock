package com.soft.myalarm;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class SetAlarmActivity extends Activity
{
	TimePicker tp;
	EditText title;
	String name;
	Switch repeat;
	boolean is_repeat = false;
	Switch start;
	boolean is_start = true;

	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setalarm);

		// Get title
		title = (EditText) findViewById(R.id.setalarmname);
		// Get repeat switch button
		repeat = (Switch) findViewById(R.id.repeat);
		repeat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
											 boolean isChecked)
				{
					is_repeat = isChecked;
					// Toast.makeText(SetAlarmActivity.this, isChecked + "",Toast.LENGTH_SHORT).show();
				}
			});
		// Get start switch button
		start = (Switch) findViewById(R.id.startalarm);
        start.setChecked(true);
		start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
											 boolean isChecked)
				{
					is_start = isChecked;
				}
			});
		// Get TimePicker
		tp = (TimePicker) findViewById(R.id.setalarmTimePicker1);
		tp.setIs24HourView(true);
	}

	// Buttons
	public void onCancelClick(View v)
	{
		finish();
	}
	public void onSaveClick(View v)
	{
		// Send Broadcast
		Intent bintent = new Intent(SetAlarmActivity.this, AlarmReceiver.class);
		bintent.setAction("true");
		PendingIntent pintent = PendingIntent.getBroadcast(
			SetAlarmActivity.this, 0, bintent, 0);

		// Set Time
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		Date date = new Date(System.currentTimeMillis());
		cal.set(date.getYear() + 1900, date.getMonth(), date.getDate(),
				tp.getCurrentHour(), tp.getCurrentMinute(), 0);

		// Set AlarmManager
		if (is_start)
		{
		AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
		if (is_repeat)
		{
			// unfinished
			// alarm.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5*1000,pintent);
		}
		else
		{
			alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pintent);
		}

		// Setted info
		name = title.getText().toString();
		if (name.length() == 0)
			name = "AlarmClock";
		Toast.makeText(this, name + " is setted\n", Toast.LENGTH_SHORT).show();
		}
		
		else
		{
			name = title.getText().toString();
			if (name.length() == 0)
				name = "AlarmClock";
			Toast.makeText(this, name + " is saved\n", Toast.LENGTH_SHORT).show();
		}
		
		// Close
		finish();
	}
}

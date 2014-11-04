package com.soft.myalarm;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;

class my_alarm
{
	private String name;
	private String time;
	
	my_alarm()
	{
		name = "Alarm";
		time = "12 : 00";
	}

	public String getInfo()
	{
		return name + "    " + time;
	}
}

public class MainActivity extends Activity
{
	// List
	List alarms = new ArrayList();
	my_alarm a1 = new my_alarm();
	my_alarm a2 = new my_alarm();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		// Alarm List
		alarms.add(a1.getInfo());
		alarms.add(a2.getInfo());
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alarms);
		ListView listView = (ListView) findViewById(R.id.mainListView1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener()
			{

				@Override
				public void onItemClick(AdapterView<?> l, View v, int position, long id)
				{
					String s = (String)l.getItemAtPosition(position);
					Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
				}
			});
		
		
    }
	// Send Broadcast
	public void send(View v)
	{
		Intent intent = new Intent("android.intent.action.Alarm");
		intent.putExtra("alarm", "start");
		sendBroadcast(intent);
	}

	// Menu Options
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate main_menu.xml 
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.mainMenuNew:
				Intent intent = new Intent(this, SetAlarmActivity.class);
				startActivity(intent);
				return true;
			case R.id.mainMenuAbout:
				Toast.makeText(this, "Name: MyAlarm\nVer: 1.0\nCoder: KJTang", Toast.LENGTH_LONG).show();
				return true;
			case R.id.mainMenuExit:
				finish();
		}
		return super.onOptionsItemSelected(item);
	}
}

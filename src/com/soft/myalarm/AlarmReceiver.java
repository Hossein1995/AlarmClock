package com.soft.myalarm;

import android.content.*;
import android.widget.*;

public class AlarmReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		// 我能说这一段完全是抄的咩？？
		if (intent.getAction().equals("true"))
		{
			// Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
			Intent alarm = new Intent(context, AlarmActivity.class);
			alarm.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(alarm);
		}
	}
}

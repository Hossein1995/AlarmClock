package com.soft.myalarm;

import android.app.*;
import android.content.*;
import android.os.*;

public class AlarmActivity extends Activity
{
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
		
		MyDialogFragment f = new MyDialogFragment();
		f.show(getFragmentManager(), "Alarm");
	}
}

// Dialog
class MyDialogFragment extends DialogFragment
{
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("AlarmClock");
		builder.setMessage("It's Time!!");
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					// TODO: Implement this method
				}
			});

		return builder.create();
	}

}

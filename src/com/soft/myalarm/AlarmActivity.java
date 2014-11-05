package com.soft.myalarm;

import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;
import android.widget.Toast;

import java.io.*;

public class AlarmActivity extends Activity
{
//    public MediaPlayer player = null;
    public MediaPlayer mp = null;
    private static final String MUSIC_PATH = new String("/sdcard/");

	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
		
		// Dialog
		AlertDialog ring = new AlertDialog.Builder(this).create();
		ring.setTitle("AlarmClock");
		ring.setMessage("It's Time!!");
		ring.setButton("GET", listener);
		ring.show();

//		player = new MediaPlayer();
//		try
//		{
//			player.reset();
//			player.setDataSource(MUSIC_PATH + "test.mp3");
//			player.prepare();
//			player.start();
//		}
//		catch (SecurityException e)
//		{
//            Toast.makeText(this, "Security", Toast.LENGTH_SHORT).show();
//		}
//		catch (IOException e)
//		{
//            Toast.makeText(this, "IO", Toast.LENGTH_SHORT).show();
//        }
//		catch (IllegalArgumentException e)
//		{
//            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
//        }
//		catch (IllegalStateException e)
//		{
//            Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
//        }

        // Ringtone
        mp = MediaPlayer.create(this, R.raw.test);
        mp.start();
	}
	
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
	{
		@Override
		public void onClick(DialogInterface p1, int button)
		{
			// TODO: Implement this method
			switch(button)
			{
				case AlertDialog.BUTTON_POSITIVE:
					mp.stop();
                    mp.release();
					finish();
					break;
				default:
					break;
			}
		}
	};
}

package com.GCM.gcmtestsample;

import static com.GCM.gcmtestsample.CommonUtilities.SENDER_ID;
import com.google.android.gcm.GCMRegistrar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class GcmActivity extends Activity {
	private static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gcm);
		GcmActivity.context = getApplicationContext();
		TextView txt = (TextView) findViewById(R.id.textView2);
		String regId= GCM();
		Log.d("RegId", regId);
		txt.setText(regId);
	}
	public static Context getAppContext() {
        return GcmActivity.context;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gcm, menu);
		return true;
	}
	public static String GCM() {
		String result=null;
		// TODO Auto-generated method stub
		String regId = GCMRegistrar.getRegistrationId(getAppContext());
		 if (!regId.equals("")) {
		    } else {
		    GCMRegistrar.register(getAppContext(),SENDER_ID);
		    regId = GCMRegistrar.getRegistrationId(getAppContext());
		    if (!regId.equals("")) {
		    try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		    }
		 
		return regId;

	}

}

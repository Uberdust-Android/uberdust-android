/*
 * Copyright (C) 2011 Wglxy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.uberdust.mobileclient;

import net.londatiga.fsq.FoursquareApp;
import net.londatiga.fsq.FoursquareApp.FsqAuthListener;
import net.londatiga.fsq.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the activity for feature 5 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */



public class FourSquareActivity extends DashboardActivity 
{

/**
 * onCreate
 *
 * Called when the activity is first created. 
 * This is where you should do all of your normal static set up: create views, bind data to lists, etc. 
 * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
 * 
 * Always followed by onStart().
 *
 * @param savedInstanceState Bundle
 */
	
	
	//Foursquare variables
	private FoursquareApp mFsqApp;
	private ProgressDialog mProgress;
	TextView nameTv;
	
	public static final String VENEUEID = "4ec2ad3877c887a3c79c339b";
	public static final String SHOUT = "I am at Pspace!!!";
	
	
	public static final String CLIENT_ID = "LNFM5FKJS3WWNHSJDKGACIXUZVC22KX1PFVXJ1U4T20WZWD1";
	public static final String CLIENT_SECRET = "LTDGM44SWMR3RGKJXYFXCHSGOTFSLIJ14JRQVSVDQAPVCA32";
	

protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_foursquare);
    setTitleFromActivityLabel (R.id.title_text);
    
    nameTv = (TextView) findViewById(R.id.textView1);
    
    final Button button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            foursquare();
        }
    });
    
    
    /*IntentIntegrator integrator = new IntentIntegrator(FourSquareActivity.this);
    integrator.initiateScan();*/
    
}

/*public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
	  if (scanResult != null) {
	    // handle scan result
		Log.d("MINE", "SUCCESS");
	  }
	  // else continue with any other code you need in the method
	  Log.d("MINE", "NEXT");
	}*/


public void foursquare(){
	
	 
	mFsqApp = new FoursquareApp(this, CLIENT_ID, CLIENT_SECRET);
	mProgress		= new ProgressDialog(this);
    mProgress.setMessage("Loading data ...");
    
    if (mFsqApp.hasAccessToken()) nameTv.setText("Connected as " + mFsqApp.getUserName());
    
    FsqAuthListener listener = new FsqAuthListener() {
    	public void onSuccess() {
    		Toast.makeText(FourSquareActivity.this, "Connected as " + mFsqApp.getUserName(), Toast.LENGTH_SHORT).show();
    		nameTv.setText("Connected as " + mFsqApp.getUserName());
    	}
    	
    	public void onFail(String error) {
    		Toast.makeText(FourSquareActivity.this, error, Toast.LENGTH_SHORT).show();
    	}
    };
    
    mFsqApp.setListener(listener);
    mFsqApp.authorize();

}

} // end class

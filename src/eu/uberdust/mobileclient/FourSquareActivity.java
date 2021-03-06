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

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

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
	
	
	

protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_foursquare);
    setTitleFromActivityLabel (R.id.title_text);
    
    
    final Button button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	IntentIntegrator integrator = new IntentIntegrator(FourSquareActivity.this);
        	integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);

        }
    });
    
    
   
    
}

public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    if (result != null) {
      String contents = result.getContents();
      if (contents != null) {
        Log.d("SCAN",contents);
      } else {
    	  Log.d("SCAN","FAIL");
      }
    }
  }




} // end class

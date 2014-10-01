package com.example.smartmonthly;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.PushService;


public class MainActivity extends Activity implements OnClickListener {
	
	public static Button btnAgree;	
	public static Button btnUseTerms;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	    //Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
		//////// --- Parse --- //////// 
		
		 Parse.initialize(this, "fhHO52FVB8WVcf6svKERvHsCcksvLePiJnKwezDg", "lJ0xVnkmBKckHhETmceSEnmUFzzHFiWwpb2vr8vC");
		 PushService.setDefaultPushCallback(this, MainActivity.class);
		 
		 
		 //ParseObject object = ParseObject.createWithoutData("GameScore", "FPn4vFFfia");
		 ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Vertical");
		 query.whereEqualTo("Active", 1);
		 query.orderByAscending("Order");
		 query.findInBackground(new FindCallback<ParseObject>() {
			 public void done(List<ParseObject> arg0, ParseException e) 
			 {
				 if (e == null) 
				 {
					 objectsWereRetrievedSuccessfully(arg0);
					 // Success!
				 } else {
					 // Failure!
				 }
			 }
		 });
			 

		 

//		 object.fetchInBackground(new GetCallback<ParseObject>() {
//			  public void done(ParseObject object, ParseException e) {
//			    if (e == null) {
//			      // Success!
//			    } else {
//			      // Failure!
//			    }
//			  }
//			});
		 
//		 ParseObject gameScore = new ParseObject("GameScore");
//		 gameScore.put("score", 1337);
//		 gameScore.put("playerName", "Alon Rom");
//		 gameScore.put("cheatMode", false);
//		 gameScore.saveInBackground();

		 
		 ///
//		 [Parse setApplicationId:@"fhHO52FVB8WVcf6svKERvHsCcksvLePiJnKwezDg" clientKey:@"lJ0xVnkmBKckHhETmceSEnmUFzzHFiWwpb2vr8vC"];
//		 
		 //
		 	 		 
//		 ParseObject object = ParseObject.createWithoutData("GameScore", "FPn4vFFfia");
//		 object.fetchInBackground(new GetCallback<ParseObject>() {
//			  public void done(ParseObject object, ParseException e) {
//			    if (e == null) {
//			      // Success!
//			    } else {
//			      // Failure!
//			    }
//			  }
//			});
//		
//		 String objectId = object.getObjectId();
//		 Toast.makeText(getApplicationContext(), objectId, Toast.LENGTH_LONG).show();


		 		  	
		 
	 	//////// --- Parse --- //////// 
	}
		


	protected void objectsWereRetrievedSuccessfully(List<ParseObject> arg0) 
	{
		//load the tables (like appDelegate)				
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_main, container, false);
			
			btnAgree = (Button)rootView.findViewById(R.id.Agree);
			btnUseTerms = (Button)rootView.findViewById(R.id.UseTerms);
			return rootView;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
    public void onClick(View v) {
   
            switch (v.getId()) 
            {
	           
	            case R.id.Agree:
	            	Intent homeIntent = new Intent(this, HomeActivity.class);
	            	this.startActivity(homeIntent);
	            	break;
	            	
	            case R.id.UseTerms:
	            	//Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
	            	Intent mainScreenIntent = new Intent(this, MainScreenActivity.class);
	            	this.startActivity(mainScreenIntent);
	            	break;
   
            }
    }


}

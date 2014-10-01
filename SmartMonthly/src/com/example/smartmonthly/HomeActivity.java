package com.example.smartmonthly;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class HomeActivity extends Activity {
	
	  private DrawerLayout mDrawerLayout;
      private ListView mDrawerList;
      private ActionBarDrawerToggle mDrawerToggle;
 
      private CharSequence mDrawerTitle;
      private CharSequence mTitle;
      CustomDrawerAdapter adapter;
 
      List<HomeDrawer> dataList;	
      
      private PopupWindow detailsPopUp;
      public static TextView closePopUp;
      
      public static int currentPosition = -1;
           
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		  // Initializing
        dataList = new ArrayList<HomeDrawer>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                    GravityCompat.START);
        
        // Add Drawer Item to dataList
        // Add Drawer Item to dataList
       
        dataList.add(new HomeDrawer(getResources().getString(R.string.HomeFragment_header)));
        dataList.add(new HomeDrawer(getResources().getString(R.string.StandarizationFragment_header)));
        dataList.add(new HomeDrawer(getResources().getString(R.string.TalkToUsFragment_header)));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
        dataList.add(new HomeDrawer(""));
               
        adapter = new CustomDrawerAdapter(this, R.layout.home_drawer,
                dataList);

        mDrawerList.setAdapter(adapter);
        
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
         
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                    R.drawable.ic_drawer, R.string.drawer_open,
                    R.string.drawer_close) {
              public void onDrawerClosed(View view) {
                    getActionBar().setTitle(mTitle);
                    invalidateOptionsMenu(); // creates call to
                                                              // onPrepareOptionsMenu()
              }
         
              public void onDrawerOpened(View drawerView) {
                    getActionBar().setTitle(mDrawerTitle);
                    invalidateOptionsMenu(); // creates call to
                                                              // onPrepareOptionsMenu()
              }
        };
         
        mDrawerLayout.setDrawerListener(mDrawerToggle);
         
        if (savedInstanceState == null) {
        	  currentPosition = 0;
              SelectItem(0);
        }
	}
	
	public void SelectItem(int possition) {
		 
        Fragment fragment = null;
        currentPosition = possition;
        Bundle args = new Bundle();
        switch (possition) {
        case 0:
              fragment = new FragmentHome();
              args.putString(FragmentHome.ITEM_NAME, dataList.get(possition)
                          .getItemName());                
              break;
        case 1:
              fragment = new FragmentStandarization();
              args.putString(FragmentStandarization.ITEM_NAME, dataList.get(possition)
                          .getItemName());
              break;
        case 2:
              fragment = new FragmentTalkToUs();
              args.putString(FragmentTalkToUs.ITEM_NAME, dataList.get(possition)
                          .getItemName());
              break;
        case 3:
              fragment = new FragmentHome2();
              args.putString(FragmentHome2.ITEM_NAME, dataList.get(possition)
                          .getItemName());
            break;
        case 4:
              fragment = new FragmentHome3();
              args.putString(FragmentHome3.ITEM_NAME, dataList.get(possition)
                          .getItemName());
            break;
        case 5:
              fragment = new FragmentHome4();
              args.putString(FragmentHome4.ITEM_NAME, dataList.get(possition)
                          .getItemName());
            break;
        case 6:
            fragment = new FragmentHome5();
            args.putString(FragmentHome5.ITEM_NAME, dataList.get(possition)
                        .getItemName());
          break;
        case 7:
            fragment = new FragmentHome6();
            args.putString(FragmentHome6.ITEM_NAME, dataList.get(possition)
                        .getItemName());
          break;
        case 8:
            fragment = new FragmentHome7();
            args.putString(FragmentHome7.ITEM_NAME, dataList.get(possition)
                        .getItemName());
          break;
        case 9:
            fragment = new FragmentHome8();
            args.putString(FragmentHome8.ITEM_NAME, dataList.get(possition)
                        .getItemName());
          break;
        case 10:
            fragment = new FragmentHome9();
            args.putString(FragmentHome9.ITEM_NAME, dataList.get(possition)
                        .getItemName());
          break;
        default:
              break;
        }
        

        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();

        mDrawerList.setItemChecked(possition, true);
        setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

	}
	
	@Override
	public void setTitle(CharSequence title) {
	      mTitle = title;
	      getActionBar().setTitle(mTitle);	      	 
	}
	 
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
	      super.onPostCreate(savedInstanceState);
	      // Sync the toggle state after onRestoreInstanceState has occurred.
	      mDrawerToggle.syncState();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	      // The action bar home/up action should open or close the drawer.
	      // ActionBarDrawerToggle will take care of this.
	      if (mDrawerToggle.onOptionsItemSelected(item)) {
	            return true;
	      }	   
	      
	      switch(currentPosition)
	      {
	      	case 3:
	      		SelectItem(0);//go back to main
	      		return true;
	    	case 4:
	    	case 5:
	    	case 6:
	    	case 7:
	    	case 8:
	    	case 9:
	    	case 10:
    		    SelectItem(currentPosition-1);//go back
	      		return true;	      			      
	      }

        return false;
	}
	 
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	      super.onConfigurationChanged(newConfig);
	      // Pass any configuration change to the drawer toggles
	      mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	private class DrawerItemClickListener implements
    ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
		          long id) {
			currentPosition = position;
		    SelectItem(position);
		
		}
	}
	
	public void getDetailsPopUp()
	{
		try
		{
			LayoutInflater layoutInflater = (LayoutInflater)HomeActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = layoutInflater.inflate(R.layout.details_popup, (ViewGroup)null, false);
			detailsPopUp = new PopupWindow(layout, 450, 650, true);
			detailsPopUp.showAtLocation(layout, Gravity.CENTER, 0, 50);
			
			closePopUp = (TextView)layout.findViewById(R.id.closePopUp);
			closePopUp.setOnClickListener(button_cancel);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}      

	private OnClickListener button_cancel = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			detailsPopUp.dismiss();
		}
	};
		
	

}

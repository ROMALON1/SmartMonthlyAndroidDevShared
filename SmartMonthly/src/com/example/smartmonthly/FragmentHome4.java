package com.example.smartmonthly;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FragmentHome4 extends Fragment implements OnClickListener{
 

	  public static Button callAbroad;
	  public static Button doesntMatter;
      public static final String IMAGE_RESOURCE_ID = "iconResourceID";
      public static final String ITEM_NAME = "itemName";
 
      public FragmentHome4() {
 
      }
 
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
 
            View v = inflater.inflate(R.layout.home4_fragment, container, false);
            
            callAbroad = (Button) v.findViewById(R.id.callAbroad);
            callAbroad.setOnClickListener(this);
            
            doesntMatter = (Button) v.findViewById(R.id.doesntMatter);
            doesntMatter.setOnClickListener(this);
            
            return v;
      }
           
      @Override
      public void onClick(View v) {
     
              switch (v.getId()) 
              {	           
  	            case R.id.callAbroad:  
  	            case R.id.doesntMatter: 
  	            	((HomeActivity)getActivity()).SelectItem(6); //show next fragment in his position
  	            	break;    
              }
      }
      
}
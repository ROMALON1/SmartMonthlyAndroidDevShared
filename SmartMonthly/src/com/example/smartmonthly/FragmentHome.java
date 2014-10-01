package com.example.smartmonthly;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FragmentHome extends Fragment implements OnClickListener{
 

	  public static Button next;
      public static final String IMAGE_RESOURCE_ID = "iconResourceID";
      public static final String ITEM_NAME = "itemName";
 
      public FragmentHome() {
 
      }
 
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
 
            View v = inflater.inflate(R.layout.home_fragment, container, false);
            next = (Button) v.findViewById(R.id.next);
            next.setOnClickListener(this);
            return v;
      }
           
      @Override
      public void onClick(View v) {
     
              switch (v.getId()) 
              {	           
  	            case R.id.next:  		            	
  	            	((HomeActivity)getActivity()).SelectItem(3); //show next fragment in his position
  	            	break;    
              }
      }
      
}
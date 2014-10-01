package com.example.smartmonthly;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class FragmentHome2 extends Fragment implements OnClickListener{
 
	  public static Button doesntMattaer;
	  public static Button otherOperator;
	  public static Button otherCompany;
      public static final String IMAGE_RESOURCE_ID = "iconResourceID";
      public static final String ITEM_NAME = "itemName";
 
      public FragmentHome2() {
 
      }
 
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
 
            View v = inflater.inflate(R.layout.home2_fragment, container, false);

            doesntMattaer = (Button) v.findViewById(R.id.doesntMattaer);
            doesntMattaer.setOnClickListener(this);
            
            otherOperator = (Button) v.findViewById(R.id.otherOperator);
            otherOperator.setOnClickListener(this);
            
            otherCompany = (Button) v.findViewById(R.id.otherCompany);
            otherCompany.setOnClickListener(this);
            
            return v;
            
      }
           
      
      @Override
      public void onClick(View v) {
     
              switch (v.getId()) 
              {	           
  	            case R.id.doesntMattaer:
  	            case R.id.otherOperator:
  	            case R.id.otherCompany:
  	            	((HomeActivity)getActivity()).SelectItem(4); //show next fragment in his position
  	            	break;    
              }
      }
      
}
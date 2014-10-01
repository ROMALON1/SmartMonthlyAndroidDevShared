package com.example.smartmonthly;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class FragmentHome3 extends Fragment implements OnClickListener{
 
	  public static Button personalProgram;
	  public static Button familyProgram;
      public static final String IMAGE_RESOURCE_ID = "iconResourceID";
      public static final String ITEM_NAME = "itemName";
 
      public FragmentHome3() {
 
      }
 
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
 
            View v = inflater.inflate(R.layout.home3_fragment, container, false);
            
            personalProgram = (Button) v.findViewById(R.id.personalProgram);
            personalProgram.setOnClickListener(this);
            
            familyProgram = (Button) v.findViewById(R.id.familyProgram);
            familyProgram.setOnClickListener(this);

            return v;
      }
           
      @Override
      public void onClick(View v) {
    	     switch (v.getId()) 
             {	           
 	            case R.id.personalProgram:
 	            case R.id.familyProgram:
 	            	((HomeActivity)getActivity()).SelectItem(5); //show next fragment in his position
 	            	break;    
             }

      }
      
}
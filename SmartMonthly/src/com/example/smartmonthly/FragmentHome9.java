package com.example.smartmonthly;

import java.util.Calendar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentHome9 extends Fragment{
 
      public static final String IMAGE_RESOURCE_ID = "iconResourceID";
      public static final String ITEM_NAME = "itemName";
 
      public static TextView tvDisplayDate;
      public static int yy;
      public static int mm;
      public static int dd;
      
      public FragmentHome9() {
 
      }
 
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
 
            View v = inflater.inflate(R.layout.home9_fragment, container, false);
            
            //show today date
            tvDisplayDate = (TextView) v.findViewById(R.id.tvDate);
            final Calendar c = Calendar.getInstance();
            yy = c.get(Calendar.YEAR);
            mm = c.get(Calendar.MONTH);
            dd = c.get(Calendar.DAY_OF_MONTH);

            // set current date into textview
            tvDisplayDate.setText(new StringBuilder()
            // Month is 0 based, just add 1
                    .append(dd).append(".").append(mm + 1).append(".")
                    .append(yy));
            
            return v;
      }

}
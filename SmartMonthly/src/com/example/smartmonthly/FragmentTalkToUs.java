package com.example.smartmonthly;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FragmentTalkToUs extends Fragment implements OnClickListener{

	 public static Button btnLink;
     public static final String IMAGE_RESOURCE_ID = "iconResourceID";
     public static final String ITEM_NAME = "itemName";

     public FragmentTalkToUs() {

     }

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.talktous_fragment, container, false);

         Button btnLink = (Button) v.findViewById(R.id.btnLink);
         btnLink.setOnClickListener(this);
         return v;
     }
     
     @Override
     public void onClick(View v) {
    
             switch (v.getId()) 
             {	           
 	            case R.id.btnLink:
 	            	Uri uri = Uri.parse("http://info@smartmonthly.co.il");
 	            	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
 	            	startActivity(intent);
 	            	break;    
             }
     }

}
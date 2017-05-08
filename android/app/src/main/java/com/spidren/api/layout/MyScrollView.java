package com.spidren.api.layout;

import android.content.Context;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView{
	
	MyLayoutParms parms;
	
	public MyScrollView(Context context) {
		super(context);
		
		
	}
	
	public MyScrollView(Context context,int type,int width,int height,int x,int y){
		super(context);
		
		parms = new MyLayoutParms(type, width, height, x, y);
		setLayoutParams(parms.getParams());
	}
	
}

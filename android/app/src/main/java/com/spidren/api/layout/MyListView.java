package com.spidren.api.layout;

import android.content.Context;
import android.widget.ListView;

public class MyListView extends ListView{
	
	public MyListView(Context context) {
		super(context);
	}
	
	public MyListView(Context context,int type,int width,int height, int x,int y){
		super(context);
		
		setLayoutParams(new MyLayoutParms(type, width, height, x, y).getParams());
	}

}

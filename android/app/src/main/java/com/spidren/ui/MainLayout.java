package com.spidren.ui;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.ui.drawer.MainDrawerLayout;

public class MainLayout extends MyRelativeLayout{

	
	private DrawerLayout drawerLayout;
	
	public MainLayout(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		drawerLayout = new MainDrawerLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		addView(drawerLayout);
	}
}

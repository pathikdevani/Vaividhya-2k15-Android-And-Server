package com.spidren.ui.search;

import android.content.Context;
import android.graphics.Color;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.vaividhya2k15.MainActivity;

public class EventSearchLayout extends MyRelativeLayout{

	private EventSearchTopBar searchtopbar;
	private EvevntSearchResultList serchResultList;
	private int topSize;
	
	
	public EventSearchLayout(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		setBackgroundColor(Color.parseColor("#80000000"));
		topSize = MainActivity.cf.dpix[55];
		
		searchtopbar = new EventSearchTopBar(context, MyLayoutParms.RELATIVE_LAYOUT, width, topSize + MainActivity.cf.dpix[2], 0, 0);
		addView(searchtopbar);
		
		serchResultList = new EvevntSearchResultList(context, MyLayoutParms.RELATIVE_LAYOUT, width, height - topSize, 0, topSize);
		addView(serchResultList);
		
		
		searchtopbar.bringToFront();
		searchtopbar.setOnChangeListener(new EventSearchTopBar.onChangeListener() {
			
			@Override
			public void onChange(String str) {
				serchResultList.setData(str);
			}
		});
	}
}

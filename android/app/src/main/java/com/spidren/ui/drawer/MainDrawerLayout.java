package com.spidren.ui.drawer;

import com.spidren.api.backpress.Back;
import com.spidren.api.backpress.BackTag;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.ui.drawer.menu.MenuLayout;
import com.spidren.vaividhya2k15.MainActivity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

public class MainDrawerLayout extends DrawerLayout{

	private MenuLayout menu;
	private DrawerDataLayout data;
	
	private int temp;
	
	public MainDrawerLayout(final Context context,int type,final int width,final int height,int x,int y) {
		super(context);
		
		setLayoutParams(new MyLayoutParms(type, width, height, x, y).getParams());
		setBackgroundColor(Color.parseColor("#e9eaed"));
		
		
		temp = 0;
		
		data = new DrawerDataLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		addView(data);
		
		menu = new MenuLayout(context, MyLayoutParms.DRAWER_LAYOUT, width - MainActivity.cf.dpix[60], height, 0, 0);
		((DrawerLayout.LayoutParams)menu.getLayoutParams()).gravity = Gravity.LEFT;
		addView(menu);
		
		
		
		
		MainActivity.macros.addMacro(new Macro(MacroTag.DRAWER_OPEN) {
			@Override
			public void run(Object obj) {
				openDrawer(menu);
			}
		});
		
		
		MainActivity.macros.addMacro(new Macro(MacroTag.DRAWER_CLOSE) {
			@Override
			public void run(Object obj) {
				if(obj != null){
					if((int)obj == 1){
						temp = 1;
					}
				}
				closeDrawer(menu);
			}
		});
		
		
		MainActivity.macros.addMacro(new Macro(MacroTag.DRAWER_LOCK) {
			@Override
			public void run(Object obj) {
				setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
			}
		});
		
		
		MainActivity.macros.addMacro(new Macro(MacroTag.DRAWER_UNLOCK) {
			@Override
			public void run(Object obj) {
				setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
			}
		});
		
		
		
		setDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int arg0) {
				
			}
			
			@Override
			public void onDrawerSlide(View arg0, float arg1) {
				
			}
			
			@Override
			public void onDrawerOpened(View arg0) {
				MainActivity.back.addBack(new Back(BackTag.DRAWER) {
					@Override
					public void perform() {
						MainActivity.macros.run(MacroTag.DRAWER_CLOSE);
					}
				});
			}
			
			@Override
			public void onDrawerClosed(View arg0) {
				MainActivity.back.removeBack(BackTag.DRAWER);
				if(temp == 1){
					MainActivity.macros.run(MacroTag.DRAWER_CLOSE_CALLBACK);
					temp = 0;
				}
					
			}
		});
		
	}
	
	@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    	widthMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}

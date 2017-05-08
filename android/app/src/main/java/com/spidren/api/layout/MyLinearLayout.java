package com.spidren.api.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout{

	MyLayoutParms parms;
	
	public MyLinearLayout(Context context) {
		super(context);
		
		init();
	}
	
	public MyLinearLayout(Context context,int type,int width,int height,int x,int y){
		super(context);
		
		parms = new MyLayoutParms(type, width, height, x, y);
		setLayoutParams(parms.getParams());
		
		init();
	}
	
	private void init(){
		setOrientation(LinearLayout.VERTICAL);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			onDown(event);
			break;
			
		case MotionEvent.ACTION_MOVE:
			onMove(event);
			break;
		case MotionEvent.ACTION_OUTSIDE:
			onOut(event);

			break;
		case MotionEvent.ACTION_UP:
			onUp(event);

			break;
		case MotionEvent.ACTION_CANCEL:
			onCancle(event);
			break;
			
		default:
			onleave(event);
		}
		return true;
	}

	public void onCancle(MotionEvent event) {
		
	}

	public void onleave(MotionEvent event) {

	}

	public void onUp(MotionEvent event) {

	}

	public void onClk(View v) {

	}

	public void onOut(MotionEvent event) {

	}

	public void onMove(MotionEvent event) {

	}

	public void onDown(MotionEvent event) {

	}
	
	

}

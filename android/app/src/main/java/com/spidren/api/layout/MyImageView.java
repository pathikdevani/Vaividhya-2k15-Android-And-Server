package com.spidren.api.layout;

import com.spidren.api.ripple.MyRipple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MyImageView extends ImageView{

	private MyRipple ripple;
	MyLayoutParms parms;

	public MyImageView(Context context) {
		super(context);
		
	}
	public MyImageView(Context context,int type, int width, int height, int x,int y){
		super(context);

		parms = new MyLayoutParms(type, width, height, x, y);
		setLayoutParams(parms.getParams());
	}
	

	public void setRipple(boolean isRipple){
		if(isRipple){
			if(ripple == null){
				ripple = new MyRipple(this);
			}
			ripple.setRipple(isRipple);
		}else {
			if(ripple !=null){
				ripple.setRipple(isRipple);
			}
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		if(ripple != null){
			ripple.onDw(canvas);
		}
		super.onDraw(canvas);
	}
	
	public MyRipple getRipple(){
		if(ripple == null){
			ripple = new MyRipple(this);
		}
		return ripple;
	}
	
	

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(ripple != null){
			ripple.onTouchEvent(event);
		}
		return super.onTouchEvent(event);
	}
	
}

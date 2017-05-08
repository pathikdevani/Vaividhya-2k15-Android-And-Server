package com.spidren.api.ripple;


import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class MyRipple {
	
	
	private boolean isRipple;
	//private MyRippleAnimation animation;
	//private boolean isHardwareSupport = MainActivity.cf.SDK_VERSION >= 16 ? true : false;
	private MyTempRipple animation;
	
	public MyRipple(View view){
		//animation = new MyRippleAnimation(view);
		animation = new MyTempRipple(view);
		isRipple = false;
	}
	
	public void onTouchEvent(MotionEvent event){
		if(isRipple){
			animation.onTouchEvent(event);	
		}
	}
	
	public void onDw(Canvas canvas){
		if(isRipple){
			//animation.onDw(canvas);
			animation.onDw(canvas);
		}
	}
	
	public void setAtt(int color,int duration,int alpha,int radius){

		animation.setColor(color);
		if(alpha >= 0)
			animation.setAlpha(alpha);
		if(duration >=  0)
			animation.setDuration(duration);
		if(radius >= 0)
			animation.setCornerRadius(radius);
	}
	
	public void setRipple(boolean isRipple){
		this.isRipple = isRipple;
	}
	
	public void setColor(int color){
		animation.setColor(color);
	}
	
	public void setDuration(int duration){
		animation.setDuration(duration);
	}
	
	public void setAlpha(int alpha){
		animation.setAlpha(alpha);
	}
	
	public void setCornerRadius(int radius){
		animation.setCornerRadius(radius);
	}
	public int getDuration(){
		return animation.getDuration();
	}
}

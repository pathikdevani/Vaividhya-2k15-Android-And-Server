package com.spidren.api.layout;

import com.spidren.api.ripple.MyRipple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
	
	
	private MyLayoutParms parms;
	private MyRipple ripple;
	private boolean isPropogate = false;
	
	public MyView(Context context) {
		super(context);
		
		init();
	}
	
	public MyView(Context context, int type, int width, int height, int x,int y) {
		super(context);

		parms = new MyLayoutParms(type, width, height, x, y);
		setLayoutParams(parms.getParams());
		init();
	}
	
	private void init() {
		setClickable(true);
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
	
	public MyRipple getRipple(){
		if(ripple == null){
			ripple = new MyRipple(this);
		}
		return ripple;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		if(ripple != null){
			ripple.onDw(canvas);
		}
		super.onDraw(canvas);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(isPropogate)
			return false;
		
		if(ripple != null){
			ripple.onTouchEvent(event);
		}
		
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
		return super.onTouchEvent(event);
	}

	public void setPropogation(boolean isPropogate){
		this.isPropogate  = isPropogate;
	}
	
	public void onleave(MotionEvent event) {
		
	}

	public void onCancle(MotionEvent event) {
		
	}

	public void onUp(MotionEvent event) {
		
	}

	public void onOut(MotionEvent event) {
		
	}

	public void onMove(MotionEvent event) {
		
	}

	public void onDown(MotionEvent event) {
		
	}

}

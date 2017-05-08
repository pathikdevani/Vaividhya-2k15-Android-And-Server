package com.spidren.api.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.TextView;

import com.spidren.api.ripple.MyRipple;

public class MyTextView extends TextView{

	private MyLayoutParms parms;
	private MyRipple ripple;
	
	
	/*private Typeface typeFace;
	private Context context;*/
	
	public MyTextView(Context context) {
		super(context);
		
		//this.context = context;
		init();
	}
	
	public MyTextView(Context context,int type, int width, int height, int x,int y){
		super(context);

		parms = new MyLayoutParms(type, width, height, x, y);
		setLayoutParams(parms.getParams());
		//this.context = context;
		
		init();
	}
	
	public void init(){
		setTextColor(Color.BLACK);
		/*typeFace = Typeface.createFromAsset(context.getAssets(), "font/segoeui.ttf");
		setTypeface(typeFace);*/
	}
	
	
	
	/*public void setFontType(int type){
		
	}*/
	
	
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

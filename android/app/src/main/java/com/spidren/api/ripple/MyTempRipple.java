package com.spidren.api.ripple;



import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

public class MyTempRipple {
	
	
	private View view;
	
	private int circleAlpha;
	private Paint circlePaint = new Paint();
	
	private RectF rectf = new RectF();
	
	private boolean isAnimatingFadeIn,isTouchReleased;
	
	private int DEFAULT_DURATION = 150;
	private int DEFAULT_ALPHA = 100;
	private int DEFAULT_CORNER_RADIUS = 0 ;
	private int CURRENT_ALPHA;
	private int MIN_ALPHA = 50;
	
	
	public MyTempRipple(View view) {
		this.view = view;
		isAnimatingFadeIn = false;
		isTouchReleased = false;
		
		circlePaint.setColor(Color.BLACK);
	}
	
	
	public int getDuration(){
		return DEFAULT_DURATION;
	}
	
	
	public void setAlpha(int alpha){
		this.DEFAULT_ALPHA = alpha;
		this.MIN_ALPHA = DEFAULT_ALPHA /2;
	}
	public void setDuration(int duration){
		this.DEFAULT_DURATION = duration;
	}
	public void setCornerRadius(int radius){
		this.DEFAULT_CORNER_RADIUS = radius;
	}
	public void setColor(int color){
		circlePaint.setColor(color);
	}
	
	
	private Animation.AnimationListener animationListner = new Animation.AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			isAnimatingFadeIn = true;
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			isAnimatingFadeIn = false;
			if(isTouchReleased){
				fadeOuteffect();
			}else {
				rippleFinishFadeIn();
			}
		}
	};
	
	protected void rippleFinishFadeIn(){
	
	}
	
	public void onTouchEvent(MotionEvent event){
		
		if(event.getAction() == MotionEvent.ACTION_CANCEL){
			isTouchReleased = true;
			if(!isAnimatingFadeIn){
				fadeOuteffect();
			}
		}
		if(event.getAction() == MotionEvent.ACTION_UP){
			isTouchReleased = true;
			if(!isAnimatingFadeIn){
				fadeOuteffect();
			}
		}else if(event.getAction() == MotionEvent.ACTION_DOWN){
			
			isTouchReleased = false;
			circleAlpha = DEFAULT_ALPHA;
			
			ValueGeneratorAnim valueGeneratorAnim = new ValueGeneratorAnim(new InterpolatedTimeCallback() {
				@Override
				public void onTimeUpdate(float interpolatedTime) {
					
					if(!isTouchReleased){
						circleAlpha =  MIN_ALPHA + (int) (DEFAULT_ALPHA * interpolatedTime);
						if(circleAlpha > DEFAULT_ALPHA )
							circleAlpha = DEFAULT_ALPHA;
					}
					view.invalidate();
				}
			});
			valueGeneratorAnim.setInterpolator(new AccelerateInterpolator(1.3f));
			valueGeneratorAnim.setAnimationListener(animationListner);
			valueGeneratorAnim.setDuration(DEFAULT_DURATION);
			view.startAnimation(valueGeneratorAnim);
		}
	
	}
	
	private void fadeOuteffect(){
		
		CURRENT_ALPHA = circleAlpha;
		
		ValueGeneratorAnim valueGeneratorAnim = new ValueGeneratorAnim(
				new InterpolatedTimeCallback() {
					@Override
					public void onTimeUpdate(float interpolatedTime) {
						circleAlpha = (int) (CURRENT_ALPHA - (CURRENT_ALPHA * interpolatedTime));
						view.invalidate();
					}
				});
		valueGeneratorAnim.setInterpolator(new DecelerateInterpolator(1.3f));
		valueGeneratorAnim.setDuration(DEFAULT_DURATION);
		view.startAnimation(valueGeneratorAnim);
		
	}
	
	public void onDw(Canvas canvas){

		circlePaint.setAlpha(circleAlpha);
		rectf.set(0, 0, view.getWidth(), view.getHeight());
		
		//circlePath.reset();	
		//circlePath.addRoundRect(rectf,DEFAULT_CORNER_RADIUS,DEFAULT_CORNER_RADIUS,Path.Direction.CW);
		
		canvas.drawRoundRect(rectf, DEFAULT_CORNER_RADIUS, DEFAULT_CORNER_RADIUS, circlePaint);
		
		//canvas.clipPath(circlePath);
		//canvas.drawCircle(downX, downY, radius, circlePaint);
		
	}
	
	private class ValueGeneratorAnim extends Animation {

		private InterpolatedTimeCallback interpolatedTimeCallback;
		
		ValueGeneratorAnim(InterpolatedTimeCallback interpolatedTimeCallback) {
			this.interpolatedTimeCallback = interpolatedTimeCallback;
			
		}
		
		@Override
		protected void applyTransformation(float interpolatedTime,Transformation t) {
			this.interpolatedTimeCallback.onTimeUpdate(interpolatedTime);
		}
		
	}

	private interface InterpolatedTimeCallback {
		public void onTimeUpdate(float interpolatedTime);
	}
	
}

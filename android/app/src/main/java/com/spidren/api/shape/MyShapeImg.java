package com.spidren.api.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;

public class MyShapeImg {
	
	public float scalex;
	public float height;
	public float width;
	public float scaley;
	public int x;
	public int y;
	public Matrix matrix = new Matrix(); 

	public void init(float scalex,float scaley,float x,float y) {
		this.scalex = scalex;
		this.scaley = scaley;
		this.x = (int)x;
		this.y = (int)y;
		
		matrix.reset();
		matrix.postScale(scalex,scaley);
		matrix.postTranslate(x,y);
		
	} 
	
	
	public void setPose(int width,int height,int x,int y){
		
	}
	public void setDown() {
		
	}
	
	public void setUp(){
		
	}
	
	public void draw(Canvas canvas){
		
	}
	
	public void setColor(int color){
		
	}
}

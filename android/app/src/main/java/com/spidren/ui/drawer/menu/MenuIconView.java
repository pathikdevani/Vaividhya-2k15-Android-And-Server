package com.spidren.ui.drawer.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.spidren.api.layout.MyImageView;
import com.spidren.api.shape.MyShapeImg;

public class MenuIconView extends MyImageView{

	private MyShapeImg shape; 
	private int size;
	
	public MenuIconView(Context context, int type, int size,int x, int y) {
		super(context, type, size, size, x, y);
		
		setWillNotDraw(false);
		this.size = size;
		
	}
	
	void setShape(MyShapeImg shape){
		this.shape = shape;
		
		shape.setPose(size/3, size/3 ,(size - size/3)/2, (size - size/3)/2);
		shape.setColor(Color.BLACK);
		invalidate();
	}
	
	public void setColor(int color){
		shape.setColor(color);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(shape != null)
			shape.draw(canvas);
	}

}

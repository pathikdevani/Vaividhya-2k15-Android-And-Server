package com.spidren.ui.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.spidren.api.layout.MyView;
import com.spidren.api.shape.MyShapeImg;

public class IconView extends MyView {

	private MyShapeImg shape;
	private float sizeFactor;

	public IconView(Context context, int type, MyShapeImg shape, int size, float sizeFacotr, int x, int y) {
		super(context, type, size, size, x, y);

		setRipple(true);
		setWillNotDraw(false);
		getRipple().setAtt(Color.WHITE, -1, 25, -1);

		this.shape = shape;
		this.sizeFactor = sizeFacotr;
		shape.setPose((int) (size * sizeFactor), (int) (size * sizeFactor), (int) (size - size * sizeFactor) / 2, (int) (size - size * sizeFactor) / 2);
		shape.setColor(Color.WHITE);
	}
	
	

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		shape.draw(canvas);
	}
	
	
	public void setColor(int color){
		shape.setColor(color);
	}

}
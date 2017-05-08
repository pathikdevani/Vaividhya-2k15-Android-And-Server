package com.spidren.ui.drawer.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.spidren.api.shape.MyShapeImg;

public class ListSearchShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(24.65f, 23.05f);
			lineTo(23.2f, 24.5f);
			quadTo(22f, 25.55f, 20.95f, 24.5f);
			lineTo(15.05f, 18.6f);
			quadTo(12.65f, 19.9f, 10f, 19.9f);
			quadTo(6.05f, 19.9f, 3.05f, 16.85f);
			quadTo(0f, 13.85f, 0f, 9.75f);
			quadTo(0f, 5.8f, 2.9f, 2.9f);
			quadTo(5.65f, 0f, 9.75f, 0f);
			quadTo(13.85f, 0f, 16.9f, 3f);
			quadTo(19.9f, 6.05f, 19.9f, 10f);
			quadTo(19.9f, 12.8f, 18.45f, 15.15f);
			lineTo(24.4f, 21.1f);
			quadTo(25.45f, 22.15f, 24.65f, 23.05f);
			moveTo(14.65f, 5.15f);
			quadTo(12.55f, 3f, 9.75f, 3f);
			quadTo(7f, 3f, 5f, 5f);
			quadTo(3.05f, 7f, 3.05f, 9.75f);
			quadTo(3.05f, 12.5f, 5.15f, 14.75f);
			quadTo(7.25f, 16.85f, 10f, 16.85f);
			quadTo(12.8f, 16.85f, 14.9f, 14.9f);
			quadTo(16.9f, 12.9f, 16.9f, 10f);
			quadTo(16.9f, 7.25f, 14.65f, 5.15f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public ListSearchShape() {
	}

	public ListSearchShape(int width, int height, int x, int y) {

		pos(width, height, x, y);

	}

	@Override
	public void setPose(int width, int height, int x, int y) {
		pos(width, height, x, y);
	}

	@Override
	public void setColor(int color) {
		P0.setColor(color);
	}

	public void pos(int width, int height, int x, int y) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		S0 = new Path0();
		S0.transform(matrix);
		P0.setColor(Color.parseColor("#ffffff"));
		P0.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
	}
}
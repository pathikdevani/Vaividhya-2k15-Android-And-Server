package com.spidren.ui.event.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.spidren.api.shape.MyShapeImg;

public class EventShareShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(23.4f, 4.3f);
			quadTo(23.4f, 6f, 22.1f, 7.15f);
			quadTo(20.95f, 8.4f, 19.25f, 8.4f);
			quadTo(17.85f, 8.4f, 16.7f, 7.5f);
			lineTo(9.5f, 11.85f);
			lineTo(9.6f, 12.55f);
			lineTo(9.5f, 13.25f);
			lineTo(16.7f, 17.45f);
			quadTo(17.75f, 16.65f, 19.25f, 16.65f);
			quadTo(20.95f, 16.65f, 22.1f, 17.8f);
			quadTo(23.4f, 19.1f, 23.4f, 20.8f);
			quadTo(23.4f, 22.5f, 22.1f, 23.65f);
			quadTo(20.95f, 24.95f, 19.25f, 24.95f);
			quadTo(17.5f, 24.95f, 16.4f, 23.65f);
			quadTo(15.1f, 22.5f, 15.1f, 20.8f);
			lineTo(15.1f, 20.45f);
			lineTo(15.1f, 20.1f);
			lineTo(8f, 15.75f);
			quadTo(6.85f, 16.65f, 5.45f, 16.65f);
			quadTo(3.75f, 16.65f, 2.6f, 15.4f);
			quadTo(1.35f, 14.25f, 1.35f, 12.55f);
			quadTo(1.35f, 10.8f, 2.6f, 9.65f);
			quadTo(3.75f, 8.4f, 5.45f, 8.4f);
			quadTo(6.95f, 8.4f, 8f, 9.2f);
			lineTo(15.1f, 4.95f);
			lineTo(15.1f, 4.6f);
			lineTo(15.1f, 4.3f);
			quadTo(15.1f, 2.55f, 16.4f, 1.4f);
			quadTo(17.5f, 0.15f, 19.25f, 0.15f);
			quadTo(20.95f, 0.15f, 22.1f, 1.3f);
			quadTo(23.4f, 2.55f, 23.4f, 4.3f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventShareShape() {
	}

	public EventShareShape(int width, int height, int x, int y) {

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
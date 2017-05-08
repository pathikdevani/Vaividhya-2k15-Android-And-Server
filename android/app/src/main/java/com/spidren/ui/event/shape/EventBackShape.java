package com.spidren.ui.event.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.spidren.api.shape.MyShapeImg;

public class EventBackShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(24.5f, 13.65f);
			lineTo(23.3f, 14.1f);
			lineTo(6.3f, 14.1f);
			lineTo(12.7f, 20.3f);
			quadTo(13.25f, 20.7f, 13.25f, 21.35f);
			quadTo(13.25f, 21.95f, 12.7f, 22.4f);
			quadTo(12.25f, 22.8f, 11.6f, 22.8f);
			quadTo(10.95f, 22.8f, 10.5f, 22.4f);
			lineTo(0.15f, 12.5f);
			lineTo(10.5f, 2.65f);
			quadTo(10.95f, 2.2f, 11.6f, 2.2f);
			quadTo(12.25f, 2.2f, 12.7f, 2.65f);
			quadTo(13.25f, 3.15f, 13.25f, 3.8f);
			quadTo(13.25f, 4.45f, 12.7f, 4.85f);
			lineTo(6.3f, 11.05f);
			lineTo(23.3f, 11.05f);
			quadTo(23.95f, 11.05f, 24.5f, 11.45f);
			quadTo(24.95f, 11.9f, 24.95f, 12.5f);
			quadTo(24.95f, 13.15f, 24.5f, 13.65f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventBackShape() {
	}

	public EventBackShape(int width, int height, int x, int y) {

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
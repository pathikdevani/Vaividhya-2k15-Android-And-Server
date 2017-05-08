package com.spidren.ui.event.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.spidren.api.shape.MyShapeImg;

public class EventTrueShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(24.3f, 7.45f);
			lineTo(10.6f, 20.85f);
			quadTo(9.95f, 21.5f, 9f, 21.5f);
			quadTo(8f, 21.5f, 7.3f, 20.85f);
			lineTo(0.65f, 14.35f);
			quadTo(0f, 13.7f, 0f, 12.75f);
			lineTo(0.05f, 12.75f);
			quadTo(0.05f, 11.75f, 0.7f, 11.1f);
			quadTo(1.45f, 10.45f, 2.35f, 10.45f);
			quadTo(3.3f, 10.45f, 3.95f, 11.1f);
			lineTo(9f, 16f);
			lineTo(21.05f, 4.2f);
			quadTo(21.7f, 3.55f, 22.7f, 3.55f);
			quadTo(23.65f, 3.55f, 24.3f, 4.2f);
			quadTo(25f, 4.85f, 25f, 5.8f);
			quadTo(25f, 6.8f, 24.3f, 7.45f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventTrueShape() {
	}

	public EventTrueShape(int width, int height, int x, int y) {

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